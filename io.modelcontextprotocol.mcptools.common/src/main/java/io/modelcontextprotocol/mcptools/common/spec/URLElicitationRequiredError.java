package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * URL elicitation required error
 */
public class URLElicitationRequiredError {
	private String jsonrpc = JSONRPCConstants.JSONRPC_VERSION;
	private RequestId id;
	private URLElicitationError error;

	public String getJsonrpc() {
		return jsonrpc;
	}

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public RequestId getId() {
		return id;
	}

	public void setId(RequestId id) {
		this.id = id;
	}

	public URLElicitationError getError() {
		return error;
	}

	public void setError(URLElicitationError error) {
		this.error = error;
	}

	public static class URLElicitationError extends Error {
		private URLElicitationData data;

		@Override
		public int getCode() {
			return JSONRPCConstants.URL_ELICITATION_REQUIRED;
		}

		@Override
		public URLElicitationData getData() {
			return data;
		}

		public void setData(URLElicitationData data) {
			this.data = data;
		}
	}

	public static class URLElicitationData {
		private List<ElicitRequestURLParams> elicitations;
		private Map<String, Object> additionalProperties;

		public List<ElicitRequestURLParams> getElicitations() {
			return elicitations;
		}

		public void setElicitations(List<ElicitRequestURLParams> elicitations) {
			this.elicitations = elicitations;
		}

		public Map<String, Object> getAdditionalProperties() {
			return additionalProperties;
		}

		public void setAdditionalProperties(Map<String, Object> additionalProperties) {
			this.additionalProperties = additionalProperties;
		}
	}
}
