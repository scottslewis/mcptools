package io.modelcontextprotocol.mcptools.transport;

public interface JSONRPCRequest extends JSONRPCMessage {
	String method();

	Object id();

	Object params();
}
