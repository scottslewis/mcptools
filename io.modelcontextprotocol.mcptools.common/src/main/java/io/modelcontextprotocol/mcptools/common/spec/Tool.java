package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Tool definition
 */
public class Tool implements BaseMetadata, Icons {
	private String name;
	private String title;
	private String description;
	private ToolInputSchema inputSchema;
	private ToolExecution execution;
	private ToolOutputSchema outputSchema;
	private ToolAnnotations annotations;
	private Map<String, Object> _meta;
	private List<Icon> icons;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ToolInputSchema getInputSchema() {
		return inputSchema;
	}

	public void setInputSchema(ToolInputSchema inputSchema) {
		this.inputSchema = inputSchema;
	}

	public ToolExecution getExecution() {
		return execution;
	}

	public void setExecution(ToolExecution execution) {
		this.execution = execution;
	}

	public ToolOutputSchema getOutputSchema() {
		return outputSchema;
	}

	public void setOutputSchema(ToolOutputSchema outputSchema) {
		this.outputSchema = outputSchema;
	}

	public ToolAnnotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(ToolAnnotations annotations) {
		this.annotations = annotations;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}

	@Override
	public List<Icon> getIcons() {
		return icons;
	}

	@Override
	public void setIcons(List<Icon> icons) {
		this.icons = icons;
	}

	public static class ToolInputSchema {
		private String $schema;
		private String type = "object";
		private Map<String, Object> properties;
		private List<String> required;

		public String get$schema() {
			return $schema;
		}

		public void set$schema(String $schema) {
			this.$schema = $schema;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Map<String, Object> getProperties() {
			return properties;
		}

		public void setProperties(Map<String, Object> properties) {
			this.properties = properties;
		}

		public List<String> getRequired() {
			return required;
		}

		public void setRequired(List<String> required) {
			this.required = required;
		}
	}

	public static class ToolOutputSchema {
		private String $schema;
		private String type = "object";
		private Map<String, Object> properties;
		private List<String> required;

		public String get$schema() {
			return $schema;
		}

		public void set$schema(String $schema) {
			this.$schema = $schema;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Map<String, Object> getProperties() {
			return properties;
		}

		public void setProperties(Map<String, Object> properties) {
			this.properties = properties;
		}

		public List<String> getRequired() {
			return required;
		}

		public void setRequired(List<String> required) {
			this.required = required;
		}
	}
}
