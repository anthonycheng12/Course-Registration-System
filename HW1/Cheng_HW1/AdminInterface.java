import java.util.List;

public interface AdminInterface {
	public void createCourse (String courseName, String courseID, int maxStudents, int curStudent,
	                          List<String> listOfNames, String courseInstructor, int sectionNumber,
	                          String courseLocation);
	public void deleteCourse (String courseID);
	public void displayCourseInfo (String courseId);
	public void registerStudent (String username, String password, String firstName, String lastName);
	public void viewAllCourses ();
	public void viewAllFullCourses ();
	public void writeAllFullCourses ();
	public void viewStudentsInCourse (String courseId);
	public void viewCoursesOf (String firstName, String lastName);
	public void sortByUserRegisters ();
	public void exit ();
}
