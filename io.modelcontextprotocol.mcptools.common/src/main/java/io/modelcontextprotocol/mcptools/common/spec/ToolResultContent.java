package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Tool result content block
 */
public class ToolResultContent {
	private String type = "tool_result";
	private String toolUseId;
	private List<ContentBlock> content;
	private Map<String, Object> structuredContent;
	private Boolean isError;
	private Map<String, Object> _meta;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToolUseId() {
		return toolUseId;
	}

	public void setToolUseId(String toolUseId) {
		this.toolUseId = toolUseId;
	}

	public List<ContentBlock> getContent() {
		return content;
	}

	public void setContent(List<ContentBlock> content) {
		this.content = content;
	}

	public Map<String, Object> getStructuredContent() {
		return structuredContent;
	}

	public void setStructuredContent(Map<String, Object> structuredContent) {
		this.structuredContent = structuredContent;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}
}
