package org.springaicommunity.mcp.provider.transport;

import java.io.IOException;

import io.modelcontextprotocol.json.McpJsonDefaults;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.mcptools.json.JsonObjectMapper;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.JSONRPCMessage;

public class SpringJsonObjectMapper implements JsonObjectMapper {

	@Override
	public <T> T readValue(String content, Class<T> type) throws IOException {
		return McpJsonDefaults.getDefaultMcpJsonMapper().readValue(content, type);
	}

	@Override
	public String writeValueAsString(Object value) throws IOException {
		return McpJsonDefaults.getDefaultMcpJsonMapper().writeValueAsString(value);
	}

	public JSONRPCMessage deserializeJsonRpcMessage(String data) throws IOException {
		return McpSchema.deserializeJsonRpcMessage(McpJsonDefaults.getDefaultMcpJsonMapper(), data);
	}

	public <T> T unmarshalFrom(Object data, TypeRef<T> typeRef) {
		return McpJsonDefaults.getDefaultMcpJsonMapper().convertValue(data, typeRef);
	}

}
