package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Elicit request URL parameters
 */
public class ElicitRequestURLParams extends TaskAugmentedRequestParams {
	private String mode = "url";
	private String message;
	private String elicitationId;
	private String url;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getElicitationId() {
		return elicitationId;
	}

	public void setElicitationId(String elicitationId) {
		this.elicitationId = elicitationId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
