package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Elicit request form parameters
 */
public class ElicitRequestFormParams extends TaskAugmentedRequestParams {
	private String mode = "form";
	private String message;
	private ElicitRequestSchema requestedSchema;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ElicitRequestSchema getRequestedSchema() {
		return requestedSchema;
	}

	public void setRequestedSchema(ElicitRequestSchema requestedSchema) {
		this.requestedSchema = requestedSchema;
	}

	public static class ElicitRequestSchema {
		private String $schema;
		private String type = "object";
		private Map<String, PrimitiveSchemaDefinition> properties;
		private java.util.List<String> required;

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

		public Map<String, PrimitiveSchemaDefinition> getProperties() {
			return properties;
		}

		public void setProperties(Map<String, PrimitiveSchemaDefinition> properties) {
			this.properties = properties;
		}

		public java.util.List<String> getRequired() {
			return required;
		}

		public void setRequired(java.util.List<String> required) {
			this.required = required;
		}
	}
}
