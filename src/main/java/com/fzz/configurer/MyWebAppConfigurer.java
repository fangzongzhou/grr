package com.fzz.configurer;

import com.fzz.interceptor.My1Interceptor;
import com.fzz.interceptor.My2Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fzz on 2017/2/27.
 */
@Configuration//注解为配置类
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override//只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的
    public void addInterceptors(InterceptorRegistry registry) {
        /*多个拦截器组成一个拦截器链
        addPathPatterns 用于添加拦截规则
        excludePathPatterns 用户排除拦截*/
        registry.addInterceptor(new My1Interceptor()).addPathPatterns("/**");
        registry.addInterceptor(new My2Interceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override//添加静态文件夹,使其路径下的文件可被直接访问.可以直接为一个请求路径添加多个文件夹路径
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myfile/**").addResourceLocations("classpath:/myfile/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/" ).setViewName( "forward:/index.html" );
        super.addViewControllers(registry);
    }
}
