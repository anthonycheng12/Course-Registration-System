import java.util.ArrayList;
import java.util.List;

public class Student extends User implements StudentInterface  {
	public List<Course> courses;

	public Student(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
		this.courses = new ArrayList<Course>();
	}

	@Override
	public void viewAllCourses () {
		for (Course course : HomeworkOne.courses) {
			System.out.println(course);
		}
	}

	@Override
	public void viewAllNotFullCourses () {
		for (Course course : HomeworkOne.courses) {
			if (course.getMaxStudents() != course.getCurStudent()) {
				System.out.println(course);
			}
		}
	}

	@Override
	public void registerForCourse (String courseName, int section) {
		Course currCourse = null;
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseName().equals(courseName) && course.getSectionNumber() == section) {
				currCourse = course;
				break;
			}
		}
		if (currCourse != null) {
			this.courses.add(currCourse);
			currCourse.addName(this.firstName + " " + this.lastName);
		} else {
			System.out.println("Error: Course does not exist");
		}
	}

	@Override
	public void withdrawFromCourse (String courseName) {
		Course currCourse = null;
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseName().equals(courseName)) {
				currCourse = course;
				break;
			}
		}
		if (currCourse != null) {
			this.courses.remove(currCourse);
			currCourse.removeName(this.firstName + " " + this.lastName);
		} else {
			System.out.println("Error: Course does not exist");
		}
	}

	@Override
	public void viewMyCourses () {
		for (Course course : courses) {
			System.out.println(course);
		}
	}
}