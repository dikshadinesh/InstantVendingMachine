package com.wissen.instantvendingmachine.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Instant Vending Machine Java Rest API")
				.contact(new Contact("Instant Vending Machinet", "https://www.InstantVendingMachine.com", null))
				.build();
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.wissen.instantvendingmachine.controller")).build()
				.apiInfo(metaData());
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().useBasicAuthenticationWithAccessCodeGrant(true).build();
	}
}
