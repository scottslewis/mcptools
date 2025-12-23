package io.modelcontextprotocol.mcptools.json.schema;

import java.util.Map;

public interface JsonSchemaValidator {

	record ValidationResponse(boolean valid, String errorMessage, String jsonStructuredOutput) {

		public static ValidationResponse asValid(String jsonStructuredOutput) {
			return new ValidationResponse(true, null, jsonStructuredOutput);
		}

		public static ValidationResponse asInvalid(String message) {
			return new ValidationResponse(false, message, null);
		}
	}

	ValidationResponse validate(Map<String, Object> schema, Object structuredContent);

}
