package br.com.tokiomarine.provatokio.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.tokiomarine.provatokio"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo())
				.globalResponseMessage(RequestMethod.GET, 
						Arrays.asList(
								new ResponseMessageBuilder()
									.code(500)
									.message("INTERNAL SERVER ERROR")
									.build(),
								new ResponseMessageBuilder()
									.code(403)
									.message("FORBIDDEN")
									.build(),
								new ResponseMessageBuilder()
									.code(404)
									.message("NOT FOUND")
									.build()));				
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Cielo", "http://www.tokiomarine.com.br", "suporte@tokiomarine.com.br");
		
		return new ApiInfoBuilder()
				.title("TokioMarine API Documentation")
				.description("")
				.version("1.0")
				.contact(contact)
				.build();
	}
}
