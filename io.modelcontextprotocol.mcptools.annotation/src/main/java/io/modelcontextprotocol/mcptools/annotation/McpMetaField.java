package io.modelcontextprotocol.mcptools.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.modelcontextprotocol.mcptools.annotation.McpMetaField.McpMetaFields;

import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(McpMetaFields.class)
public @interface McpMetaField {

    String prefix() default "";

    String name();

    Type type() default Type.STRING;

    String value();

    enum Type {
         STRING,
        INT,
        BOOLEAN,
        JSON
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface McpMetaFields {

        McpMetaField[] value();

    }
}
