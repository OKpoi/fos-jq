package com.fos.configration;

import static com.fos.common.Constant.LINRESOURCESPATH;
import static com.fos.common.Constant.WINRESOURCESPATH;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author lomofu
 */
@Slf4j
@Configuration
public class WebConfigration implements WebMvcConfigurer {

    private static final String WIN = "win";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        if (System.getProperty("os.name").toLowerCase().startsWith(WIN)) {
            createRourcesPath(WINRESOURCESPATH);
            registry.addResourceHandler("/images/**").addResourceLocations("file:" + WINRESOURCESPATH);
        } else {
            createRourcesPath(LINRESOURCESPATH);
            registry.addResourceHandler("/images/**").addResourceLocations("file:" + LINRESOURCESPATH);
        }
    }

    private void createRourcesPath(String path) {
        File file = new File(path + "/");
        if (!file.isDirectory()) {
            log.error("==========================================");
            log.error(" 文件目录创建失败,请检查文件路径是否填写正常!");
            log.error(" 或手动创建目录:" + path);
            log.error("==========================================");
        } else {
            if (!file.exists()) {
                log.warn(" ********************资源文件目录不存在!*********************");
                log.warn("===================正在创建==================");
                file.mkdirs();
                log.warn("  资源路径:" + path);
                log.warn("===================创建成功==================");
                log.warn(" *********************************************************");
            } else {
                log.info(" ********************资源文件目录已存在!*********************");
                log.info("==========================================");
                log.info("  资源路径:" + path);
                log.info("==========================================");
                log.info(" *********************************************************");
            }
        }
    }

}
