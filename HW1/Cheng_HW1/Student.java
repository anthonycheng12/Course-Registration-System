import java.util.ArrayList; 
import java.util.List;
 
public class Student extends User implements StudentInterface  {
	public List<Course> courses = new ArrayList<Course>();

	public Student(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
		this.courses = new ArrayList<Course>();
	} //sets up a student profile

	@Override
	public void viewAllCourses () {
		for (Course course : HomeworkOne.courses) {
			System.out.println(course);
		}
	} //view all courses the student is in

	@Override
	public void viewAllNotFullCourses () {
		for (Course course : HomeworkOne.courses) {
			if (course.getMaxStudents() != course.getCurStudent()) {
				System.out.println(course);
			}
		}
	} //view courses that are not full 

	@Override
	public void registerForCourse (String courseName, int section) {
		Course currCourse = null;
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseName().equals(courseName) && course.getSectionNumber() == section) {
				currCourse = course;
				break;
			}
		} //allows the student to register for a course
		if (currCourse != null) {
			this.courses.add(currCourse);
			currCourse.addName(this.firstName + " " + this.lastName); //checks if the course has seats or not
		} else {
			System.out.println("Error: Course does not exist"); //course does not exist
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
	} //leave a course

	@Override
	public void viewMyCourses () {
		for (Course course : courses) {
			System.out.println(course);
		}
	} // view all the students courses
}