package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;
/**
 * Base request interface
 */
public interface Request {
    String getMethod();
    void setMethod(String method);
    
    Map<String, Object> getParams();
    void setParams(Map<String, Object> params);
}

