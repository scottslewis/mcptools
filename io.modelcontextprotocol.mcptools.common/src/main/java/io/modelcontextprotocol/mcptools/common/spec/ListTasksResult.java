package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * List tasks result
 */
public class ListTasksResult extends PaginatedResult {
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
