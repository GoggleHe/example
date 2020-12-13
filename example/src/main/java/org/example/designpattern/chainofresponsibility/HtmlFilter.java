package org.example.designpattern.chainofresponsibility;

public class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.msg += "HTML(req)";
        chain.doFilter(request, response, chain);
        response.msg += "HTML(res)";
        return true;
    }
}
