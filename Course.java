import java.util.LinkedList;
import java.util.List;

public class Course {

	public Course(Teacher teacher, String name, int coursecode, String description) {
		this.teacher = teacher;
		this.coursecode = coursecode;
		this.description = description;
		this.name = name;
	}

	private String name;
	private String description;
	private Teacher teacher;
	private List<Assignment> assignments = new LinkedList<Assignment>();
	private List<LectureMaterials> lecMats = new LinkedList<LectureMaterials>();
	private List<Student> students = new LinkedList<Student>();
	private int coursecode;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addMaterials(LectureMaterials lecMat) {
		lecMats.add(lecMat);
	}

	public void removeMaterials(LectureMaterials lecMat) {
		lecMats.remove(lecMat);
	}

	public List<LectureMaterials> getMaterials() {
		return lecMats;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void addStudents(Student student) {
		students.add(student);
	}

	public void removeStudents(Student student) {
		students.remove(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setCode(int coursecode) {
		this.coursecode = coursecode;
	}

	public int getCode() {
		return coursecode;
	}

	public void addAssignments(Assignment assignment) {
		assignments.add(assignment);
	}

	public void removeAssignments(Assignment assignment) {
		assignments.remove(assignment);
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

}
