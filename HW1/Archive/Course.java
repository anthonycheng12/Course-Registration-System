import java.util.Comparator;
import java.util.List;

public class Course implements Comparable<Course> {
	private String courseName;
	private int courseID;
	private int maxStudents;
	private int curStudent;
	private List<String> listOfNames;
	private String courseInstructor;
	private int sectionNumber;
	private String courseLocation;

	public Course(String courseName, int courseID, int maxStudents, int curStudent,
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
	}

	public void setCourseName (String courseName) {
		this.courseName = courseName;
	}

	public int getCourseID () {
		return courseID;
	}

	public void setCourseID (int courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents () {
		return maxStudents;
	}

	public void setMaxStudents (int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getCurStudent () {
		return curStudent;
	}

	public void setCurStudent (int curStudent) {
		this.curStudent = curStudent;
	}

	public List<String> getListOfNames () {
		return listOfNames;
	}

	public void setListOfNames (List<String> listOfNames) {
		this.listOfNames = listOfNames;
	}

	public String getCourseInstructor () {
		return courseInstructor;
	}

	public void setCourseInstructor (String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public int getSectionNumber () {
		return sectionNumber;
	}

	public void setSectionNumber (int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getCourseLocation () {
		return courseLocation;
	}

	public void setCourseLocation (String courseLocation) {
		this.courseLocation = courseLocation;
	}

	public void addName(String name) {
		if (curStudent < maxStudents) {
			this.listOfNames.add(name);
			curStudent++;
		}
	}

	public void removeName(String name) {
		if (this.listOfNames.remove(name)) {
			curStudent--;
		}
	}

	public String toString() {
		return this.courseName + "," + this.courseID + "," + this.maxStudents + "," +
				this.curStudent + "," + this.listOfNames + "," + this.courseInstructor + "," +
				this.sectionNumber + "," + this.courseLocation;
	}

	@Override
	public int compareTo (Course o) {
		if (this.curStudent > o.curStudent) {
			return 1;
		} else if (this.curStudent < o.curStudent) {
			return  -1;
		} else {
			return 0;
		}
	}
}
