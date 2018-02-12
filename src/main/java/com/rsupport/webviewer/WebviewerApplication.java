package com.rsupport.webviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class WebviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebviewerApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rsupport.webviewer.web"))
                .paths(PathSelectors.any())
                .build();
//                .groupName("greetings")   --> 임시 주석
//                .apiInfo(apiInfo()) --> 복잡해지는 관계로 info 주석
//                .select()
//                .paths(regex("/greeting.*"))
//                .build();


//        .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(ResponseBody.class))
//                //.apis(RequestHandlerSelectors.basePackage("com.example.web.viewer"))
//                .paths(PathSelectors.any())
//                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger Title")
                .description("Spring REST Sample with Swagger Description")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
