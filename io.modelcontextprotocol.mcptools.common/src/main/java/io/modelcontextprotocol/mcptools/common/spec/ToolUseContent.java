package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Tool use content block
 */
public class ToolUseContent {
	private String type = "tool_use";
	private String id;
	private String name;
	private Map<String, Object> input;
	private Map<String, Object> _meta;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getInput() {
		return input;
	}

	public void setInput(Map<String, Object> input) {
		this.input = input;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}
}
