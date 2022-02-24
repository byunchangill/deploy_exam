package com.koreait.deploy;

import javax.servlet.*;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding= filterConfig.getInitParameter("encoding");
        if(this.encoding==null) this.encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(this.encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
