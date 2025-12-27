package io.modelcontextprotocol.mcptools.json;

import java.io.IOException;

public interface JsonReaderWriter {

	<T> T readValue(String content, Class<T> type) throws IOException;

	<T> T readValue(String content, GenericTypeRef<T> type) throws IOException;

	String writeValueAsString(Object value) throws IOException;

}
