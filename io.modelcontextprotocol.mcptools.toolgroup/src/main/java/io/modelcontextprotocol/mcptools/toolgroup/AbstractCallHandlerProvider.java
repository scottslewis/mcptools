package io.modelcontextprotocol.mcptools.toolgroup;

public abstract class AbstractCallHandlerProvider<ExchangeType, CallToolRequestType, CallToolResultType>
		implements CallHandlerProvider<ExchangeType, CallToolRequestType, CallToolResultType> {

	protected boolean useStructuredOutput;

	public AbstractCallHandlerProvider() {
	}

	protected void setUseStructuredOutput(boolean useStructuredOutput) {
		this.useStructuredOutput = useStructuredOutput;
	}
}
