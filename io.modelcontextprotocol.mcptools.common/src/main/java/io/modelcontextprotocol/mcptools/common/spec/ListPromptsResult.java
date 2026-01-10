package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * List prompts result
 */
public class ListPromptsResult extends PaginatedResult {
    private List<Prompt> prompts;

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }
}
