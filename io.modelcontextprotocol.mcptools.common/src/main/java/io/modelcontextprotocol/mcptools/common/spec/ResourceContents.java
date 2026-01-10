package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Base resource contents
 */
public abstract class ResourceContents {
    private String uri;
    private String mimeType;
    private Map<String, Object> _meta;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Map<String, Object> get_meta() {
        return _meta;
    }

    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }
}
