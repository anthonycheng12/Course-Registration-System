import java.util.Comparator; 
import java.util.List;

public class Course implements Comparable<Course> {
	//declarations
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int curStudent;
	private List<String> listOfNames;
	private String courseInstructor;
	private int sectionNumber;
	private String courseLocation;
	//gives a course its info
	public Course(String courseName, String courseID, int maxStudents, int curStudent,
	              List<String> listOfNames, String courseInstructor, int sectionNumber,
	              String courseLocation) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.maxStudents = maxStudents;
		this.curStudent = curStudent;
		this.listOfNames = listOfNames;
		this.courseInstructor = courseInstructor;
		this.sectionNumber = sectionNumber;
		this.courseLocation = courseLocation;
	}

	public String getCourseName () {
		return courseName;
	} //get the course name

	public void setCourseName (String courseName) {
		this.courseName = courseName;
	} //set the course name

	public String getCourseID () {
		return courseID;
	} //get the course id

	public void setCourseID (String courseID) {
		this.courseID = courseID;
	} //set the course id

	public int getMaxStudents () {
		return maxStudents;
	} //find the max student

	public void setMaxStudents (int maxStudents) {
		this.maxStudents = maxStudents;
	} //set the max # of students

	public int getCurStudent () {
		return curStudent;
	} //get the current students

	public void setCurStudent (int curStudent) {
		this.curStudent = curStudent;
	} //set the current students

	public List<String> getListOfNames () {
		return listOfNames;
	} //get the list of names

	public void setListOfNames (List<String> listOfNames) {
		this.listOfNames = listOfNames;
	} //set the list of names

	public String getCourseInstructor () {
		return courseInstructor;
	} //get the course instructor

	public void setCourseInstructor (String courseInstructor) {
		this.courseInstructor = courseInstructor;
	} //set the course instructor

	public int getSectionNumber () {
		return sectionNumber;
	} //get the section number

	public void setSectionNumber (int sectionNumber) {
		this.sectionNumber = sectionNumber;
	} //set the section number

	public String getCourseLocation () {
		return courseLocation;
	} //get the course location

	public void setCourseLocation (String courseLocation) {
		this.courseLocation = courseLocation;
	} //set the course location

	public void addName(String name) {
		if (curStudent < maxStudents) {
			this.listOfNames.add(name);
			curStudent++;
		}
	} //adding names to the list of names

	public void removeName(String name) {
		if (this.listOfNames.remove(name)) {
			curStudent--;
		}
	} //removing names from the list of names

	public String toString() {
		return this.courseName + "," + this.courseID + "," + this.maxStudents + "," +
				this.curStudent + "," + this.listOfNames + "," + this.courseInstructor + "," +
				this.sectionNumber + "," + this.courseLocation;
	} //changes everything to a string

	@Override
	public int compareTo (Course o) {
		if (this.curStudent > o.curStudent) {
			return 1; //this.curStudent greater
		} else if (this.curStudent < o.curStudent) {
			return  -1; //o.curStudent greater
		} else {
			return 0; //equal
		}
	}
}
