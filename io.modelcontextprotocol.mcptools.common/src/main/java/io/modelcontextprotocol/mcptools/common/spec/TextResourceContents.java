package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Text resource contents
 */
public class TextResourceContents extends ResourceContents {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
