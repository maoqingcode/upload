package com.mao.mapping;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class DiGuaHandlerMapping implements HandlerMapping {

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String url=request.getRequestURI().toString();
        String method=request.getMethod();
        if(url.startsWith("/tudou")){
            if(method.equalsIgnoreCase("GET")){
                //返回卖地瓜的handler伪代码
               // return "salle digua";
            }
        }
        return null;
    }
}
