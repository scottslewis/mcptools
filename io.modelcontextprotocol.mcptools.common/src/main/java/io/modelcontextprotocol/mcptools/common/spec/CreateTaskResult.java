package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Create task result
 */
public class CreateTaskResult implements Result {
    private Task task;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public Map<String, Object> get_meta() {
        return _meta;
    }

    @Override
    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
