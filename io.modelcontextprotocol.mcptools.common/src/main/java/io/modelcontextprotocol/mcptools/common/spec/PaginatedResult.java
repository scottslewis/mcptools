package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Paginated result
 */
public class PaginatedResult implements Result {
    private Cursor nextCursor;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

    public Cursor getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(Cursor nextCursor) {
        this.nextCursor = nextCursor;
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
