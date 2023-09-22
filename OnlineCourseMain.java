public class OnlineCourseMain {
	public static final Catalogue cat = Catalogue.getInstance();
	public static final PersonalInfo info = PersonalInfo.getInstance();

	public static void main(String[] args) {

		Teacher teacher = new Teacher();
		teacher.setName("Tahir");
		teacher.setUsername("user");
		teacher.setPassword("pass");
		info.setTeachers(teacher);
		Course course1 = new Course(teacher, "dsvf", 1949, "dsds sdgdsb");
		teacher.setCourses(course1);
		Course course2 = new Course(teacher, "dkssk", 1924, "egwjk ewiub");
		teacher.setCourses(course2);
		Student student = new Student();
		student.setName("Tahir1");
		student.setUsername("user1");
		student.setPassword("pass1");
		student.setCode(1222);
		info.setStudents(student);
		course1.getStudents().add(student);
		student.getCourses().add(course1);
		course2.getStudents().add(student);
		student.getCourses().add(course2);
		Assignment assignment = new Assignment("bjd", 1837, "dssv", "rsvs", course1, 0.1);
		course1.addAssignments(assignment);
		Submission sub = new Submission(student, course1, assignment);
		student.addSubmissions(sub);
		cat.addCourse(course1);
		cat.addCourse(course2);
		View.GeneralView();
	}

}
