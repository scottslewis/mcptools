package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Create message result
 */
public class CreateMessageResult extends SamplingMessage implements Result {
	private String model;
	private String stopReason;
	private Map<String, Object> _meta;
	private Map<String, Object> additionalProperties;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
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
