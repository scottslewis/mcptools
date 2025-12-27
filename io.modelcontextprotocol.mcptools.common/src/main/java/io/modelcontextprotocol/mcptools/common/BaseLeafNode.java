package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class BaseLeafNode extends BaseNode {

	protected BaseLeafNode(String name) {
		super(name);
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

	protected GroupNode getTopGroupNode(GroupNode current) {
		GroupNode parent = current.getParent();
		if (parent == null) {
			return current;
		} else
			return getTopGroupNode(parent);
	}

	public List<GroupNode> getRoots() {
		return getParentGroups().stream().map(pgn -> getTopGroupNode(pgn)).collect(Collectors.toList());
	}

}
