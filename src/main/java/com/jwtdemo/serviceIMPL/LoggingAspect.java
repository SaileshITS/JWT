package com.jwtdemo.serviceIMPL;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.jwtdemo.annotation.Allow;
import com.jwtdemo.exceptions.ResourceNotPermitted;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Around("@annotation(com.jwtdemo.annotation.Allow)")
	public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("Inside LoggingAspect Our Custom Login ");
		Signature signature = joinPoint.getSignature();

		Object result = null;

		if (signature instanceof MethodSignature) {
			MethodSignature methodSignature = (MethodSignature) signature;
			Method method = methodSignature.getMethod();

			Allow allow = method.getAnnotation(Allow.class);
			String function = allow.function();
			String operation = allow.operation();
			List<String> functions = TokenContext.getFunctions();
			boolean contains = TokenContext.getFunctions().contains(function + "_" + operation);
			if (functions.contains("ALL")) {
				result = joinPoint.proceed();
				return result;
			} else if (contains) {
				result = joinPoint.proceed();
				return result;
			} else {
				throw new ResourceNotPermitted("You are not Permitted to access this Resource");
			}

		}

		return result;
	}
}
