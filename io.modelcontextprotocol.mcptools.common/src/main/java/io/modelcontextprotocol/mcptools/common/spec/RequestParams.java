package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Base request parameters
 */
public class RequestParams {
    private RequestMeta _meta;

    public RequestMeta get_meta() {
        return _meta;
    }

    public void set_meta(RequestMeta _meta) {
        this._meta = _meta;
    }

    public static class RequestMeta {
        private ProgressToken progressToken;
        private Map<String, Object> additionalProperties;

        public ProgressToken getProgressToken() {
            return progressToken;
        }

        public void setProgressToken(ProgressToken progressToken) {
            this.progressToken = progressToken;
        }

        public Map<String, Object> getAdditionalProperties() {
            return additionalProperties;
        }

        public void setAdditionalProperties(Map<String, Object> additionalProperties) {
            this.additionalProperties = additionalProperties;
        }
    }
}

