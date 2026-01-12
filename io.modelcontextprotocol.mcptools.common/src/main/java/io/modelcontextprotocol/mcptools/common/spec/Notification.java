package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Base notification interface
 */
public interface Notification {
	String getMethod();

	void setMethod(String method);

	Map<String, Object> getParams();

	void setParams(Map<String, Object> params);
}
