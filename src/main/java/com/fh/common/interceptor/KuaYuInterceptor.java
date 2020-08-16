package com.fh.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KuaYuInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的域名
        String header = request.getHeader("Origin");
        //允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加然后就可以解决跨域问题
        response.setHeader("Access-Control-Allow-Origin",header);



        return true;
    }
}
