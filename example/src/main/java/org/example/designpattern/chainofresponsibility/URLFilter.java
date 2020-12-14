package org.example.designpattern.chainofresponsibility;

public class URLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response,FilterChain chain) {
        request.msg += "Url(req)";
        chain.doFilter(request, response, chain);
        response.msg += "Url(res)";
        return false;
    }
}
