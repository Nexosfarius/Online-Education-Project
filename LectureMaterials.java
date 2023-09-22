public class LectureMaterials {

	private String url;
	private Course course;
	private int code;
	private String name;
	private String description;

	public LectureMaterials(Course course, String name, int code, String description, String url) {
		this.course = course;
		this.name = name;
		this.code = code;
		this.description = description;
		this.url = url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getURL() {
		return url;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Course getCourse() {
		return course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
