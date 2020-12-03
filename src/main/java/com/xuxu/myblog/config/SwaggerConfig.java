package com.xuxu.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*****
 *  Swagger配置类
 *  @author Monster Xu
 *  @date 2020/9/22
 *****/

@Configuration  //指定这个类是配置类
@EnableSwagger2 //开启Swagger
public class SwaggerConfig {
    /**
     * Swagger页面介绍信息
     * @return
     */
    @Bean
    public Docket createRestAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定扫描API的包名
                .apis(RequestHandlerSelectors.basePackage("com.xuxu.myblog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Xu个人博客API")
                .description("个人博客后台接口API")
                .version("1.0")
                .license("这个License是啥？我不知道")
                .licenseUrl("licenseUrl又是啥？我也不知道")
                .termsOfServiceUrl("termsOfServiceUrl,我也不清楚")
                .build();
    }
}
