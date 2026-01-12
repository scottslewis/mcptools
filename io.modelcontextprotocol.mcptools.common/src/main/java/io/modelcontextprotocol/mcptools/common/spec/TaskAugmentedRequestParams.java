package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Request parameters augmented with task metadata
 */
public class TaskAugmentedRequestParams extends RequestParams {
	private TaskMetadata task;

	public TaskMetadata getTask() {
		return task;
	}

	public void setTask(TaskMetadata task) {
		this.task = task;
	}
}
