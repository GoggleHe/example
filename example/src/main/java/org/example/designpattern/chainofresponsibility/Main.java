package org.example.designpattern.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.msg = "request";
        Response response = new Response();
        response.msg = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter()).add(new URLFilter());

        chain.doFilter(request, response, chain);

        System.out.println(request.msg);
        System.out.println(response.msg);
    }
}
