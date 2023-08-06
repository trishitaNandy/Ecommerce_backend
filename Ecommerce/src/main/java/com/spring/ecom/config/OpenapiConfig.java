package com.spring.ecom.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info=@Info(
				contact= @Contact(
						name="Trishita Nandy",
						email="trishitanandy7@gmail.com",
						url="https://trishitanandy-portfolio.netlify.app/"
				),
				description= "Ecommerce API documentation",
				title="Ecommerce RESTful API- Trishita Nandy",
				version= "1.0",
				license= @License(
						name="License name",
						url="https://some-url.com"
				),
				termsOfService="Terms of service"
				
		),
		servers= {
				@Server(
						description="Local ENV",
						url="http://localhost:8080"
				),
				@Server(
						description="PROD ENV",
						url="https://trishitanandy-portfolio.netlify.app/"
				)
		}
		
)
public class OpenapiConfig {
	
}
