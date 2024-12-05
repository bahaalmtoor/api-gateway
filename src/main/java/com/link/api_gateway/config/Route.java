package com.link.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class Route {
	
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/items/**").uri("http://localhost:8181"))
				.route(r -> r.path("/carts/**").uri("http://localhost:8282"))
				.route(r -> r.path("/item-service/v3/api-docs").and().method(HttpMethod.GET).uri("http://localhost:8181/item-service"))
				.route(r -> r.path("/cart-service/v3/api-docs").and().method(HttpMethod.GET).uri("http://localhost:8282/cart-service"))
				.build();
	}
}
