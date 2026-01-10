package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Create message request parameters
 */
public class CreateMessageRequestParams extends TaskAugmentedRequestParams {
    private List<SamplingMessage> messages;
    private ModelPreferences modelPreferences;
    private String systemPrompt;
    private String includeContext;
    private Double temperature;
    private int maxTokens;
    private List<String> stopSequences;
    private Object metadata;
    private List<Tool> tools;
    private ToolChoice toolChoice;

    public List<SamplingMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<SamplingMessage> messages) {
        this.messages = messages;
    }

    public ModelPreferences getModelPreferences() {
        return modelPreferences;
    }

    public void setModelPreferences(ModelPreferences modelPreferences) {
        this.modelPreferences = modelPreferences;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public String getIncludeContext() {
        return includeContext;
    }

    public void setIncludeContext(String includeContext) {
        this.includeContext = includeContext;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public List<String> getStopSequences() {
        return stopSequences;
    }

    public void setStopSequences(List<String> stopSequences) {
        this.stopSequences = stopSequences;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public ToolChoice getToolChoice() {
        return toolChoice;
    }

    public void setToolChoice(ToolChoice toolChoice) {
        this.toolChoice = toolChoice;
    }
}
