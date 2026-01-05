package io.modelcontextprotocol.mcptools.transport.client;

import java.util.function.Consumer;
import java.util.function.Function;

import io.modelcontextprotocol.mcptools.transport.McpTransport;

public interface McpClientTransport<AsyncVoidType, AsyncRPCMessageType> extends McpTransport<AsyncVoidType> {

	AsyncVoidType connect(Function<AsyncRPCMessageType,AsyncRPCMessageType> handler);

	default void setExceptionHandler(Consumer<Throwable> handler) {
	}
}
