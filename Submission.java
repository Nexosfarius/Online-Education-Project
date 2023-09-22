public class Submission {

	private Student student;
	private Assignment assignment;
	private Course course;
	private String answer;
	private Double grade;
	private String feedback;
	private boolean isGraded = false;

	public Boolean getGradeStatus() {
		return isGraded;
	}

	public void setGradeStatus(Boolean isGraded) {
		this.isGraded = isGraded;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Submission(Student student, Course course, Assignment assignment) {
		this.student = student;
		this.assignment = assignment;
		this.course = course;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
