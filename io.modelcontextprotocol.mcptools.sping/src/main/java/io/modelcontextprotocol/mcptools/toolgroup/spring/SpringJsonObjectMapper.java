package io.modelcontextprotocol.mcptools.toolgroup.spring;

import java.io.IOException;

import io.modelcontextprotocol.json.McpJsonDefaults;
import io.modelcontextprotocol.mcptools.json.JsonObjectMapper;

public class SpringJsonObjectMapper implements JsonObjectMapper {

	@Override
	public <T> T readValue(String content, Class<T> type) throws IOException {
		return McpJsonDefaults.getDefaultMcpJsonMapper().readValue(content, type);
	}

	@Override
	public String writeValueAsString(Object value) throws IOException {
		return McpJsonDefaults.getDefaultMcpJsonMapper().writeValueAsString(value);
	}

}
