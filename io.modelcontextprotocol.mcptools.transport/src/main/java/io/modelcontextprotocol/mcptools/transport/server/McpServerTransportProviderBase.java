/*
 * Copyright 2024-2025 the original author or authors.
 */

package io.modelcontextprotocol.mcptools.transport.server;

import java.util.List;

public interface McpServerTransportProviderBase<A, M, F> {

	A notifyClients(String method, Object params);

	void setSessionFactory(F factory);

	void close();

	A closeGracefully();

	List<String> protocolVersions();

}
