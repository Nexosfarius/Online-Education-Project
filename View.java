import java.util.*;

public class View {

	public static final Scanner scnr = new Scanner(System.in);
	public static final Random rand = new Random();
	public static int selection;
	public static final PersonalInfo info = PersonalInfo.getInstance();
	public static final Catalogue cat = Catalogue.getInstance();

	public static void GeneralView() {
		System.out.println("Welcome to Ed-Tech! Please select one of the choices below:");
		System.out.println(
				"1. New Student \n2. Returning Student \n3. New Teacher \n4. Returning Teacher \n5. End Program");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				NewStudentView();
				break;
			} else if (selection == 2) {
				System.out.println("Please enter your username: ");
				String username = scnr.next();
				System.out.println("Please enter your password: ");
				String password = scnr.next();
				List<Student> list = info.getStudents();
				for (i = 0; i < list.size(); i++) {
					if (list.get(i).getUsername().equalsIgnoreCase(username)
							&& list.get(i).getPassword().equalsIgnoreCase(password)) {
						StudentGeneralView(list.get(i));
						break;
					}
				}
				System.out.println("A user with those credentials does not exist. Returning to general view.");
				GeneralView();
				break;
			} else if (selection == 3) {
				NewTeacherView();
				break;
			} else if (selection == 4) {
				System.out.println("Please enter your username: ");
				String username = scnr.next();
				System.out.println("Please enter your password: ");
				String password = scnr.next();
				List<Teacher> list = info.getTeachers();
				for (i = 0; i < list.size(); i++) {
					if (list.get(i).getUsername().equalsIgnoreCase(username)
							&& list.get(i).getPassword().equalsIgnoreCase(password)) {
						TeacherGeneralView(list.get(i));
						break;
					}
				}
				System.out.println("A user with those credentials does not exist. Returning to general view.");
				GeneralView();
				break;
			} else if (selection == 5) {
				System.exit(0);
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void NewStudentView() {
		Student student = new Student();
		System.out.println("Please enter your username: ");
		student.setUsername(scnr.next());
		System.out.println("Please enter your password: ");
		student.setPassword(scnr.next());
		System.out.println("Please enter your name: ");
		scnr.nextLine();
		student.setName(scnr.nextLine());
		System.out.println("Please enter your date of birth in the format Month/Day/Year(MN/DY/YEAR): ");
		student.setDOB(scnr.next());
		System.out
				.println("Would you like to add a phone number? \nPlease enter 1 for yes or any other number for no.");
		if (scnr.nextInt() == 1) {
			System.out.println("Please enter phone number with no other characters besides just the numbers: ");
			student.setNum(scnr.next());
		}
		List<Student> students = info.getStudents();
		int random = rand.nextInt(1000, 10000);
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getCode() == random) {
				random = rand.nextInt(1000, 10000);
				i = 0;
			}
		}
		student.setCode(random);
		info.setStudents(student);
		StudentGeneralView(student);
	}

	public static void NewTeacherView() {
		Teacher teacher = new Teacher();
		System.out.println("Please enter your username: ");
		teacher.setUsername(scnr.next());
		System.out.println("Please enter your password: ");
		teacher.setPassword(scnr.next());
		System.out.println("Please enter your name: ");
		scnr.nextLine();
		String name = scnr.nextLine();
		teacher.setName(name);
		System.out.println("Please enter your date of birth in the format Month/Day/Year: ");
		teacher.setDOB(scnr.next());
		System.out
				.println("Would you like to add a phone number? \nPlease enter 1 for yes or any other number for no.");
		if (scnr.nextInt() == 1) {
			System.out.println("Please enter phone number with no other characters besides just the numbers: ");
			teacher.setNum(scnr.next());
		}
		info.setTeachers(teacher);
		TeacherGeneralView(teacher);
	}

	public static void StudentGeneralView(Student student) {
		System.out.println("Welcome " + student.getName() + "!");
		System.out.println();
		System.out.println(
				"Please enter where in the following list you would like to go: \n1. My Profile \n2. Course Catalogue \n3. My Course List \n4. Logout to Main Menu");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				StudentProfileView(student);
				break;
			} else if (selection == 2) {
				StudentCatalogueView(student);
				break;
			} else if (selection == 3) {
				StudentMultiCourseView(student);
				break;
			} else if (selection == 4) {
				GeneralView();
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherGeneralView(Teacher teacher) {
		System.out.println("Welcome Professor " + teacher.getName() + "!");
		System.out.println();
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"Please enter where in the following list you would like to go: \n1. My Profile \n2. Course Catalogue \n3. My Course List \n4. Create Course \n5. Logout to Main Menu");
			selection = scnr.nextInt();
			if (selection == 1) {
				TeacherProfileView(teacher);
				break;
			} else if (selection == 2) {
				TeacherCatalogueView(teacher);
				break;
			} else if (selection == 3) {
				TeacherMultiCourseView(teacher);
				break;
			} else if (selection == 4) {
				CourseCreationView(teacher);
				break;
			} else if (selection == 5) {
				GeneralView();
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void CourseCreationView(Teacher teacher) {
		List<Course> list = cat.getCourses();
		System.out.println("Please enter the name of the course you would like to create: ");
		scnr.nextLine();
		String coursename = scnr.nextLine();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getName().equalsIgnoreCase(coursename)) {
				System.out.println("The name entered already exists in the system. \nPlease enter a new name: ");
				scnr.nextLine();
				coursename = scnr.nextLine();
				j--;
			}
		}
		int random = rand.nextInt(1000, 10000);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == random) {
				random = rand.nextInt(1000, 10000);
				i = 0;
			}
		}
		int coursecode = random;
		System.out.println("Please enter a description of your course: ");
		String courseDescription = scnr.nextLine();
		for (int i = 0; i < 1; i++) {
			System.out.println("Course Name: " + coursename);
			System.out.println("Course Code: " + coursecode);
			System.out.println("Course Description: " + courseDescription);
			System.out.println("Is the above information on your course correct? Please enter:");
			System.out.println(
					"1. Yes \n2. Change course name. \n3. Get new course code. \n4. Change course description. \n5. Exit course creation screen without course creation.");
			selection = scnr.nextInt();
			if (selection == 1) {
				Course course = new Course(teacher, coursename, coursecode, courseDescription);
				cat.addCourse(course);
				teacher.setCourses(course);
				System.out.println(
						"1. Would you like to create another course? \n2. Would you like to return to general view page? \n3. Would you like to return to the main page?");
				for (i = 0; i < 1; i++) {
					selection = scnr.nextInt();
					if (selection == 1) {
						CourseCreationView(teacher);
					} else if (selection == 2) {
						TeacherGeneralView(teacher);
					} else if (selection == 3) {
						GeneralView();
					} else {
						System.out.println("Please select from one of the options above.");
						i--;
					}
				}
				break;
			} else if (selection == 2) {
				System.out.println("Please enter the name of the course you would like to create: ");
				scnr.nextLine();
				coursename = scnr.nextLine();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getName().equalsIgnoreCase(coursename)) {
						System.out
								.println("The name entered already exists in the system. \nPlease enter a new name: ");
						coursename = scnr.next();
						j--;
					}
				}
				i--;
			} else if (selection == 3) {
				random = rand.nextInt(1000, 10000);
				for (int d = 0; d < list.size(); d++) {
					if (list.get(d).getCode() == random) {
						random = rand.nextInt(1000, 10000);
						d = 0;
					}
				}
				coursecode = random;
				i--;
			} else if (selection == 4) {
				System.out.println("Please enter a description of your course: ");
				scnr.nextLine();
				courseDescription = scnr.nextLine();
				i--;
			} else if (selection == 5) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void CourseDeletionView(Teacher teacher) {
		System.out.println(
				"You have selected the option to delete a course from the database. \nPlease enter DELETE to confirm your selection. Any other entry will return to the multi course view.");
		String selection1 = scnr.next();
		if (selection1.equalsIgnoreCase("DELETE")) {
			System.out.println(
					"These are the current courses you teach. \nPlease enter the course code of the course you would like to delete:");
			List<Course> courses = teacher.getCourses();
			int num = 1;
			for (int i = 0; i < courses.size(); i++) {
				System.out
						.println(num + ". " + courses.get(i).getName() + "	Course Code: " + courses.get(i).getCode());
				num++;
			}
			int selection2 = scnr.nextInt();
			List<Course> list = cat.getCourses();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCode() == selection2) {
					Course course = list.get(i);
					System.out.println(
							"The course has been found in the catalog. Are you sure you want to delete the course with course code "
									+ course.getCode()
									+ "? \nEnter 1 for yes. This will be the last warning. Any other input will return to the multi course view.");
					selection = scnr.nextInt();
					if (selection == 1) {
						cat.removeCourse(course);
						teacher.getCourses().remove(course);
						System.out.println("The Course has been deleted. Now returning to menu.");
						TeacherMultiCourseView(teacher);
						break;
					} else {
						TeacherMultiCourseView(teacher);
						break;
					}
				}
			}
		} else {
			TeacherMultiCourseView(teacher);
		}
	}

	public static void AssignmentCreationView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		List<Assignment> list1 = course.getAssignments();
		System.out.println("Please enter the name of the assignment you would like to create: ");
		scnr.nextLine();
		String assignmentName = scnr.nextLine();
		for (int j = 0; j < list1.size(); j++) {
			if (list1.get(j).getName().equalsIgnoreCase(assignmentName)) {
				System.out.println("The name entered already exists in the system. \nPlease enter a new name: ");
				scnr.nextLine();
				assignmentName = scnr.nextLine();
				j--;
			}
		}
		int random = rand.nextInt(1000, 10000);
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getCode() == random) {
				random = rand.nextInt(1000, 10000);
				i = 0;
			}
		}
		int assignmentcode = random;
		System.out.println("Please enter a description of your assignment: ");
		String assignmentDescription = scnr.nextLine();
		System.out.println("Please enter a weight of your assignment: ");
		Double assignmentWeight = scnr.nextDouble();
		System.out.println("Please enter a due date for your assignment: ");
		String assignmentDueDate = scnr.next();
		for (int i = 0; i < 1; i++) {
			System.out.println("Assignment Name: " + assignmentName);
			System.out.println("Assignment Code: " + assignmentcode);
			System.out.println("Assignment Description: " + assignmentDescription);
			System.out.println("Assignment Due Date: " + assignmentDueDate);
			System.out.println("Assignment Weight: " + assignmentWeight);
			System.out.println("Is the above information on your assignment correct? Please enter: ");
			System.out.println(
					"1. Yes \n2. Change assignment name \n3. Change assignment code \n4. Change assignment description "
							+ "\n5. Change assignment due date, \n6. Change assignment weight \n7. Exit course creation without saving");
			selection = scnr.nextInt();
			if (selection == 1) {
				Assignment assignment = new Assignment(assignmentName, assignmentcode, assignmentDescription,
						assignmentDueDate, course, assignmentWeight);
				course.addAssignments(assignment);
				System.out.println(
						"What would you like to do? \n1. Create another assignment \n2. Delete An Assignment \n3. Return to course view \n4. Log Out");
				for (i = 0; i < 1; i++) {
					selection = scnr.nextInt();
					if (selection == 1) {
						AssignmentCreationView(teacher, course);
						break;
					} else if (selection == 2) {
						AssignmentDeletionView(teacher, course);
						break;
					} else if (selection == 3) {
						TeacherSingleCourseView(teacher, course);
						break;
					} else if (selection == 4) {
						GeneralView();
						break;
					} else {
						System.out.println("Please select from one of the options above.");
						i--;
					}
				}
			} else if (selection == 2) {
				System.out.println("Please enter the name of the course you would like to create: ");
				scnr.nextLine();
				assignmentName = scnr.nextLine();
				for (int j = 0; j < list1.size(); j++) {
					if (list1.get(j).getName().equalsIgnoreCase(assignmentName)) {
						System.out
								.println("The name entered already exists in the system. \nPlease enter a new name: ");
						scnr.nextLine();
						assignmentName = scnr.nextLine();
						j--;
					}
				}
				i--;
			} else if (selection == 3) {
				random = rand.nextInt(1000, 10000);
				for (int v = 0; v < list1.size(); v++) {
					if (list1.get(v).getCode() == random) {
						random = rand.nextInt(1000, 10000);
						v = 0;
					}
				}
				assignmentcode = random;
				i--;
			} else if (selection == 4) {
				System.out.println("Please enter a description of your assignment: ");
				assignmentDescription = scnr.nextLine();
				i--;
			} else if (selection == 5) {
				System.out.println("Please enter a due date for your assignment: ");
				assignmentDueDate = scnr.next();
				i--;
			} else if (selection == 6) {
				System.out.println("Please enter a weight for your assignment: ");
				assignmentWeight = scnr.nextDouble();
				i--;
			} else if (selection == 7) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void AssignmentDeletionView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("You have selected the option to delete an assignment from the course: " + course.getName()
				+ ". \nPlease enter DELETE to confirm your selection. Any other entry will return to the multi assignment view.");
		String selection1 = scnr.next();
		if (selection1.equalsIgnoreCase("DELETE")) {
			System.out.println(
					"These are the current assignments of the course. \nPlease enter the assignment code of the assignment you would like to delete:");
			List<Assignment> assignments = course.getAssignments();
			int num = 1;
			for (int i = 0; i < assignments.size(); i++) {
				System.out.println(num + ". " + assignments.get(i).getName() + "	Assignment Code: "
						+ assignments.get(i).getCode());
				num++;
			}
			int selection2 = scnr.nextInt();
			for (int i = 0; i < assignments.size(); i++) {
				if (assignments.get(i).getCode() == selection2) {
					Assignment assignment = assignments.get(i);
					System.out.println(
							"The assignment has been found in the course. Are you sure you want to delete the assignment with the assignment code?"
									+ assignment.getCode() + "? \n Enter 1 to deleted. Any other will return to menu.");
					selection = scnr.nextInt();
					if (selection == 1) {
						course.getAssignments().remove(assignment);
						System.out.println("The assignment has been deleted. Now returning to multi assignment menu.");
						TeacherMultiAssignmentView(teacher, course);
						break;
					} else if (selection == 2) {
						TeacherMultiAssignmentView(teacher, course);
						break;
					}
				}
			}
		} else {
			TeacherMultiAssignmentView(teacher, course);
		}
	}

	public static void StudentProfileView(Student student) {
		System.out.println("My Profile View");
		System.out.println("Student name: " + student.getName());
		System.out.println("Student Code: " + student.getCode());
		System.out.println("Student Date of Birth: " + student.getDOB());
		System.out.println("Student Phone number: " + student.getNum());
		System.out.println("Username: " + student.getUsername());
		System.out.println("Password: " + student.getPassword());
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Change Username \n2. Change Password \n3. Change Birthday \n4. Change Phone Number \n5. Return to general view");
			selection = scnr.nextInt();
			if (selection == 1) {
				System.out.println("Please enter your new Username.");
				student.setUsername(scnr.next());
				StudentProfileView(student);
				break;
			} else if (selection == 2) {
				System.out.println("Please enter your new Password.");
				student.setPassword(scnr.next());
				StudentProfileView(student);
				break;
			} else if (selection == 3) {
				System.out.println("Please enter your new Date of Birth.");
				student.setDOB(scnr.next());
				StudentProfileView(student);
				break;
			} else if (selection == 4) {
				System.out.println("Please enter your new phone number");
				student.setNum(scnr.next());
				StudentProfileView(student);
				break;
			} else if (selection == 5) {
				StudentGeneralView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherProfileView(Teacher teacher) {
		System.out.println("My Profile View");
		System.out.println("Name: " + teacher.getName());
		System.out.println("Username: " + teacher.getUsername());
		System.out.println("Password " + teacher.getPassword());
		System.out.println("Date of Birth: " + teacher.getDOB());
		System.out.println("Phone Number: " + teacher.getNum());
		System.out.println(
				"What would you like to do? \n1. Change Username \n2. Change Password \n3. Change Date of Birth \n4. Change Phone Number \n5. Return to Teacher View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				System.out.println("New Username: ");
				teacher.setUsername(scnr.next());
				TeacherProfileView(teacher);
				break;
			} else if (selection == 2) {
				System.out.println("New Password: ");
				teacher.setPassword(scnr.next());
				TeacherProfileView(teacher);
				break;
			} else if (selection == 3) {
				System.out.println("New Date of Birth: ");
				teacher.setDOB(scnr.next());
				TeacherProfileView(teacher);
				break;
			} else if (selection == 4) {
				System.out.println("New Phone Number: ");
				teacher.setNum(scnr.next());
				TeacherProfileView(teacher);
				break;
			} else if (selection == 5) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentMultiCourseView(Student student) {
		System.out.println("These are the courses you are currently enrolled in: ");
		List<Course> courses = student.getCourses();
		int num = 1;
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(num + ". Course Name:" + courses.get(i).getName() + "\tCourse Code: "
					+ courses.get(i).getCode() + "\tCourse Teacher: " + courses.get(i).getTeacher().getName());
			num++;
		}
		System.out.println("What would you like to do? \n1. Select Specific Course \n2. Return to Student View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				for (i = 0; i < 1; i++) {
					System.out.println("Please enter the course code of the course you would like to view: ");
					int selection2 = scnr.nextInt();
					for (i = 0; i < courses.size(); i++) {
						if (courses.get(i).getCode() == selection2) {
							StudentSingleCourseView(student, courses.get(i));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the classes you are in. \n1.Re-enter a Code \n2. Return to Student menu");
					for (int j = 0; j < 1; j++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							i--;
							break;
						} else if (selection == 2) {
							StudentGeneralView(student);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							j--;
						}
					}
				}
				break;
			} else if (selection == 2) {
				StudentGeneralView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentSingleCourseView(Student student, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("Teacher: " + course.getTeacher().getName());
		System.out.println("Course Name: " + course.getName());
		System.out.println("Course Code: " + course.getCode());
		System.out.println("Course Description: " + course.getDescription());
		System.out.println(
				"What would you like to do? \n1. View Assignments \n2. View Lecture Materials \n3. Return to Multi Course View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				StudentMultiAssignmentView(student, course);
				break;
			} else if (selection == 2) {
				StudentMultiMaterialView(student, course);
				break;
			} else if (selection == 3) {
				StudentMultiCourseView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherSingleCourseView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("Course Name: " + course.getName());
		System.out.println("Course Code: " + course.getCode());
		System.out.println("Course Description: " + course.getDescription());
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Change Course Information \n2. View Students \n3. View Assignments \n4. View Lecture Materials \n5. Return to Multi Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"What would you like to do? \n1. Change Course Name \n2. Change Course Code \n3. Change Course Description \n4. Return to Multi Course View");
					selection = scnr.nextInt();
					if (selection == 1) {
						System.out.println("Please enter a new course name: ");
						scnr.nextLine();
						course.setName(scnr.nextLine());
						TeacherSingleCourseView(teacher, course);
						break;
					} else if (selection == 2) {
						int random = rand.nextInt(1000, 10000);
						for (int x = 0; x < cat.getCourseCodes().size(); x++) {
							if (cat.getCourseCodes().get(i) == random) {
								random = rand.nextInt(1000, 10000);
								x = 0;
							}
						}
						course.setCode(random);
						TeacherSingleCourseView(teacher, course);
						break;
					} else if (selection == 3) {
						System.out.println("Please enter a new course description: ");
						scnr.nextLine();
						course.setDescription(scnr.nextLine());
						TeacherSingleCourseView(teacher, course);
						break;
					} else if (selection == 4) {
						TeacherMultiCourseView(teacher);
						break;
					} else {
						System.out.println("Please select from one of the options above.");
						j--;
					}
				}
				break;
			} else if (selection == 2) {
				TeacherCourseStudentsView(teacher, course);
				break;
			} else if (selection == 3) {
				TeacherMultiAssignmentView(teacher, course);
				break;
			} else if (selection == 4) {
				TeacherMultiMaterialView(teacher, course);
				break;
			} else if (selection == 5) {
				TeacherMultiCourseView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherMultiCourseView(Teacher teacher) {
		System.out.println("These are the courses you are currently teaching: ");
		List<Course> courses = teacher.getCourses();
		int num = 1;
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(
					num + ". Course Name: " + courses.get(i).getName() + "\tCourse Code: " + courses.get(i).getCode());
			num++;
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select Specific Course \n2. Create New Course \n3. Delete Course \n4. Return to Teacher View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int s = 0; s < 1; s++) {
					System.out.println("Please enter the course code of the course you would like to view: ");
					int selection2 = scnr.nextInt();
					for (i = 0; i < courses.size(); i++) {
						if (courses.get(i).getCode() == selection2) {
							TeacherSingleCourseView(teacher, courses.get(i));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the classes you are in. \n1. Re-enter code \n2. Return to Teacher View?");
					for (int j = 0; j < 1; j++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							s--;
							break;
						} else if (selection == 2) {
							TeacherGeneralView(teacher);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							j--;
						}
					}
				}
				break;
			} else if (selection == 2) {
				CourseCreationView(teacher);
				break;
			} else if (selection == 3) {
				CourseDeletionView(teacher);
				break;
			} else if (selection == 4) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentSingleAssignmentView(Student student, Course course, Assignment assignment) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		List<Submission> sub = student.getSubmissions();
		System.out.println("Course Name: " + course.getName());
		System.out.println("Assignment Name: " + assignment.getName());
		System.out.println("Assignment Due: " + assignment.getDueDate());
		System.out.println("Assignment Weight: " + assignment.getWeight());
		System.out.println("Assignment Description: " + assignment.getDescription());
		for (int j = 0; j < sub.size(); j++) {
			if (sub.get(j).getAssignment() == assignment && sub.get(j).getGradeStatus() == true) {
				System.out.println("Assignment Completion Status: Complete");
				System.out.println("Assignment Grade: " + sub.get(j).getGrade());
				System.out.println("Assignment Feedback: " + sub.get(j).getFeedback());
			}
		}
		System.out.println(
				"What would you like to do? \n1. Create/View Submission \n2. Return to Assignments List \n3. Return to Student View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				StudentSubmissionView(student, course, assignment);
				break;
			} else if (selection == 2) {
				StudentMultiAssignmentView(student, course);
				break;
			} else if (selection == 3) {
				StudentGeneralView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentMultiAssignmentView(Student student, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		List<Assignment> list = course.getAssignments();
		List<Assignment> alreadySubmittedAssignments = new ArrayList<Assignment>();
		List<Submission> submissions = student.getSubmissions();
		List<Assignment> list2 = new ArrayList<Assignment>();
		for (int y = 0; y < list.size(); y++) {
			list2.add(list.get(y));
		}
		for (int y = 0; y < submissions.size(); y++) {
			alreadySubmittedAssignments.add(submissions.get(y).getAssignment());
		}
		for (int y = 0; y < alreadySubmittedAssignments.size(); y++) {
			if (list2.contains(alreadySubmittedAssignments.get(y))) {
				list2.remove(alreadySubmittedAssignments.get(y));
			}
		}
		System.out
				.println("These are the current assignments for Course " + course.getCode() + ": " + course.getName());
		for (int i = 0; i < submissions.size(); i++) {
			System.out.print("Assignment Name: " + submissions.get(i).getAssignment().getName() + "\t"
					+ "Assignment Code: " + submissions.get(i).getAssignment().getCode() + "\t"
					+ "Submission Status: Submitted" + "\t" + "Grade: " + submissions.get(i).getGrade());
		}
		for (int i = 0; i < list2.size(); i++) {
			System.out.println("Assignment Name: " + list2.get(i).getName() + "\t" + "Assignment Code: "
					+ list2.get(i).getCode() + "\t" + "Submission Status: Not Submitted");
		}
		System.out.println("Your current final grade not incuding any unsubmitted assignments is: "
				+ student.getOverallGrade(course));
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select assignment for detailed view \n2. Return to Student Course View \n3. Return to Multi Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter the assignment code of the assignment you would like to see a detailed view of: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < list.size(); x++) {
						if (list.get(x).getCode() == selection2) {
							StudentSingleAssignmentView(student, course, list.get(x));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the assignment available you are in. \n1. Re-enter \n2. return to The Course View?");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							j--;
							break;
						} else if (selection == 2) {
							StudentSingleCourseView(student, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}
				}
				break;
			} else if (selection == 2) {
				StudentSingleCourseView(student, course);
				break;
			} else if (selection == 3) {
				StudentMultiCourseView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherMultiAssignmentView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println(
				"These are the current assignments for Course " + course.getCode() + ": " + course.getName() + "\n");
		List<Assignment> list = course.getAssignments();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					"Assignment Name: " + list.get(i).getName() + "\t Assaignment Code: " + list.get(i).getCode());
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select assignment for detailed view \n2. Create New Assignment \n3. Delete Assignment  \n4. Return to Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter the assignment code of the assignment you would like to see a detailed view of: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < list.size(); x++) {
						if (list.get(x).getCode() == selection2) {
							TeacherSingleAssignmentView(teacher, course, list.get(x));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the assignment available you are in. \n1. Re-enter \n2. return to The Course View");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							i--;
							break;
						} else if (selection == 2) {
							TeacherSingleCourseView(teacher, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}
				}
				break;
			} else if (selection == 2) {
				AssignmentCreationView(teacher, course);
				break;
			} else if (selection == 3) {
				AssignmentDeletionView(teacher, course);
				break;
			} else if (selection == 4) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherCourseStudentsView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println(
				"These are the current students for Course " + course.getCode() + ": " + course.getName() + "\n");
		List<Student> list = course.getStudents();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Student Name: " + list.get(i).getName() + "\tStudent Code: " + list.get(i).getCode() + "\t Current Grade: "
					+ list.get(i).getOverallGrade(course));
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select student to view submissions \n2. Remove Student from Course  \n3. Return to Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter the student identification code of the student whose assignment submisisons you would like to see a detailed view of: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < list.size(); x++) {
						if (list.get(x).getCode() == selection2) {
							TeacherStudentSubmissionsView(teacher, course, list.get(x));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the students in this course. \n1. Re-enter code \n2. return to The Course View");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							j--;
							break;
						} else if (selection == 2) {
							TeacherSingleCourseView(teacher, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}
				}
			} else if (selection == 2) {
				System.out.println(
						"Are you sure you would like to remove a student from this course? Submissions to the class will remain. \nPlease enter DELETE to confirm your choice. Any other input will  return to the course view.");
				String selection1 = scnr.next();
				if (selection1.equalsIgnoreCase("DELETE")) {
					System.out.println(
							"These are the current students of the course. \nPlease enter the identification code of the student you would like to remove:");
					List<Student> students = course.getStudents();
					int num = 1;
					for (i = 0; i < students.size(); i++) {
						System.out.println(num + ". " + students.get(i).getName() + "	Student Code: "
								+ students.get(i).getCode());
						num++;
					}
					int selection3 = scnr.nextInt();
					for (i = 0; i < students.size(); i++) {
						if (students.get(i).getCode() == selection3) {
							Student student = students.get(i);
							System.out.println(
									"The student has been found in the course. Are you sure you want to remove the student with the identification code "
											+ student.getCode()
											+ "? \n Enter 1 to delete. Any other input will return to menu.");
							selection = scnr.nextInt();
							if (selection == 1) {
								course.getStudents().remove(student);
								System.out.println("The student has been removed. Now returning to student list.");
								TeacherMultiAssignmentView(teacher, course);
								break;
							} else {
								TeacherMultiAssignmentView(teacher, course);
								break;
							}
						}
					}
				} else {
					TeacherSingleCourseView(teacher, course);
				}
				break;
			} else if (selection == 3) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherStudentSubmissionsView(Teacher teacher, Course course, Student student) {
		System.out.println("These are the current submissions " + student.getName() + " has submitted to the course "
				+ course.getName() + ". ");
		for (int i = 0; i < student.getSubmissions().size(); i++) {
			if (student.getSubmissions().get(i).getCourse().equals(course)) {
				System.out.print("Assignment Name: " + student.getSubmissions().get(i).getAssignment().getName() + "\t"
						+ "Assignment Code: " + student.getSubmissions().get(i).getAssignment().getCode() + "\t"
						+ "Grade: " + student.getSubmissions().get(i).getGrade());
			}
		}
		System.out.println(
				"The current final grade of the student in this course is: " + student.getOverallGrade(course));
		System.out.println(
				"Note that if the overall grade exceeds 100 there may be an error in the specified assignment weights or the grades given to the assignments. \nPlease check the course assignment list to make sure the assignments are graded and weighed correctly.");
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do now? \n1. Return to student list \n2. Return to course view \n3. Grade one of the above student submissions \n4. Go to course assignments list");
			selection = scnr.nextInt();
			if (selection == 1) {
				TeacherCourseStudentsView(teacher, course);
				break;
			} else if (selection == 2) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else if (selection == 3) {
				List<Submission> subs = student.getSubmissions();
				for (int j = 0; j < 1; j++) {
					System.out.println("Please enter the assignment code of the assignment you would like to grade: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < subs.size(); x++) {
						if (subs.get(x).getAssignment().getCode() == selection2) {
							TeacherGradeView(teacher, course, subs.get(x), student);
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the assignment available you are in. \n1. Re-enter \n2. return to The Course View");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							j--;
							break;
						} else if (selection == 2) {
							TeacherSingleCourseView(teacher, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}
				}
				break;
			} else if (selection == 4) {
				TeacherMultiAssignmentView(teacher, course);
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}

	}

	public static void TeacherSingleAssignmentView(Teacher teacher, Course course, Assignment assignment) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("Course Name: " + course.getName());
		System.out.println("Assignment Name: " + assignment.getName());
		System.out.println("Assignment Code: " + assignment.getCode());
		System.out.println("Assignment Due: " + assignment.getDueDate());
		System.out.println("Assignment Weight: " + assignment.getWeight());
		System.out.println("Assignment Description: " + assignment.getDescription());
		System.out.println(
				"\nWhat would you like to do? \n1. Change Assignment Information \n2. Return to Assignments List \n3. Return to Course View \n");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println("Please Enter: " + "\n1. change assignment name \n2. change assignment code "
							+ "\n3. change assignment due date \n4. change assignment weight \n5. change assignment description"
							+ "\n6. return to material view without changing anything");
					selection = scnr.nextInt();
					if (selection == 1) {
						System.out.println("Please enter the assignment name: ");
						assignment.setName(scnr.nextLine());
						scnr.nextLine();
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else if (selection == 2) {
						int random = rand.nextInt(1000, 10000);
						for (int a = 0; a < course.getAssignments().size(); a++) {
							if (course.getAssignments().get(a).getCode() == random) {
								random = rand.nextInt(1000, 10000);
								a = 0;
							}
						}
						assignment.setCode(random);
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else if (selection == 3) {
						System.out.println("Please enter new due date: ");
						assignment.setDueDate(scnr.next());
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else if (selection == 4) {
						System.out.println("Please enter a new weight: ");
						assignment.setWeight(scnr.nextDouble());
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else if (selection == 5) {
						System.out.println("Please enter a new description: ");
						assignment.setDescription(scnr.nextLine());
						scnr.nextLine();
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else if (selection == 6) {
						TeacherSingleAssignmentView(teacher, course, assignment);
						break;
					} else {
						System.out.println("Please select from one of the options above.");
						j--;
					}
				}
			} else if (selection == 2) {
				TeacherMultiAssignmentView(teacher, course);
				break;
			} else if (selection == 3) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentSubmissionView(Student student, Course course, Assignment assignment) {
		List<Submission> list = student.getSubmissions();
		Boolean exists = false;
		int x = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAssignment().equals(assignment)) {
				exists = true;
				x = i;
				System.out.println("The current submission is: Answer: " + list.get(i).getAnswer() + "	Grade: "
						+ list.get(i).getGrade() + "	Feedback: " + list.get(i).getFeedback());
			}
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Create new submission \n2. Update submission \n3. Return to Assignment View");
			selection = scnr.nextInt();
			if (selection == 1 && !exists) {
				Submission submission = new Submission(student, course, assignment);
				System.out.println(
						"Please enter what you would like to submit as your answer for this assignment. The assignment description is: "
								+ assignment.getDescription());
				scnr.nextLine();
				String select = scnr.nextLine();
				submission.setAnswer(select);
				student.addSubmissions(submission);
				StudentSubmissionView(student, course, assignment);
				break;
			} else if (selection == 1 && exists) {
				System.out.println("A submission already exists. Updating submission.");
				System.out.println(
						"Please enter what you would like to submit as your answer for this assignment. The assignment description is: "
								+ assignment.getDescription());
				scnr.nextLine();
				String select = scnr.nextLine();
				list.get(x).setAnswer(
						"Submission Updated. Previous grade was: " + list.get(x).getGrade() + "New Answer: " + select);
				list.get(x).setFeedback(null);
				list.get(x).setGrade(null);
				StudentSubmissionView(student, course, assignment);
				break;
			} else if (selection == 2) {
				System.out.println(
						"Please enter what you would like to change your answer to. The assignment description is: "
								+ assignment.getDescription());
				scnr.nextLine();
				String select = scnr.nextLine();
				Submission submission = list.get(x);
				submission.setAnswer(select);
				StudentSubmissionView(student, course, assignment);
				StudentProfileView(student);
				break;
			} else if (selection == 3) {
				StudentSingleAssignmentView(student, course, assignment);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherGradeView(Teacher teacher, Course course, Submission submission, Student student) {
		System.out.println("The assignment description was: " + submission.getAssignment().getDescription());
		System.out.println("The answer given by " + student.getName() + " was: " + submission.getAnswer());
		System.out.println(
				"What would you like to do? \n1. Give feedback \n2. Change Grade \n3. Return to Student Submisisons View \n4. Return to Course Students View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				System.out.println("Feedback: ");
				submission.setFeedback(scnr.nextLine());
				scnr.nextLine();
				TeacherGradeView(teacher, course, submission, student);
				break;
			} else if (selection == 2) {
				System.out.println("Note: The grade should be a decimal number from 0.00-100.00.");
				System.out.println("Grade: ");
				submission.setGrade(scnr.nextDouble());
				submission.setGradeStatus(true);
				TeacherGradeView(teacher, course, submission, student);
				break;
			} else if (selection == 3) {
				TeacherStudentSubmissionsView(teacher, course, student);
				break;
			} else if (selection == 4) {
				TeacherCourseStudentsView(teacher, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentMultiMaterialView(Student student, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("These are the current materials for Course " + course.getCode() + ": " + course.getName());
		List<LectureMaterials> list = course.getMaterials();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Course Name: " + list.get(i).getName() + "\tCourse Code: " + list.get(i).getCode());
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select lecture material for detailed view \n2. Return to Student Course View \n3. Return to Multi Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter the material code of the lecture material you would like to see a detailed view of: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < list.size(); x++) {
						if (list.get(x).getCode() == selection2) {
							StudentSingleMaterialView(student, course, list.get(x));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the assignment available you are in. \n1. Re-enter \n2. return to The Course View?");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							j--;
							break;
						} else if (selection == 2) {
							StudentSingleCourseView(student, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}

				}
			} else if (selection == 2) {
				StudentSingleCourseView(student, course);
				break;
			} else if (selection == 3) {
				StudentMultiCourseView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void StudentSingleMaterialView(Student student, Course course, LectureMaterials lecmat) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("Material Name: " + lecmat.getName());
		System.out.println("Material Code: " + lecmat.getCode());
		System.out.println("Material Description: " + lecmat.getDescription());
		System.out.println("Material URL: " + lecmat.getURL());
		System.out.println(
				"What would you like to do? \n1. Return to Multi material View \n2. View Course Assignments \n3. Return to Course View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				StudentMultiMaterialView(student, course);
				break;
			} else if (selection == 2) {
				StudentMultiAssignmentView(student, course);
				break;
			} else if (selection == 3) {
				StudentSingleCourseView(student, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherMultiMaterialView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("These are the current materials for Course " + course.getCode() + ": " + course.getName());
		List<LectureMaterials> list = course.getMaterials();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Material Name: \tMaterial Code");
			System.out.println(list.get(i).getName() + "\t" + list.get(i).getCode());
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(
					"What would you like to do? \n1. Select lecture material for detailed view \n2. Create New Lecture Material \n3. Delete Lecture Material \n4. Return to Teacher Course View \n5. Return to Multi Course View");
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter the material code of the lecture material you would like to see a detailed view of: ");
					int selection2 = scnr.nextInt();
					for (int x = 0; x < list.size(); x++) {
						if (list.get(x).getCode() == selection2) {
							TeacherSingleMaterialView(teacher, course, list.get(x));
							break;
						}
					}
					System.out.println(
							"The code you entered does not match any of the codes of the materials available. \n1. Re-enter \n2. return to The Course View?");
					for (int k = 0; k < 1; k++) {
						selection = scnr.nextInt();
						if (selection == 1) {
							j--;
							break;
						} else if (selection == 2) {
							TeacherSingleCourseView(teacher, course);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							k--;
						}
					}
				}
			} else if (selection == 2) {
				LectureMaterialCreationView(teacher, course);
				break;
			} else if (selection == 3) {
				LectureMaterialDeletionView(teacher, course);
				break;
			} else if (selection == 4) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else if (selection == 5) {
				TeacherMultiCourseView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherSingleMaterialView(Teacher teacher, Course course, LectureMaterials lecmat) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		List<LectureMaterials> list = course.getMaterials();
		System.out.println("Material Name: " + lecmat.getName());
		System.out.println("Material Code: " + lecmat.getCode());
		System.out.println("Material Description: " + lecmat.getDescription());
		System.out.println("Material URL: " + lecmat.getURL());
		System.out.println(
				"What would you like to do? \n1. Edit Lecture Material \n2. Delete Lecture Material \n3. Return to Multi material View \n4. View Course Assignments \n5. Return to Course View");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				for (int j = 0; j < 1; j++) {
					System.out.println(
							"Please enter: \n1. change the material name \n2. change the material code \n3. change the material description \n4. change the material URL \n5. Exit material view without save");
					selection = scnr.nextInt();
					if (selection == 1) {
						System.out.println("Please enter the material name: ");
						lecmat.setName(scnr.nextLine());
						scnr.nextLine();
						TeacherSingleMaterialView(teacher, course, lecmat);
						break;
					} else if (selection == 2) {
						int random = rand.nextInt(1000, 10000);
						for (int p = 0; p < list.size(); p++) {
							if (list.get(p).getCode() == random) {
								random = rand.nextInt(1000, 10000);
								p = 0;
							}
						}
						lecmat.setCode(random);
						TeacherSingleMaterialView(teacher, course, lecmat);
						break;
					} else if (selection == 3) {
						System.out.println("Please enter a description: ");
						lecmat.setDescription(scnr.nextLine());
						scnr.nextLine();
						TeacherSingleMaterialView(teacher, course, lecmat);
						break;
					} else if (selection == 4) {
						System.out.println("Please enter a URL for your material: ");
						lecmat.setURL(scnr.next());
						TeacherSingleMaterialView(teacher, course, lecmat);
						break;
					} else if (selection == 5) {
						TeacherSingleMaterialView(teacher, course, lecmat);
						break;
					} else {
						System.out.println("Please select from one of the options above.");
						j--;
					}
				}
			} else if (selection == 2) {
				LectureMaterialDeletionView(teacher, course);
				break;
			} else if (selection == 3) {
				TeacherMultiMaterialView(teacher, course);
				break;
			} else if (selection == 4) {
				TeacherMultiAssignmentView(teacher, course);
				break;
			} else if (selection == 5) {
				TeacherSingleCourseView(teacher, course);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void LectureMaterialCreationView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		List<LectureMaterials> list1 = course.getMaterials();
		System.out.println("Please enter the name of the lecture material you would like to create: ");
		scnr.nextLine();
		String materialName = scnr.nextLine();
		for (int j = 0; j < list1.size(); j++) {
			if (list1.get(j).getName().equalsIgnoreCase(materialName)) {
				System.out.println("The name entered already exists in the system. Please enter a new name: ");
				scnr.nextLine();
				materialName = scnr.nextLine();
				j--;
			}
		}
		int random = rand.nextInt(1000, 10000);
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getCode() == random) {
				random = rand.nextInt(1000, 10000);
				i = 0;
			}
		}
		int materialCode = random;
		System.out.println("Please enter a URL for your assignment: ");
		String materialURL = scnr.next();
		System.out.println("Please enter a description of your assignment: ");
		scnr.nextLine();
		String materialDescription = scnr.nextLine();
		for (int i = 0; i < 1; i++) {
			System.out.println("Material Name: " + materialName);
			System.out.println("Material Code: " + materialCode);
			System.out.println("Material Description: " + materialDescription);
			System.out.println("Material URL: " + materialURL);
			System.out.println("Is the above information on your lecture material correct? Please enter:");
			System.out.println(
					"1. Yes \n2. change material name \n3. change material code \n4. change material description "
							+ "\n5. change material URL \n6. Exit course creation screen without saving.");
			selection = scnr.nextInt();
			if (selection == 1) {
				LectureMaterials lecmat = new LectureMaterials(course, materialName, materialCode, materialDescription,
						materialURL);
				course.addMaterials(lecmat);
				System.out.println(
						"The material has been created: \n1. Would you like to create another material? \n2. Would you like to return to your the course view? \n3. Would you like to return to general view?");
				for (i = 0; i < 1; i++) {
					selection = scnr.nextInt();
					if (selection == 1) {
						LectureMaterialCreationView(teacher, course);
						break;
					} else if (selection == 2) {
						TeacherSingleCourseView(teacher, course);
						break;
					} else if (selection == 3) {
						TeacherGeneralView(teacher);
						break;
					} else {
						System.out.println("Please select from one of the options above.");
						i--;
					}
				}
				break;
			} else if (selection == 2) {
				System.out.println("Please enter the name of the material you would like to create: ");
				scnr.nextLine();
				materialName = scnr.nextLine();
				i--;
			} else if (selection == 3) {
				random = rand.nextInt(1000, 10000);
				for (int v = 0; v < list1.size(); v++) {
					if (list1.get(v).getCode() == random) {
						random = rand.nextInt(1000, 10000);
						v = 0;
					}
				}
				materialCode = random;
				i--;
			} else if (selection == 4) {
				System.out.println("Please enter a description of your lecture material: ");
				scnr.nextLine();
				materialDescription = scnr.nextLine();
				i--;
			} else if (selection == 5) {
				System.out.println("Please enter a URL for your lecture material: ");
				materialURL = scnr.next();
				i--;
			} else if (selection == 6) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void LectureMaterialDeletionView(Teacher teacher, Course course) {
		course = cat.getCourses().get(cat.getCourses().indexOf(course));
		System.out.println("You have selected the option to delete an lecture material from the course "
				+ course.getName()
				+ ". Please enter DELETE to confirm your selection. Any other entry will return to the multi material view.");
		String selection1 = scnr.next();
		if (selection1.equalsIgnoreCase("DELETE")) {
			System.out.println(
					"These are the current lecture materials of the course. Please enter the material code of the material you would like to delete:");
			List<LectureMaterials> lecmats = course.getMaterials();
			int num = 1;
			for (int i = 0; i < lecmats.size(); i++) {
				System.out.println(
						num + ". " + lecmats.get(i).getName() + "	Material Code: " + lecmats.get(i).getCode());
				num++;
			}
			int selection2 = scnr.nextInt();
			for (int i = 0; i < lecmats.size(); i++) {
				if (lecmats.get(i).getCode() == selection2) {
					LectureMaterials lecmat = lecmats.get(i);
					System.out.println(
							"The material has been found in the course. Are you sure you want to delete the material with the material code"
									+ lecmat.getCode()
									+ "?\nEnter 1 for yes. This will be the last warning. Any other input will return to the multi material view.");
					selection = scnr.nextInt();
					if (selection == 1) {
						course.getMaterials().remove(lecmat);
						System.out.println("The material has been deleted. Now returning to multi material view.");
						TeacherMultiMaterialView(teacher, course);
						break;
					} else {
						TeacherMultiMaterialView(teacher, course);
						break;
					}
				}
			}
		} else {
			TeacherMultiMaterialView(teacher, course);
		}

	}

	public static void StudentCatalogueView(Student student) {
		System.out.println("Course Catalogue:");
		System.out.println("Courses: \t\tTeachers: \t\tCourse Code:");
		List<String> teachers = cat.getCourseTeachers();
		List<String> courses = cat.getCourseNames();
		List<Integer> courseCode = cat.getCourseCodes();
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i) + " \t\t" + teachers.get(i) + " \t\t" + courseCode.get(i));
		}
		System.out.println("Would you like to add one of the courses above to your courses list? "
				+ "\n1. Yes \n2. return to student view.");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				System.out.println(
						"What course would you like to add?" + "\nPlease enter the course code below to be added:");
				int code = scnr.nextInt();
				for (int j = 0; j < courses.size(); j++) {
					if (cat.getCourses().get(i).getCode() == code
							&& !student.getCourses().contains(cat.getCourses().get(i))) {
						cat.getCourses().get(i).addStudents(student);
						student.setCourses(cat.getCourses().get(i));
						System.out.println("The course has been added to your courses list."
								+ " \n1. Add more course \n2. Return to The Student View?");
						for (int k = 0; k < 1; k++) {
							selection = scnr.nextInt();
							if (selection == 1) {
								StudentCatalogueView(student);
								break;
							} else if (selection == 2) {
								StudentGeneralView(student);
								break;
							} else {
								System.out.println("Please select from one of the options above.");
								j--;
							}
						}
						break;
					} else if (j == courses.size() - 1) {
						System.out.println(
								"The code you entered does not exist in the course catalog.  \n1. Re-enter the code \n2. return to The Student View?");
						selection = scnr.nextInt();
						if (selection == 1) {
							System.out.println("Please enter the course code below: ");
							code = scnr.nextInt();
							j = 0;
						} else if (selection == 2) {
							StudentGeneralView(student);
							break;
						} else {
							System.out.println("Please select from one of the options above.");
							j--;
						}
					}
				}
				break;
			} else if (selection == 2) {
				StudentGeneralView(student);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}

	public static void TeacherCatalogueView(Teacher teacher) {
		System.out.println("Course Catalogue:");
		System.out.println("Courses: \t\tTeachers:");
		List<String> teachers = cat.getCourseTeachers();
		List<String> courses = cat.getCourseNames();
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i) + " \t\t" + teachers.get(i));
		}
		System.out.println(
				"\n1. Would you like to add a new course to the catalogue? \n2. Would you like to see the courses that you have created that are currently running? \n3. Would you like to return to the teacher general view?");
		for (int i = 0; i < 1; i++) {
			selection = scnr.nextInt();
			if (selection == 1) {
				CourseCreationView(teacher);
				break;
			} else if (selection == 2) {
				TeacherMultiCourseView(teacher);
				break;
			} else if (selection == 3) {
				TeacherGeneralView(teacher);
				break;
			} else {
				System.out.println("Please select from one of the options above.");
				i--;
			}
		}
	}
}
