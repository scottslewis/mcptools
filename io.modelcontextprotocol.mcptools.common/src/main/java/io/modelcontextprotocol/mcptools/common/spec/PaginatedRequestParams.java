package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Paginated request parameters
 */
public class PaginatedRequestParams extends RequestParams {
    private Cursor cursor;

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
