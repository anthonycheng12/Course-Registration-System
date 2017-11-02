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
	}

	@Override
	public void createCourse (String courseName, int courseID, int maxStudents, int curStudent,
	                          List<String> listOfNames, String courseInstructor, int sectionNumber,
	                          String courseLocation) {
		HomeworkOne.courses.add(new Course(courseName, courseID, maxStudents, curStudent,
				listOfNames, courseInstructor, sectionNumber, courseLocation));
	}

	@Override
	public void deleteCourse (int courseId) {
		for (int i = 0; i < HomeworkOne.courses.size(); i++) {
			if (HomeworkOne.courses.get(i).getCourseID() == courseId) {
				HomeworkOne.courses.remove(HomeworkOne.courses.get(i));
			}
		}

		for (Student student : HomeworkOne.students) {
			for (int i = 0; i < student.courses.size(); i++) {
				if (student.courses.get(i).getCourseID() == courseId) {
					student.courses.remove(student.courses.get(i));
				}
			}
		}
	}

	@Override
	public void displayCourseInfo (int courseId) {
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseID() == courseId) {
				System.out.println(course);
				return;
			}
		}
		System.out.println("Error: This course does not exist.");
	}

	@Override
	public void registerStudent (String username, String password, String firstName, String lastName) {
		Student student = new Student(username, password, firstName, lastName);
		HomeworkOne.students.add(student);
	}

	@Override
	public void viewAllCourses () {
		for (Course course : HomeworkOne.courses) {
			System.out.println(course);
		}
	}

	@Override
	public void viewAllFullCourses () {
		for (Course course : HomeworkOne.courses) {
			if (course.getMaxStudents() == course.getCurStudent()) {
				System.out.println(course);
			}
		}
	}

	@Override
	public void writeAllFullCourses () {
		String fileName = "export.csv";
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
	}

	@Override
	public void viewStudentsInCourse (int courseId) {
		for (Course course : HomeworkOne.courses) {
			if (course.getCourseID() == courseId) {
				List<String> listOfNames = course.getListOfNames();
				for (String s : listOfNames) {
					System.out.println(s);
				}
			}
		}
	}

	@Override
	public void viewCoursesOf (String firstName, String lastName) {
		for (Student student : HomeworkOne.students) {
			if (firstName.equals(student.firstName) && lastName == student.lastName) {
				for (Course course : student.courses) {
					System.out.println(course);
				}
				return;
			}
		}
		System.out.println("Error: Student not found");
	}

	@Override
	public void sortByUserRegisters () {
		Collections.sort(HomeworkOne.courses);
		for (Course course : HomeworkOne.courses) {
			System.out.println(course);
		}
	}

	@Override
	public void exit () {
		System.exit(0);
	}
}