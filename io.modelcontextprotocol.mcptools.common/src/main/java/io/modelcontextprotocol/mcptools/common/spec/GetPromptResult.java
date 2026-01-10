package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Get prompt result
 */
public class GetPromptResult implements Result {
    private String description;
    private List<PromptMessage> messages;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PromptMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PromptMessage> messages) {
        this.messages = messages;
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
