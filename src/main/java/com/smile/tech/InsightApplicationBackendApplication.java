package com.smile.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InsightApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsightApplicationBackendApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.smile.tech")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("INSIGHT-MIRROR-BACKEND")
				.description("This page lists all the rest apis for insight Application app.").version("1.0-SNAPSHOT")
				.build();
	}
}
