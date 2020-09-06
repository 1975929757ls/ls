package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //Access-Control-Allow-Origin:访问控制允许源，*表示任意域名
                .allowedOrigins("*")
                //Access-Control-Allow-Methods
                //一个逗号分隔的列表，表明服务器支持的请求类型（比如：GET, POST,PUT,DELETE,HEAD,OPTIONS）
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                //Access-Control-Allow-Credentials:访问控制允许凭据
                //它的值只有一个就是 true。跨站点带验证信息时，服务器必须要争取设置这个值，服务器才能获取到用户的cookie。
                .allowCredentials(true)
                //准备响应前的缓存持续的最大时间（以秒为单位）
                .maxAge(3600)
                //Access-Control-Allow-Headers
                //提供一个逗号分隔的列表,表示服务器支持的请求数据类型。
                .allowedHeaders("*");
    }
}
