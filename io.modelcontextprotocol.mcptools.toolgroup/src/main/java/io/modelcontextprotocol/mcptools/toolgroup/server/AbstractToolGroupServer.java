package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public abstract class AbstractToolGroupServer<ServerType, ToolSpecType, ToolType, ExchangeType, CallToolRequestType, CallToolResultType>
		implements ToolGroupServer<ServerType, ToolSpecType, ToolType, ExchangeType, CallToolRequestType, CallToolResultType> {

	private static Logger logger = LoggerFactory.getLogger(AbstractToolGroupServer.class);

	protected ServerType server;
	protected final Map<ToolNode, BiFunction<ExchangeType, CallToolRequestType, CallToolResultType>> toolNodeToBiFunctionMap;
	protected final CopyOnWriteArrayList<ToolSpecType> toolSpecs;

	public AbstractToolGroupServer() {
		this(null);
	}
	
	protected AbstractToolGroupServer(ServerType server) {
		Objects.requireNonNull(server, "server must not be null");
		this.server = server;
		this.toolNodeToBiFunctionMap = new ConcurrentHashMap<ToolNode, BiFunction<ExchangeType, CallToolRequestType, CallToolResultType>>();
		this.toolSpecs = new CopyOnWriteArrayList<ToolSpecType>();
	}

	protected void setServer(ServerType server) {
		this.server = server;
	}
	
	protected abstract void closeServer();

	@Override
	public void close() throws IOException {
		closeServer();
		this.toolNodeToBiFunctionMap.clear();
		this.toolSpecs.clear();
	}

	abstract protected void addTool(ServerType server, ToolSpecType toolSpec);

	abstract protected void removeTool(ServerType server, String toolName);

	@Override
	public void addTool(ToolSpecType toolSpec) {
		Objects.requireNonNull(toolSpec, "toolSpec must not be null");
		ServerType s = getServer();
		try {
			addTool(s, toolSpec);
			if (logger.isDebugEnabled()) {
				logger.debug("added tool specification={} to sync server={}", toolSpec, s);
			}
		} catch (Exception e) {
			handleAddError(toolSpec, e, true);
			throw e;
		}
	}

	protected void handleAddError(ToolSpecType toolSpec, Exception e, boolean b) {
		if (logger.isErrorEnabled()) {
			logger.error("Could not add tool specification=" + toolSpec, e);
		}
	}

	@Override
	public void removeTool(String toolName) {
		Objects.requireNonNull(toolName, "toolName must not be null");
		removeTool(this.server, toolName);
	}

	@Override
	public ServerType getServer() {
		return server;
	}

	@Override
	public List<ToolSpecType> getToolSpecs() {
		return toolSpecs;
	}

	protected abstract ToolSpecType buildSpecification(ToolNode toolNode,
			BiFunction<ExchangeType, CallToolRequestType, CallToolResultType> callHandler);

}
