package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class GroupNode extends BaseNode {

	protected GroupNode parent;

	protected final List<GroupNode> childGroups;

	protected final List<ToolNode> childTools;

	protected final List<PromptNode> childPrompts;

	protected final List<ResourceNode> childResources;

	protected Function<GroupNode, ?> converter;

	public GroupNode(String name) {
		this(name, DEFAULT_SEPARATOR);
	}

	public GroupNode(String name, String nameSeparator) {
		super(name, nameSeparator);
		this.childGroups = new CopyOnWriteArrayList<GroupNode>();
		this.childTools = new CopyOnWriteArrayList<ToolNode>();
		this.childPrompts = new CopyOnWriteArrayList<PromptNode>();
		this.childResources = new CopyOnWriteArrayList<ResourceNode>();
	}

	public GroupNode getParent() {
		return this.parent;
	}
	
	public GroupNode getRoot() {
		GroupNode parent = this.parent;
		if (parent == null) {
			return this;
		} else {
			return parent.getRoot();
		}
	}

	public boolean isRoot() {
		return this.parent == null;
	}

	public boolean addChildGroup(GroupNode childGroup) {
		synchronized (childGroups) {
			boolean added = childGroups.add(childGroup);
			if (added) {
				childGroup.parent = this;
				return true;
			}
			return false;
		}
	}

	public boolean removeChildGroup(GroupNode childGroup) {
		synchronized (childGroups) {
			if (childGroups.remove(childGroup)) {
				childGroup.parent = null;
				return true;
			}
			return false;
		}
	}

	public List<GroupNode> getChildrenGroups() {
		return this.childGroups;
	}

	public boolean addChildTool(ToolNode childTool) {
		synchronized (childTools) {
			boolean added = childTools.add(childTool);
			if (added) {
				childTool.addParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public boolean removeChildTool(ToolNode childTool) {
		synchronized (childTools) {
			boolean removed = childTools.remove(childTool);
			if (removed) {
				childTool.removeParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public List<ToolNode> getChildrenTools() {
		return this.childTools;
	}

	public boolean addChildPrompt(PromptNode childPrompt) {
		synchronized (childPrompts) {
			boolean added = childPrompts.add(childPrompt);
			if (added) {
				childPrompt.addParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public boolean removeChildPrompt(PromptNode childPrompt) {
		synchronized (childPrompts) {
			boolean removed = childPrompts.remove(childPrompt);
			if (removed) {
				childPrompt.removeParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public List<ResourceNode> getChildrenResources() {
		return this.childResources;
	}

	public boolean addChildResource(ResourceNode childResource) {
		synchronized (childResources) {
			boolean added = childResources.add(childResource);
			if (added) {
				childResource.addParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public boolean removeChildPrompt(ResourceNode childResource) {
		synchronized (childResources) {
			boolean removed = childResources.remove(childResource);
			if (removed) {
				childResource.removeParentGroup(this);
				return true;
			}
			return false;
		}
	}

	public List<PromptNode> getChildrenPrompts() {
		return this.childPrompts;
	}

	protected String getFullyQualifiedName(StringBuffer sb, GroupNode tg) {
		GroupNode parent = tg.getParent();
		if (parent != null) {
			String parentName = getFullyQualifiedName(sb, parent);
			return new StringBuffer(parentName).append(this.nameSeparator).append(tg.getName()).toString();
		}
		return tg.getName();
	}

	@Override
	public String getFullyQualifiedName() {
		return getFullyQualifiedName(new StringBuffer(), this);
	}

	@Override
	public String toString() {
		return "GroupNode [name=" + name + ", fqName=" + getFullyQualifiedName() + ", isRoot=" + isRoot() + ", title=" + title + ", description="
				+ description + ", meta=" + meta + ", childGroups=" + childGroups + ", childTools=" + childTools
				+ ", childPrompts=" + childPrompts + "]";
	}

}
