package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Client capabilities
 */
public class ClientCapabilities {
    private Map<String, Object> experimental;
    private RootsCapability roots;
    private SamplingCapability sampling;
    private ElicitationCapability elicitation;
    private TasksCapability tasks;

    public Map<String, Object> getExperimental() {
        return experimental;
    }

    public void setExperimental(Map<String, Object> experimental) {
        this.experimental = experimental;
    }

    public RootsCapability getRoots() {
        return roots;
    }

    public void setRoots(RootsCapability roots) {
        this.roots = roots;
    }

    public SamplingCapability getSampling() {
        return sampling;
    }

    public void setSampling(SamplingCapability sampling) {
        this.sampling = sampling;
    }

    public ElicitationCapability getElicitation() {
        return elicitation;
    }

    public void setElicitation(ElicitationCapability elicitation) {
        this.elicitation = elicitation;
    }

    public TasksCapability getTasks() {
        return tasks;
    }

    public void setTasks(TasksCapability tasks) {
        this.tasks = tasks;
    }

    public static class RootsCapability {
        private Boolean listChanged;

        public Boolean getListChanged() {
            return listChanged;
        }

        public void setListChanged(Boolean listChanged) {
            this.listChanged = listChanged;
        }
    }

    public static class SamplingCapability {
        private Object context;
        private Object tools;

        public Object getContext() {
            return context;
        }

        public void setContext(Object context) {
            this.context = context;
        }

        public Object getTools() {
            return tools;
        }

        public void setTools(Object tools) {
            this.tools = tools;
        }
    }

    public static class ElicitationCapability {
        private Object form;
        private Object url;

        public Object getForm() {
            return form;
        }

        public void setForm(Object form) {
            this.form = form;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }
    }

    public static class TasksCapability {
        private Object list;
        private Object cancel;
        private TaskRequestsCapability requests;

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

        public TaskRequestsCapability getRequests() {
            return requests;
        }

        public void setRequests(TaskRequestsCapability requests) {
            this.requests = requests;
        }
    }

    public static class TaskRequestsCapability {
        private TaskSamplingCapability sampling;
        private TaskElicitationCapability elicitation;

        public TaskSamplingCapability getSampling() {
            return sampling;
        }

        public void setSampling(TaskSamplingCapability sampling) {
            this.sampling = sampling;
        }

        public TaskElicitationCapability getElicitation() {
            return elicitation;
        }

        public void setElicitation(TaskElicitationCapability elicitation) {
            this.elicitation = elicitation;
        }
    }

    public static class TaskSamplingCapability {
        private Object createMessage;

        public Object getCreateMessage() {
            return createMessage;
        }

        public void setCreateMessage(Object createMessage) {
            this.createMessage = createMessage;
        }
    }

    public static class TaskElicitationCapability {
        private Object create;

        public Object getCreate() {
            return create;
        }

        public void setCreate(Object create) {
            this.create = create;
        }
    }
}
