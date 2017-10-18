package net.ggum2.ggum2blog.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hyunsoo0813 on 2017. 9. 12..
 */
@Configuration
public class CustomWebSecurityFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (res.getStatus() != 200) {
            System.out.println("**********************************************");
            System.out.println(res.getStatus());
            System.out.println("**********************************************");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
