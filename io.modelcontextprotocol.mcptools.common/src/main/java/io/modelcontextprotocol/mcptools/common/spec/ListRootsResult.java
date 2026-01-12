package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * List roots result
 */
public class ListRootsResult implements Result {
	private List<Root> roots;
	private Map<String, Object> _meta;
	private Map<String, Object> additionalProperties;

	public List<Root> getRoots() {
		return roots;
	}

	public void setRoots(List<Root> roots) {
		this.roots = roots;
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
