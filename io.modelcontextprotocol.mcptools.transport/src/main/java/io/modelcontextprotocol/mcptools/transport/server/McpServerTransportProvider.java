package io.modelcontextprotocol.mcptools.transport.server;

public interface McpServerTransportProvider<AsyncVoidType,ServerSessionType> extends McpServerTransportProviderBase<AsyncVoidType> {

	void setSessionFactory(McpServerSessionFactory<AsyncVoidType, ServerSessionType> factory);

}
