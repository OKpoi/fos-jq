package com.fos.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.fos.common.Constant.LINRESOURCESPATH;
import static com.fos.common.Constant.WINRESOURCESPATH;


/**
 * @author lomofu
 */
@Configuration
public class WebConfigration implements WebMvcConfigurer {

    private static final String WIN = "win";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        if (System.getProperty("os.name").toLowerCase().startsWith(WIN)) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:" + WINRESOURCESPATH);
        } else {
            registry.addResourceHandler("/images/**").addResourceLocations("file:" + LINRESOURCESPATH);
        }
    }
}
