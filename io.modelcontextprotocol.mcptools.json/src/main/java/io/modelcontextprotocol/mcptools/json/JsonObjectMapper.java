package io.modelcontextprotocol.mcptools.json;

import java.io.IOException;

public interface JsonObjectMapper {

	<T> T readValue(String content, Class<T> type) throws IOException;

	String writeValueAsString(Object value) throws IOException;

}
