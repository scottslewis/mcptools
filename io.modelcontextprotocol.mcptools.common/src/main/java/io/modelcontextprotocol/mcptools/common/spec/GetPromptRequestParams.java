package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Get prompt request parameters
 */
public class GetPromptRequestParams extends RequestParams {
    private String name;
    private Map<String, String> arguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }
}
