package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Implementation information
 */
public class Implementation implements BaseMetadata, Icons {
    private String name;
    private String title;
    private String version;
    private String description;
    private String websiteUrl;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
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
