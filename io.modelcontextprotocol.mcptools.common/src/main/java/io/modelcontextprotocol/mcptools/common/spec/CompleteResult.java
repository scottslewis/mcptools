package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Complete result
 */
public class CompleteResult implements Result {
    private Completion completion;
    private Map<String, Object> _meta;
    private Map<String, Object> additionalProperties;

    public Completion getCompletion() {
        return completion;
    }

    public void setCompletion(Completion completion) {
        this.completion = completion;
    }

    @Override
    public Map<String, Object> get_meta() {
        return _meta;
    }

    @Override
    public void set_meta(Map<String, Object> _meta) {
        this._meta = _meta;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public static class Completion {
        private List<String> values;
        private Integer total;
        private Boolean hasMore;

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Boolean getHasMore() {
            return hasMore;
        }

        public void setHasMore(Boolean hasMore) {
            this.hasMore = hasMore;
        }
    }
}
