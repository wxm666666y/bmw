package com.bmw.seed.advice;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                //用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(new ApiInfoBuilder().title("swagger接口文档")
                        .version("1.0")
                        .build())
                .pathMapping("/")
                //设置哪些接口暴露给Swagger展示，以下默认写法，表示controller层添加注解展示
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).apis(RequestHandlerSelectors.basePackage("com"))
                .build()
                .globalOperationParameters(globalOperation());       // 主要关注点----每个接口调用都填写token
    }

    // 为每个接口单独增加token参数,这个是我们为了解决在header中传输token的问题，没有的话可以忽略，即不用这个方法
    private List<Parameter> globalOperation() {
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //第一个token为传参的key，第二个token为swagger页面显示的值
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return pars;
    }

}