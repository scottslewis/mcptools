package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Call tool request parameters
 */
public class CallToolRequestParams extends TaskAugmentedRequestParams {
    private String name;
    private Map<String, Object> arguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }
}

