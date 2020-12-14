package org.example.designpattern.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    int index = 0;

    List<Filter> filters = new ArrayList<>();

    FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    int size() {
        return filters.size();
    }

    Filter get(int index) {
        return filters.get(index);
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filterChain.size()) {
            return true;
        }
        Filter filter = filterChain.get(index);
        index++;
        filter.doFilter(request, response, filterChain);
        return true;
    }
}
