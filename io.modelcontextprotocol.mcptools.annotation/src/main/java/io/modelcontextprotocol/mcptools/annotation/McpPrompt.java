package io.modelcontextprotocol.mcptools.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface McpPrompt {

	String name() default "";
	
	String title() default "";
	
	String description() default "";
	
}
