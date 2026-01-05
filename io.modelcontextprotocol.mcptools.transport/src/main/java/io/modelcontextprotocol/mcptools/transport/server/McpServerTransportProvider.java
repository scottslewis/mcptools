package io.modelcontextprotocol.mcptools.transport.server;

public interface McpServerTransportProvider<AsyncVoidType> extends McpServerTransportProviderBase<AsyncVoidType> {

	void setSessionFactory(McpServerSessionFactory factory);
	
}
