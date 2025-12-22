package io.modelcontextprotocol.mcptools.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface McpTool {

	String name() default "";
	
    String title() default "";

    String description() default "";

	McpAnnotations annotations() default @McpAnnotations;

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE)
	public @interface McpAnnotations {

		String title() default "";
		boolean readOnlyHint() default false;
		boolean destructiveHint() default true;
		boolean idempotentHint() default false;
		boolean openWorldHint() default true;
	}

}
