package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Resource template definition
 */
public class ResourceTemplate implements BaseMetadata, Icons {
    private String name;
    private String title;
    private String uriTemplate;
    private String description;
    private String mimeType;
    private Annotations annotations;
    private Map<String, Object> _meta;
    private List<Icon> icons;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUriTemplate() {
        return uriTemplate;
    }

    public void setUriTemplate(String uriTemplate) {
        this.uriTemplate = uriTemplate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
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

    @Override
    public List<Icon> getIcons() {
        return icons;
    }

    @Override
    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }
}
