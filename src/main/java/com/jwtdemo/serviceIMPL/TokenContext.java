package com.jwtdemo.serviceIMPL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenContext {
	private static ThreadLocal<Map<String, List<String>>> context = new ThreadLocal<>();

	private static final String FUNCTION = "FUNCITON";

	private static Map<String, List<String>> getContext() {
		if (context.get() == null) {
			context.set(new HashMap<>());
		}
		return context.get();
	}

	public static List<String> getFunctions() {
		return getContext().get(FUNCTION);
	}

	public static void setFunctions(List<String> functions) {
		getContext().put(FUNCTION, functions);
	}

}
