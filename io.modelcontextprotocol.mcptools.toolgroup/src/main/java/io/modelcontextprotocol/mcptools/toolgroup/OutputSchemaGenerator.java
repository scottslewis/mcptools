package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;

public interface OutputSchemaGenerator {

	String generateOutputSchema(Method mcpToolMethod);

}
