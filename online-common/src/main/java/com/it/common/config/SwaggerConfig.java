package com.it.common.config;

import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * \* author: czw
 * \* email: 1662279084@qq.com
 * \* Date: 2022/8/24
 * \* Version:
 * \* Description:
 * \
 */
public class SwaggerConfig {
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("io.renren.modules.job.controller"))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("Renren"))
                .directModelSubstitute(java.util.Date.class, String.class)
                .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("人人开源")
                .description("renren-admin文档")
                .termsOfServiceUrl("https://www.renren.io")
                .version("5.x")
                .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey(Constant.TOKEN_HEADER, Constant.TOKEN_HEADER, "header")
        );
    }
}