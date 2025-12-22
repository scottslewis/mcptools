package io.modelcontextprotocol.mcptools.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import java.lang.annotation.ElementType;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface McpResource {

	String name() default "";
	
	String title() default "";
	
	String description() default "";
	
	String uri() default "";
	
	String mimeType() default "text/plain";
}
