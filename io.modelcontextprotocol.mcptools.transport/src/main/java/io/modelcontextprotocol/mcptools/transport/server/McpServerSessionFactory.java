package io.modelcontextprotocol.mcptools.transport.server;

public interface McpServerSessionFactory<AsyncVoidType, ServerSessionType> {
	ServerSessionType create(McpServerTransport<AsyncVoidType> sessionTransport);
}
