package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Elicit result
 */
public class ElicitResult implements Result {
	private String action;
	private Map<String, Object> content;
	private Map<String, Object> _meta;
	private Map<String, Object> additionalProperties;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map<String, Object> getContent() {
		return content;
	}

	public void setContent(Map<String, Object> content) {
		this.content = content;
	}

	@Override
	public Map<String, Object> get_meta() {
		return _meta;
	}

	@Override
	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}

	@Override
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	@Override
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
