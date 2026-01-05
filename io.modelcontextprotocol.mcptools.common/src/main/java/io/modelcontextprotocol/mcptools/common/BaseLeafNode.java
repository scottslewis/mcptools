package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class BaseLeafNode extends BaseNode {

	protected BaseLeafNode(String name) {
		super(name);
	}

	protected BaseLeafNode(String name, String nameSeparator) {
		super(name, nameSeparator);
	}

	protected List<GroupNode> parentGroups = new CopyOnWriteArrayList<GroupNode>();

	public boolean addParentGroup(GroupNode parentGroup) {
		Objects.requireNonNull(parentGroup, "parentGroup must not be null");
		return parentGroups.add(parentGroup);
	}

	public boolean removeParentGroup(GroupNode parentGroup) {
		return parentGroups.remove(parentGroup);
	}

	public List<GroupNode> getParentGroups() {
		return this.parentGroups;
	}

	public List<GroupNode> getParentGroupRoots() {
		List<GroupNode> parentGroups = this.parentGroups;
		return parentGroups.stream().map(GroupNode::getRoot).toList();
	}

	@Override
	public String getFullyQualifiedName() {
		return name;
	}

}
