package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Model preferences
 */
public class ModelPreferences {
	private List<ModelHint> hints;
	private Double costPriority;
	private Double speedPriority;
	private Double intelligencePriority;

	public List<ModelHint> getHints() {
		return hints;
	}

	public void setHints(List<ModelHint> hints) {
		this.hints = hints;
	}

	public Double getCostPriority() {
		return costPriority;
	}

	public void setCostPriority(Double costPriority) {
		this.costPriority = costPriority;
	}

	public Double getSpeedPriority() {
		return speedPriority;
	}

	public void setSpeedPriority(Double speedPriority) {
		this.speedPriority = speedPriority;
	}

	public Double getIntelligencePriority() {
		return intelligencePriority;
	}

	public void setIntelligencePriority(Double intelligencePriority) {
		this.intelligencePriority = intelligencePriority;
	}
}
