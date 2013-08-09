package ivy.web.spring.util.reflect;

public class MethodParamInfo {
	private String name;
	private String type;
	private boolean generic;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isGeneric() {
		return generic;
	}

	public void setGeneric(boolean generic) {
		this.generic = generic;
	}

}
