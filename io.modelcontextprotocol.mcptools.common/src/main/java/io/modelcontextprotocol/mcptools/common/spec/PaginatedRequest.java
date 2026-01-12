package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Paginated request
 */
public class PaginatedRequest extends JSONRPCRequest {
	private PaginatedRequestParams params;

	public PaginatedRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(PaginatedRequestParams params) {
		this.params = params;
	}
}
