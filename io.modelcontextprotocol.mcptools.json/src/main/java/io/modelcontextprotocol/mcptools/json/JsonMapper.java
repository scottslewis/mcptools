package io.modelcontextprotocol.mcptools.json;

import java.io.IOException;

public interface JsonMapper {

	<T> T readValue(String content, Class<T> type) throws IOException;

	<T> T readValue(String content, TypeRef<T> type) throws IOException;

	String writeValueAsString(Object value) throws IOException;

}
