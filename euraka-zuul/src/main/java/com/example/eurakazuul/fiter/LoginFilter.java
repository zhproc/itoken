package com.example.eurakazuul.fiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (token == null){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                HttpServletResponse response = requestContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                requestContext.getResponse().getWriter().write("请求错误");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
