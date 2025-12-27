package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class PromptNode extends BaseLeafNode {

	protected List<PromptArgumentNode> promptArguments = new CopyOnWriteArrayList<PromptArgumentNode>();

	public PromptNode(String name) {
		super(name);
	}

	public List<PromptArgumentNode> getPromptArguments() {
		return this.promptArguments;
	}

	public boolean addPromptArgument(PromptArgumentNode promptArgument) {
		Objects.requireNonNull(promptArgument, "promptArgument must not be null");
		return promptArguments.add(promptArgument);
	}

	public boolean removeParentGroup(PromptArgumentNode promptArgument) {
		return promptArguments.remove(promptArgument);
	}

	@Override
	public String toString() {
		return "PromptNode [promptArguments=" + promptArguments + ", name=" + name + ", title=" + title
				+ ", description=" + description + ", meta=" + meta + "]";
	}

}
