package kosta.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Demo")
                .description("API EXAMPLE")
                .build();
    }
	
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("example")
                .apiInfo(this.apiInfo())
        		.select()
                .apis(RequestHandlerSelectors
                        .basePackage("kosta.mvc.controller"))
                .paths(PathSelectors.ant("/**")).build();
    }
}