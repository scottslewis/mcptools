package io.modelcontextprotocol.mcptools.transport;

import java.util.List;

import io.modelcontextprotocol.mcptools.json.GenericTypeRef;

public interface McpTransport<A, M> {

	void close();

	A closeGracefully();

	A sendMessage(M message);

	<T> T unmarshalFrom(Object data, GenericTypeRef<T> typeRef);

	List<String> protocolVersions();
}
