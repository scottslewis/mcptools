package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Cursor type for pagination
 */
public class Cursor {
    private final String value;

    public Cursor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
