import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonalInfo {

	private static final PersonalInfo info = new PersonalInfo();

	public static PersonalInfo getInstance() {
		return info;
	}

	protected PersonalInfo() {
	}

	private String name;
	private String DOB;
	private String phoneNum;
	private List<Course> courses = new LinkedList<Course>();
	private String Username;
	private String Password;
	private static List<Student> allStudents = new ArrayList<Student>();
	private static List<Teacher> allTeachers = new ArrayList<Teacher>();

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public List<Student> getStudents() {
		return allStudents;
	}

	public void setStudents(Student student) {
		allStudents.add(student);
	}

	public List<Teacher> getTeachers() {
		return allTeachers;
	}

	public void setTeachers(Teacher teacher) {
		allTeachers.add(teacher);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getNum() {
		return phoneNum;
	}

	public void setNum(String Num) {
		this.phoneNum = Num;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		this.courses.add(course);
	}

}
