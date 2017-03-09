package com.fzz;

import com.fzz.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by fzz on 2017/2/27.
 */
@SpringBootApplication
@ServletComponentScan//扫描web*注解声明的servlet,filter,listener类
public class Aplication {

    @Bean//获取->更改->返回  达到修改本体的dispatcherServlet的效果
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        /*registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");*/
        return registration;
    }

    @Bean
    public ServletRegistrationBean myServletRegistration() {
        return new ServletRegistrationBean(new MyServlet(),"/myservlet/*");//ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args) {
        System.out.println("my web will be build , please waiting.");
        SpringApplication.run(Aplication.class,args);
    }
}
