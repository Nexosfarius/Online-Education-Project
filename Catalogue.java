import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	private static final Catalogue catalogue = new Catalogue();
	private static List<Course> courses = new ArrayList<Course>();
	

	public static Catalogue getInstance() {
		return catalogue;
	}
	
	public List<String> getCourseNames() {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < courses.size(); i++) {
			newList.add(courses.get(i).getName());
		}
		return newList;
	}
	
	public List<String> getCourseTeachers() {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < courses.size(); i++) {
			newList.add(courses.get(i).getTeacher().getName());
		}
		return newList;
	}
	
	public List<Integer> getCourseCodes() {
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < courses.size(); i++) {
			newList.add(courses.get(i).getCode());
		}
		return newList;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}

	private Catalogue() {
	};
}
