package io.modelcontextprotocol.mcptools.transport;

import java.util.List;

import io.modelcontextprotocol.mcptools.json.GenericTypeRef;

public interface McpTransport<AsyncVoidType> {

	void close();

	AsyncVoidType closeGracefully();

	AsyncVoidType sendMessage(JSONRPCMessage message);

	<T> T unmarshalFrom(Object data, GenericTypeRef<T> typeRef);

	List<String> protocolVersions();
}
