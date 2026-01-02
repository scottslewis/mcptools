package org.springaicommunity.mcp.provider;

import java.lang.reflect.Method;

import org.springaicommunity.mcp.method.tool.utils.JsonSchemaGenerator;

import io.modelcontextprotocol.mcptools.toolgroup.InputSchemaGenerator;

public class SpringInputSchemaGenerator implements InputSchemaGenerator {

	@Override
	public String generateInputSchema(Method mcpToolMethod) {
		return JsonSchemaGenerator.generateForMethodInput(mcpToolMethod);
	}

}
