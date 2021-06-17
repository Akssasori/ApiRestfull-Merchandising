package br.com.lucas.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket merchanApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.lucas"))
				.paths(regex("/api/v1.*"))
				.build()
				.apiInfo(metaInfo());
		
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Apoio Merchan API REST",
				"API REST de cadastro de acoes.",
				"1.0",
				"Terms of Service",
				new Contact("Lucas Diniz", "https://lucas.diniz.com.br",
						"lucas.diniz@g.globo"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
				);
			return apiInfo;
	}
	
	

}



