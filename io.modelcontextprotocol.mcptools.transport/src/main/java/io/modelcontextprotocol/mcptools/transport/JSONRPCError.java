package io.modelcontextprotocol.mcptools.transport;

public interface JSONRPCError {
	Integer code();

	String message();

	Object data();
}
