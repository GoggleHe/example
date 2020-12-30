package org.example.network.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        //连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(10);
        cm.setMaxTotal(10);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(3000).build();

        //https设置
        SSLContext sslContext = SSLContext.getInstance("SSL");
        TrustManager[] tm = {new MyX509TrustManager()};//初始化
        sslContext.init(null, tm, new java.security.SecureRandom());

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .setSSLHostnameVerifier(new MyX509TrustManager.TrustAnyHostnameVerifier())
                .setSSLContext(sslContext)
                .build();
        HttpUriRequest request = RequestBuilder.create("GET")
                .setUri("http://www.baidu.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("connection", "Keep-Alive")
                .addHeader("Accept-Charset", "utf-8")
                .addHeader("accept", "*/*")
                .build();
        CloseableHttpResponse response = httpClient.execute(request);
        String s = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
