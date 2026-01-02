package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;

public interface InputSchemaGenerator {

	String generateInputSchema(Method mcpToolMethod);
}
