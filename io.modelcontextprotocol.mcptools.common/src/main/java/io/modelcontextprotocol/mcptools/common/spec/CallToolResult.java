package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Call tool result
 */
public class CallToolResult implements Result {
    private List<ContentBlock> content;
    private Map<String, Object> structuredContent;
    private Boolean isError;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

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
