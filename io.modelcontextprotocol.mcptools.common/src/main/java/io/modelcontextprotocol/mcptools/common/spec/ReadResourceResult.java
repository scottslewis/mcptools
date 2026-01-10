package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Read resource result
 */
public class ReadResourceResult implements Result {
    private List<ResourceContents> contents;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

    public List<ResourceContents> getContents() {
        return contents;
    }

    public void setContents(List<ResourceContents> contents) {
        this.contents = contents;
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
