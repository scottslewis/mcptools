package io.modelcontextprotocol.mcptools.transport;

public interface JSONRPCNotification extends JSONRPCMessage {

	String method();
	Object params();
}
