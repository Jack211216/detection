//package com.detection.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author ding
// * @Date 2021/12/20
// */
//@Configuration
//public class CorsConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//
//                .allowedOrigins("*")
//
//                .allowCredentials(true)
//
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//
//                .maxAge(3600);
//
//    }
//
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//
//        List<String> list = new ArrayList<>();
//
//        list.add("*");
//
//        corsConfiguration.setAllowedOrigins(list);
//
//        corsConfiguration.addAllowedOrigin("*"); // 1
//
//        corsConfiguration.addAllowedHeader("*"); // 2
//
//        corsConfiguration.addAllowedMethod("*"); // 3
//
//        return corsConfiguration;
//
//    }
//
//    @Bean
//
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new                                                                       UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**", buildConfig()); // 4
//
//        return new CorsFilter(source);
//
//    }
//}
