import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Admin extends User implements AdminInterface {

	public Admin () { 
		this.username = "Admin";
		this.password = "Admin001";
		this.firstName = "Admin";
		this.lastName = "Admin";
	} //This is the admin's default login information

	@Override
	public void createCourse (String courseName, String courseID, int maxStudents, int curStudent,
	                          List<String> listOfNames, String courseInstructor, int sectionNumber,
	                          String courseLocation) {
		HomeworkOne.courses.add(new Course(courseName, courseID, maxStudents, curStudent,
				listOfNames, courseInstructor, sectionNumber, courseLocation));
	} //takes this from admininterface and is used to create a course. Also takes from the Course class to make the parameters the new course. 
	//Also adds to the homeworkone.java courses list.

	@Override
	public void deleteCourse (String courseId) {
		for (int i = 0; i < HomeworkOne.courses.size(); i++) {
			if (HomeworkOne.courses.get(i).getCourseID() == courseId) {
				HomeworkOne.courses.remove(HomeworkOne.courses.get(i));
			}
		}//If the courseID from the list at i is the same as the courseID then we will remove that from the list

		for (Student student : HomeworkOne.students) {
			for (int i = 0; i < student.courses.size(); i++) {
				if (student.courses.get(i).getCourseID() == courseId) {
					student.courses.remove(student.courses.get(i));
				}
			}
		} // removes the students from the list of students in that course
	}

	@Override
	public void displayCourseInfo (String courseId) {
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseID() == courseId) {
				System.out.println(course); // shows course Info
				return; //exits 
			}
		}
		System.out.println("Error: This course does not exist."); //prints if the course does not exist
	}

	@Override
	public void registerStudent (String username, String password, String firstName, String lastName) {
		Student student = new Student(username, password, firstName, lastName);
		HomeworkOne.students.add(student);
	} //register a student for a class

	@Override
	public void viewAllCourses () {
		for (Course course : HomeworkOne.courses) {
			System.out.println(course);
		}
	} //Shows all the courses

	@Override
	public void viewAllFullCourses () {
		for (Course course : HomeworkOne.courses) {
			if (course.getMaxStudents() == course.getCurStudent()) {
				System.out.println(course);
			}
		} //if the courses are all full then the course will print
	}

	@Override
	public void writeAllFullCourses () {
		String fileName = "export.csv"; //new name of file
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String text = "";

			for (Course course : HomeworkOne.courses) {
				if (course.getMaxStudents() == course.getCurStudent()) {
					text += course + "\n";
				}
			}

			bufferedWriter.write(text);

			bufferedWriter.write(".write or .append will also write to the file");
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException exk) {
			System.out.println("Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	} //copied from you for serialization purposes.

	@Override
	public void viewStudentsInCourse (String courseId) {
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseID() == courseId) {
				List<String> listOfNames = course.getListOfNames();
				for (String s : listOfNames) {
					System.out.println(s);
				}
			} // prints out the name of the students in the course.
		}
	}

	@Override
	public void viewCoursesOf (String firstName, String lastName) {
		for (Student student : HomeworkOne.students) {
			if (firstName.equals(student.firstName) && lastName == student.lastName) {
				for (Course course : student.courses) {
					System.out.println(course);
				} //will show the course that student takes
				return;
			}
		}
		System.out.println("Error: Student not found"); //if student is not found then this occurs
	}

	@Override
	public void sortByUserRegisters () {
		Collections.sort(HomeworkOne.courses); //sorts courses
		for (Course course : HomeworkOne.courses) {
			System.out.println(course); //prints all the courses
		} 
	}

	@Override
	public void exit () {
		System.exit(0);
	} // leaves admin
}