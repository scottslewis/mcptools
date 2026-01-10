package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Base result interface
 */
public interface Result {
    Map<String, Object> get_meta();
    void set_meta(Map<String, Object> _meta);
    
    Map<String, Object> getAdditionalProperties();
    void setAdditionalProperties(Map<String, Object> additionalProperties);
}

