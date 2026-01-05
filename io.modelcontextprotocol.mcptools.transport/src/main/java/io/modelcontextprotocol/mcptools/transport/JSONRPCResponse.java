package io.modelcontextprotocol.mcptools.transport;

public interface JSONRPCResponse extends JSONRPCMessage {
	Object id();

	Object result();

	JSONRPCError error();
}
