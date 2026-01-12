package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Set level request parameters
 */
public class SetLevelRequestParams extends RequestParams {
	private LoggingLevel level;

	public LoggingLevel getLevel() {
		return level;
	}

	public void setLevel(LoggingLevel level) {
		this.level = level;
	}
}
