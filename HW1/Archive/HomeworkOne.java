import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HomeworkOne {
	public static Admin admin;
	public static List<Student> students;
	public static List<Course> courses;

	public static void main (String args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you a student or an admin? (TYPE: \"student\" or \"admin\"");
		String mode = scanner.next();
		boolean run = true;

		if (mode.equalsIgnoreCase("student")) {
			readFromFile();
			do {
				// TODO
			} while (run);
		} else if (mode.equalsIgnoreCase("admin")) {
			readFromFile();
			do {

				// TODO

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

	public static void readFromFile () {
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
				courses.add(new Course(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]),
						Integer.valueOf(tokens[3]), null, tokens[5], Integer.valueOf(tokens[6]), tokens[7]));
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
