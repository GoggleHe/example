package org.example.designpattern.chainofresponsibility;

public interface Filter {
    boolean doFilter(Request request, Response response,FilterChain filterChain);
}
