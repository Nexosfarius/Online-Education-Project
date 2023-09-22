import java.util.LinkedList;
import java.util.List;

public class Student extends PersonalInfo {

	public Student() {
	}

	private int studentCode;
	private static List<Submission> submissions = new LinkedList<Submission>();

	public int getCode() {
		return studentCode;
	}

	public void setCode(int code) {
		this.studentCode = code;
	}

	public void addSubmissions(Submission submission) {
		submissions.add(submission);
	}

	public void removeSubmissions(Submission submission) {
		submissions.remove(submission);
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public Double getOverallGrade(Course course) {
		Double finalGrade = 0.0;
		for (int i = 0; i < submissions.size(); i++) {
			if (submissions.get(i).getCourse().equals(course) && submissions.get(i).getGrade() != null) {
				Double grade = submissions.get(i).getGrade() * submissions.get(i).getAssignment().getWeight();
				finalGrade += grade;
			}
		}
		return finalGrade;
	}

}
