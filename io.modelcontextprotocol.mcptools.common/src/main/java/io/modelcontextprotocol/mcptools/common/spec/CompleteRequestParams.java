package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Complete request parameters
 */
public class CompleteRequestParams extends RequestParams {
	private Object ref; // Can be PromptReference or ResourceTemplateReference
	private CompleteArgument argument;
	private CompleteContext context;

	public Object getRef() {
		return ref;
	}

	public void setRef(Object ref) {
		this.ref = ref;
	}

	public PromptReference getRefAsPrompt() {
		if (ref instanceof PromptReference) {
			return (PromptReference) ref;
		}
		return null;
	}

	public ResourceTemplateReference getRefAsResourceTemplate() {
		if (ref instanceof ResourceTemplateReference) {
			return (ResourceTemplateReference) ref;
		}
		return null;
	}

	public CompleteArgument getArgument() {
		return argument;
	}

	public void setArgument(CompleteArgument argument) {
		this.argument = argument;
	}

	public CompleteContext getContext() {
		return context;
	}

	public void setContext(CompleteContext context) {
		this.context = context;
	}

	public static class CompleteArgument {
		private String name;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class CompleteContext {
		private Map<String, String> arguments;

		public Map<String, String> getArguments() {
			return arguments;
		}

		public void setArguments(Map<String, String> arguments) {
			this.arguments = arguments;
		}
	}
}
