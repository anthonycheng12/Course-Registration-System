import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkOne {
	public static Admin admin;
	public static List<Student> students;
	public static List<Course> courses;
	
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you a student or an admin? (TYPE: \"student\" or \"admin\")"); //find out who is here
		String mode = scanner.next();
		boolean run = true;

		if (mode.equalsIgnoreCase("student")) { //the action
			readFromFile();
			do {
				System.out.println("Enter your username, password, firstname, lastname");
				String username = scanner.next();
				String password = scanner.next();
				String firstname = scanner.next();
				String lastname = scanner.next();
				Student student1 = new Student(username, password, firstname, lastname);
				student1.viewAllNotFullCourses();
				
				
				
			} while (run);
		} else if (mode.equalsIgnoreCase("admin")) { //action for admin
			readFromFile();
			do {
				Admin admin1 = new Admin();
				admin1.displayCourseInfo("CSCI-GA.1144");
				break;
				
				

//				@Override
//				public void editCourse (String courseName, int courseID, int maxStudents, int curStudent,
//				List<String> listOfNames, String courseInstructor, int sectionNumber,
//				String courseLocation) {
//
//				}
			} while (run);
		} else {
			throw new IllegalArgumentException("Error: invalid input.");
		}
	}


	public static void readFromFile () { //reading from the file
		String fileName = "MyUniversityCourses.csv";
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				String[] tokens = line.split(",");

				for (int i = 0; i < tokens.length; i++) {
					if (tokens[i].equalsIgnoreCase("NULL")) {
						tokens[i] = null;
					}
				}
				/*System.out.println(tokens[0]);
				System.out.println(tokens[1]);
				System.out.println(tokens[2]);
				System.out.println(tokens[3]);
				System.out.println(tokens[4]);
				System.out.println(tokens[5]);
				System.out.println(tokens[6]);
				System.out.println(tokens[7]);*/
				courses = new ArrayList<Course>();
				courses.add(new Course(tokens[0], tokens[1], Integer.valueOf(tokens[2]), 
						Integer.valueOf(tokens[3]), null, tokens[5], Integer.valueOf(tokens[6]), tokens[7]));
				System.out.println(courses);
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			ex.printStackTrace();
		}
	}
}
