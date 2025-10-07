package com.mycompany.academiaapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration.
 * @author wesia
 */
@OpenAPIDefinition(info = @Info(title = "Academia API", version = "v1", description = "API REST para gestão de academia"))
@Configuration
public class OpenApiConfig {}
