package io.modelcontextprotocol.mcptools.common.spec;

public final class JSONRPCConstants {
	private JSONRPCConstants() {
		// Prevent instantiation
	}

	public static final String LATEST_PROTOCOL_VERSION = "2025-11-25";
	public static final String JSONRPC_VERSION = "2.0";

	// JSON-RPC error codes
	public static final int PARSE_ERROR = -32700;
	public static final int INVALID_REQUEST = -32600;
	public static final int METHOD_NOT_FOUND = -32601;
	public static final int INVALID_PARAMS = -32602;
	public static final int INTERNAL_ERROR = -32603;

	// Custom error codes
	public static final int URL_ELICITATION_REQUIRED = -32042;
}
