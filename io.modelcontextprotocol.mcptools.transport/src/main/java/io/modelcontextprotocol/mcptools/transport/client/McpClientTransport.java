package io.modelcontextprotocol.mcptools.transport.client;

import java.util.function.Consumer;
import java.util.function.Function;

import io.modelcontextprotocol.mcptools.transport.McpTransport;

public interface McpClientTransport<A, M, T, R> extends McpTransport<A, M> {

	A connect(Function<T, R> handler);

	default void setExceptionHandler(Consumer<Throwable> handler) {
	}

}
