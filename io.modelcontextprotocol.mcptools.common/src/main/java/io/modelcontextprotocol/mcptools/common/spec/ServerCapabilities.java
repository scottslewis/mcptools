package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Server capabilities
 */
public class ServerCapabilities {
    private Map<String, Object> experimental;
    private Object logging;
    private Object completions;
    private PromptsCapability prompts;
    private ResourcesCapability resources;
    private ToolsCapability tools;
    private ServerTasksCapability tasks;

    public Map<String, Object> getExperimental() {
        return experimental;
    }

    public void setExperimental(Map<String, Object> experimental) {
        this.experimental = experimental;
    }

    public Object getLogging() {
        return logging;
    }

    public void setLogging(Object logging) {
        this.logging = logging;
    }

    public Object getCompletions() {
        return completions;
    }

    public void setCompletions(Object completions) {
        this.completions = completions;
    }

    public PromptsCapability getPrompts() {
        return prompts;
    }

    public void setPrompts(PromptsCapability prompts) {
        this.prompts = prompts;
    }

    public ResourcesCapability getResources() {
        return resources;
    }

    public void setResources(ResourcesCapability resources) {
        this.resources = resources;
    }

    public ToolsCapability getTools() {
        return tools;
    }

    public void setTools(ToolsCapability tools) {
        this.tools = tools;
    }

    public ServerTasksCapability getTasks() {
        return tasks;
    }

    public void setTasks(ServerTasksCapability tasks) {
        this.tasks = tasks;
    }

    public static class PromptsCapability {
        private Boolean listChanged;

        public Boolean getListChanged() {
            return listChanged;
        }

        public void setListChanged(Boolean listChanged) {
            this.listChanged = listChanged;
        }
    }

    public static class ResourcesCapability {
        private Boolean subscribe;
        private Boolean listChanged;

        public Boolean getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(Boolean subscribe) {
            this.subscribe = subscribe;
        }

        public Boolean getListChanged() {
            return listChanged;
        }

        public void setListChanged(Boolean listChanged) {
            this.listChanged = listChanged;
        }
    }

    public static class ToolsCapability {
        private Boolean listChanged;

        public Boolean getListChanged() {
            return listChanged;
        }

        public void setListChanged(Boolean listChanged) {
            this.listChanged = listChanged;
        }
    }

    public static class ServerTasksCapability {
        private Object list;
        private Object cancel;
        private ServerTaskRequestsCapability requests;

        public Object getList() {
            return list;
        }

        public void setList(Object list) {
            this.list = list;
        }

        public Object getCancel() {
            return cancel;
        }

        public void setCancel(Object cancel) {
            this.cancel = cancel;
        }

        public ServerTaskRequestsCapability getRequests() {
            return requests;
        }

        public void setRequests(ServerTaskRequestsCapability requests) {
            this.requests = requests;
        }
    }

    public static class ServerTaskRequestsCapability {
        private ServerTaskToolsCapability tools;

        public ServerTaskToolsCapability getTools() {
            return tools;
        }

        public void setTools(ServerTaskToolsCapability tools) {
            this.tools = tools;
        }
    }

    public static class ServerTaskToolsCapability {
        private Object call;

        public Object getCall() {
            return call;
        }

        public void setCall(Object call) {
            this.call = call;
        }
    }
}
