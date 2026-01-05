package io.modelcontextprotocol.mcptools.transport.server;

import java.util.List;

public interface McpServerTransportProviderBase<AsyncVoidType> {

	AsyncVoidType notifyClients(String method, Object params);

	void close();

	AsyncVoidType closeGracefully();

	List<String> protocolVersions();
}
