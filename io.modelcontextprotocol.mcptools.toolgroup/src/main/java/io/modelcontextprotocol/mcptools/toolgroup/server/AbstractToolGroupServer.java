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
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;

public abstract class AbstractToolGroupServer<ServerType, ToolSpecType, ToolType, ExchangeType, CallToolRequestType, CallToolResultType>
		implements ToolGroupServer {

	private static Logger logger = LoggerFactory.getLogger(AbstractToolGroupServer.class);

	protected ServerType server;
	protected final Map<ToolNode, BiFunction<ExchangeType, CallToolRequestType, CallToolResultType>> toolNodeToBiFunctionMap;
	protected final CopyOnWriteArrayList<ToolSpecType> toolSpecs;

	public AbstractToolGroupServer() {
		this(null);
	}

	protected AbstractToolGroupServer(ServerType server) {
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

	protected void addTools(List<ToolSpecType> toolSpecs) {
		toolSpecs.forEach(s -> addTool(s));
	}

	protected void removeTools(List<String> toolNames) {
		toolNames.forEach(tn -> removeTool(tn));
	}

	protected void addTool(ToolSpecType toolSpec) {
		Objects.requireNonNull(toolSpec, "toolSpec must not be null");
		ServerType s = getServer();
		try {
			addTool(s, toolSpec);
			this.toolSpecs.add(toolSpec);
			if (logger.isDebugEnabled()) {
				logger.debug("added tool specification={} to sync server={}", toolSpec, s);
			}
		} catch (Exception e) {
			handleAddError(toolSpec, e);
			throw e;
		}
	}

	protected void handleAddError(ToolSpecType toolSpec, Exception e) {
		if (logger.isErrorEnabled()) {
			logger.error("Could not add tool specification=" + toolSpec, e);
		}
	}

	protected void handleRemoveError(String toolSpecName, Exception e) {
		if (logger.isErrorEnabled()) {
			logger.error("Could not remove tool specification name=" + toolSpecName, e);
		}
	}

	protected void removeTool(String toolName) {
		Objects.requireNonNull(toolName, "toolName must not be null");
		try {
			removeTool(this.server, toolName);
		} catch (Exception e) {
			handleRemoveError(toolName, e);
			throw e;
		}
	}

	protected ServerType getServer() {
		return server;
	}

	protected List<ToolSpecType> getToolSpecs() {
		return toolSpecs;
	}

	protected abstract ToolNodeSpecification<ToolSpecType> getToolNodeSpecification(ToolNode toolNode,
			BiFunction<ExchangeType, CallToolRequestType, CallToolResultType> callHandler);

}
