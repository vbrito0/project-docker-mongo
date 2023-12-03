package com.teste.fast.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.teste.fast.FastApplication;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(FastApplication.class)
public class SwaggerConfig {

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.teste.fast"))
          .paths(PathSelectors.ant("/**"))
          .build()
          .securityContexts(Arrays.asList(securityContext()))
          .securitySchemes(Arrays.asList(new ApiKey("JWT", "Authorization", "header")));
    }

    @SuppressWarnings("deprecation")
	private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/**")).build();
    }

    List<SecurityReference> defaultAuth() {
        return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[]{ new AuthorizationScope("global", "accessEverything") }));
    }
}
