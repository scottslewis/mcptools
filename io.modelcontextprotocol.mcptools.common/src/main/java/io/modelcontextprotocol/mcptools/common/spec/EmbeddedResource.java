package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Embedded resource content block
 */
public class EmbeddedResource implements ContentBlock {
    private String type = "resource";
    private ResourceContents resource;
    private Annotations annotations;
    private Map<String, Object> _meta;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResourceContents getResource() {
        return resource;
    }

    public void setResource(ResourceContents resource) {
        this.resource = resource;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Map<String, Object> get_meta() {
        return _meta;
    }

    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }
}
