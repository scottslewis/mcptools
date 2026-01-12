package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Sampling message
 */
public class SamplingMessage {
	private Role role;
	private Object content; // Can be single SamplingMessageContentBlock or
							// List<SamplingMessageContentBlock>
	private Map<String, Object> _meta;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public SamplingMessageContentBlock getContentAsSingle() {
		if (content instanceof SamplingMessageContentBlock) {
			return (SamplingMessageContentBlock) content;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SamplingMessageContentBlock> getContentAsList() {
		if (content instanceof List) {
			return (List<SamplingMessageContentBlock>) content;
		}
		return null;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}
}
