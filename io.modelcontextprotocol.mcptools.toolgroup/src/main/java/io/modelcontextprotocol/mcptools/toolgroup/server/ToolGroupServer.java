package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.List;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public interface ToolGroupServer extends Closeable {

	static final String SERVER_PROP_PREFIX = ToolGroupServer.class.getName();
	public static final String SERVER_NAME_PROP = SERVER_PROP_PREFIX + ".serverName";
	public static final String SERVER_VERSION_PROP = SERVER_PROP_PREFIX + ".serverVersion";
	public static final String SERVER_TRANSPORT_PROP = SERVER_PROP_PREFIX + ".serverTransport";
	public static final String SERVER_CAPABILITIES_PROP = SERVER_PROP_PREFIX + ".serverCapabilities";
	
	default void removeToolNodes(List<ToolNode> toolNodes) {
		toolNodes.forEach(tn -> {
			removeToolNode(tn);
		});
	}

	void removeToolNode(ToolNode toolNode);

	List<ToolNode> addToolGroup(Object instance, Class<?>... classes);

	void addToolNode(ToolNode toolNode, Method toolMethod, Object instance);
}
