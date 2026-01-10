package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Root definition
 */
public class Root {
    private String uri;
    private String name;
    private Map<String, Object> _meta;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> get_meta() {
        return _meta;
    }

    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }
}
