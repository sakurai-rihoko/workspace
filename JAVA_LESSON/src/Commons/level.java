package Commons;

public class level {
	private String name;
	private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public level(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

public String toString() {
	return "码农"+this.name+"等级"+this.level;
}
}
