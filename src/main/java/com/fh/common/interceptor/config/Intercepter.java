package com.fh.common.interceptor.config;

import com.fh.common.interceptor.KuaYuInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器的配置   拦截那些东西  不拦截那些东西
@Configuration//声明是配置文件类@Configuration
public class Intercepter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration kuayu = registry.addInterceptor(new KuaYuInterceptor());
        kuayu.addPathPatterns("/**");                      //所有路径都被拦截

    }

   /* @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        return servletServletRegistrationBean;
    }*/
   @Override
   public void configurePathMatch(PathMatchConfigurer configurer) {
       configurer.setUseSuffixPatternMatch(true)	//设置是否是后缀模式匹配,即:/test.*
               .setUseTrailingSlashMatch(true);	//设置是否自动后缀路径模式匹配,即：/test/
   }


}
