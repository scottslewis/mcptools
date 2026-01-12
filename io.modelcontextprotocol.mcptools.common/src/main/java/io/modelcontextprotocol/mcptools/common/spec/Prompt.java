package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;
import java.util.Map;

/**
 * Prompt definition
 */
public class Prompt implements BaseMetadata, Icons {
	private String name;
	private String title;
	private String description;
	private List<PromptArgument> arguments;
	private Map<String, Object> _meta;
	private List<Icon> icons;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PromptArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<PromptArgument> arguments) {
		this.arguments = arguments;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}

	@Override
	public List<Icon> getIcons() {
		return icons;
	}

	@Override
	public void setIcons(List<Icon> icons) {
		this.icons = icons;
	}
}
