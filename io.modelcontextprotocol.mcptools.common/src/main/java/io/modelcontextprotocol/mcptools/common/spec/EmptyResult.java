package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Empty result
 */
public class EmptyResult implements Result {
	private Map<String, Object> _meta;
	private Map<String, Object> additionalProperties;

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
