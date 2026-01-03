package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;

import io.modelcontextprotocol.mcptools.json.JsonObjectMapper;

public abstract class AbstractOutputSchemaGenerator<TypeType> implements OutputSchemaGenerator {

	protected JsonObjectMapper mapper;
	
	public AbstractOutputSchemaGenerator() {
	}
	
	protected void setJsonObjectMapper(JsonObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public String generateOutputSchema(Method mcpToolMethod) {
		TypeType returnTypeArgument = getReturnTypeArgument(mcpToolMethod);
		if (returnTypeArgument != null) {
			return generateOutputSchema(returnTypeArgument);
		}
		return null;
	}

	protected abstract TypeType getReturnTypeArgument(Method mcpToolMethod);

	protected abstract String generateOutputSchema(TypeType returnTypeArgument);
}
