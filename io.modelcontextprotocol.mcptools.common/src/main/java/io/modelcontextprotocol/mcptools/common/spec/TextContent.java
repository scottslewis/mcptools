package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Text content block
 */
public class TextContent implements ContentBlock {
    private String type = "text";
    private String text;
    private Annotations annotations;
    private Map<String, Object> _meta;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
