//package config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// *
// * @author josue
// */
//@Configuration
//public class GlobalCorsConfig {
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> customCorsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        
//        // 1. Permitir credenciales (cookies, headers de autorización)
//        config.setAllowCredentials(true);
//        // 2. El puerto exacto de tu React
//        config.addAllowedOrigin("http://localhost:5173");
//        // 3. Permitir CUALQUIER header y método (GET, POST, OPTIONS, etc.)
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        
//        source.registerCorsConfiguration("/**", config);
//        
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
//        
//        // 🟢 LA OPCIÓN NUCLEAR: Este filtro se ejecuta antes que CUALQUIER otra cosa en el servidor
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
//}
