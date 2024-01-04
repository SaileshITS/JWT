package com.jwtdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = ResourceNotPermitted.class)
	public ResponseEntity<Response> handle(ResourceNotPermitted ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new Response(ex.getMessage(), "UnAuthorized", "400"));
	}

	@AllArgsConstructor
	@Builder
	@Data
	public static class Response {
		String message;
		String error;
		String code;
	}
}
