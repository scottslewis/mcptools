package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Base notification parameters
 */
public class NotificationParams {
    private Map<String, Object> _meta;

    public Map<String, Object> get_meta() {
        return _meta;
    }

    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }
}
