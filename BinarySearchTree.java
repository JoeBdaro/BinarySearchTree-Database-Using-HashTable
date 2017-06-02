import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BinarySearchTree {

	static boolean fileExists = false;
	static boolean running = true;

	static Set<Student> StudentSet= new TreeSet<Student>();
	static Set<Faculty> FacultySet= new TreeSet<Faculty>();

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String [] args) throws IOException{


		String choice;

		while(running == true){


			System.out.println("Please enter \"faculty\" if you would like to access faculty, \"student\" if you want to access student or \"SAVE\" to save both faculty and student lists and end program ");

			choice = keyboard.nextLine();

			// Removes all whitespaces, spaces, tabs, etc from string
			choice = choice.trim().replaceAll("\\s+", "");

			// Transforms the string to all UPPERCASE letters
			choice = choice.toUpperCase();

			// if the user enters student, studentBinaryTree is called
			if(choice.equals("STUDENT")){
				studentBinaryTree();
			}

			// if the user enters faculty, facultyBinaryTree is called
			else if(choice.equals("FACULTY")){
				facultyBinaryTree();
			}
			// if the user enters quit, program exits
			else if(choice.equals("SAVE")){
				String directory;
				String stuFileName = "\\Student.txt";
				String facFileName = "\\Faculty.txt";

				System.out.println("Please sepecify a directory where you would like to save the Student list to");
				directory = keyboard.nextLine();
				writeTo(directory, stuFileName);
				
				System.out.println("Please sepecify a directory where you would like to save the faculty list to");
				directory = keyboard.nextLine();
				writeTo(directory, facFileName);

				System.out.println("Process finished, program shutting down");
				keyboard.close();
				running = false;
				return;
			}
			//fail safe
			else{
				System.out.println("The selection you have entered is invalid please try again");
			}
		}

	}

	//studentBinary tree that has 3 methods (Delete, add, display, and save list to file)
	public static void studentBinaryTree() throws IOException{
		boolean studentIsRunning = true;	

		String firstName;
		String lastName;
		String idNum;

		//loop that runs and asks the choice of user as long as the user wants to add, delete, or display
		while(studentIsRunning == true){

			String choiceStudent;
			System.out.println("Please enter \"add\" if you would like to add a student, \"delete\" if you want to delete a student, \"display\" display the students in the tree, and \"back\" to go back to main menu");

			choiceStudent = keyboard.nextLine();

			// Removes all whitespaces, spaces, tabs, etc from string
			choiceStudent = choiceStudent.trim().replaceAll("\\s+", "");

			// Transforms the string to all UPPERCASE letters
			choiceStudent = choiceStudent.toUpperCase();

			//takes name and ID then adds it to the tree
			if(choiceStudent.equals("ADD")){
				System.out.println("Please enter the student's last name");
				lastName = keyboard.nextLine();
				System.out.println("Please enter the student's First name");
				firstName = keyboard.nextLine();
				System.out.println("Please enter the student's 8-digit id");
				idNum = keyboard.nextLine();

				//fail safe for ID inputs
				while(idNum.length() != 8){
					System.out.println("Error The ID number must be exactly 8-Digits long, Please enter an 8-digit long ID");
					idNum = keyboard.nextLine();
				}
				Student stu = new Student(firstName,lastName,idNum);

				StudentSet.add(stu);

			}

			//takes an ID and enters it then find is in the tree then asks if user wants to delete it or not
			else if(choiceStudent.equals("DELETE")){
				System.out.println("Please specify the ID number of the student you would like to delete");
				String idLookup = keyboard.nextLine();
				while(idLookup.length() != 8){
					System.out.println("Error The ID number you entered was not 8-Digits long, Please enter an 8-digit long ID");
					idLookup = keyboard.nextLine();
				}

				boolean isFound = false;
				for(Student stu : StudentSet){

					if(idLookup.equals(stu.getStudentID())){
						isFound = true;
						System.out.println("The following student member has been found, would you like to delete? if so enter \"delete\" otherwise type \"back\" \n" + stu.toString());
						choiceStudent = keyboard.nextLine().toUpperCase();

						if(choiceStudent.equals("DELETE")){
							StudentSet.remove(stu);
							System.out.println("The studnet memeber has been deleted");
							break;
						}

						else if(choiceStudent.equals("BACK")){
							System.out.println("Returning you to Student menu");
							break;
						}
					}

				}

				if(isFound == false){
					System.out.println("The ID you have entered does not exist in the student database");
				}

			}

			//Displays the whole tree
			else if(choiceStudent.equals("DISPLAY")){
				//uses enhanced for loop to iterate through the list and print out the display one by one
				for (Student stu : StudentSet){
					System.out.println(stu.toString());
				}
			}

			//backs into main menu
			else if(choiceStudent.equals("BACK")){
				System.out.println("Returning you to the main menu now");
				studentIsRunning = false;

			}

			//fail safe
			else{
				System.out.println("The selection you have entered is invalid please try again");
			}

		}

	}

	//facultyBinary tree that has 3 main parameters (Delete, add, and display)
	public static void facultyBinaryTree() throws IOException{
		boolean facultyIsRunning = true;	

		String firstName;
		String lastName;
		String idNum;

		//loop that runs and asks the choice of user as long as the user wants to add, delete, or display
		while(facultyIsRunning == true){

			String choiceFaculty;
			System.out.println("Please enter \"add\" if you would like to add a faculty Employee, \"delete\" if you want to delete a Faculty employee, \"display\" display the faculty employees in the tree, and \"back\" to go back to main menu");

			choiceFaculty = keyboard.nextLine();

			// Removes all whitespaces, spaces, tabs, etc from string
			choiceFaculty = choiceFaculty.trim().replaceAll("\\s+", "");

			// Transforms the string to all UPPERCASE letters
			choiceFaculty = choiceFaculty.toUpperCase();

			//takes name and ID then adds it to the tree
			if(choiceFaculty.equals("ADD")){
				System.out.println("Please enter the employee's last name");
				lastName = keyboard.nextLine();
				System.out.println("Please enter the employee's First name");
				firstName = keyboard.nextLine();
				System.out.println("Please enter the employee's 8-digit id");
				idNum = keyboard.nextLine();

				//fail safe for ID inputs
				while(idNum.length() != 8){
					System.out.println("Error The ID number must be exactly 8-Digits long, Please enter an 8-digit long ID");
					idNum = keyboard.nextLine();
				}
				Faculty employee = new Faculty(firstName,lastName,idNum);
				FacultySet.add(employee);

			}

			//takes an ID and enters it then find is in the tree then asks if user wants to delete it or not
			else if(choiceFaculty.equals("DELETE")){
				System.out.println("Please specify the ID number of the employee you would like to delete");
				String idLookup = keyboard.nextLine();
				while(idLookup.length() != 8){
					System.out.println("Error The ID number you entered was not 8-Digits long, Please enter an 8-digit long ID");
					idLookup = keyboard.nextLine();
				}
				boolean isFound = false;
				for(Faculty employee : FacultySet){

					if(idLookup.equals(employee.getFacultyID())){
						isFound = true;
						System.out.println("The following faculty member has been found, would you like to delete? if so enter \"delete\" otherwise type \"back\" \n" + employee.toString());
						choiceFaculty = keyboard.nextLine().toUpperCase();

						if(choiceFaculty.equals("DELETE")){
							FacultySet.remove(employee);
							System.out.println("The faculty memeber has been deleted");
							break;
						}

						else if(choiceFaculty.equals("BACK")){
							System.out.println("Returning you to faculty menu");
							break;
						}
					}

				}

				if(isFound == false){
					System.out.println("The ID you have entered does not exist in the faculty database");
				}
			}

			//Displays the whole tree
			else if(choiceFaculty.equals("DISPLAY")){
				//uses enhanced for loop to iterate through the list and print out the display one by one
				for (Faculty employee : FacultySet){
					System.out.println(employee.toString());
				}
			}

			//backs the user into the main menu uppon request
			else if(choiceFaculty.equals("BACK")){
				System.out.println("Returning you to the main menu now");
				facultyIsRunning = false;
			}

			//fail safe
			else{
				System.out.println("The selection you have entered is invalid please try again");
			}
		}
	}

	//writeTo method checks if the file it will be saving is a student file or faculty
	public static void writeTo(String directory, String fileName) throws IOException{

		//faculty write to file
		File newFile = new File(directory + fileName);
		FileWriter writer = new FileWriter(newFile, true);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter pWriter = new PrintWriter(buffer);

		if(newFile.exists() == false){
			newFile.createNewFile();
			System.out.println("The File " +fileName + " has been created in the " + directory + " directory");
		}

		else{
			System.out.println("Appending to file now");
		}
		
		if(fileName.equals("\\Faculty.txt")){
			for (Faculty employee : FacultySet){
				pWriter.println(employee.toString());
			}
		}
		
		else if(fileName.equals("\\Student.txt")){
			for (Student stu : StudentSet){
				pWriter.println(stu.toString());
			}
		}
		pWriter.close();
	}
}
