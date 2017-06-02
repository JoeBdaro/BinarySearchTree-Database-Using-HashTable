import java.util.LinkedList;
import java.util.Scanner;

public class hashTable {
	
	//creates two arrays of type linked lists of type faculty and student
	static LinkedList<Student>[] hashStudentArray = new LinkedList[999];
	static LinkedList<Faculty>[] hashFacultyArray = new LinkedList[999];
	private static int idNumInt;
	private static int hashValue;
	private static int indexOfArray;
	
	//when hasthable is initialized then the above arrays are all prepopulated with null entries
	public hashTable(){
		
		for(int i = 0; i < hashStudentArray.length; i++){
			hashStudentArray [i] = null;
		}

		for(int i = 0; i < hashFacultyArray.length; i++){
			hashFacultyArray [i] = null;
		}

	}
	
	//hash function pretty much takes an ID of a student or faculty then decided it's index in the array and returns said index value
	private static int hashFunction(String idNumString){
		idNumInt = Integer.parseInt(idNumString);
		hashValue = (idNumInt % 1000) - 1;
		return hashValue;

	}
	
	//takes a student object then finds the array index it will stored in by getting the studen't ID and passing it through the hash function then checks if said linked list in said index if so it will create a new lnked list and add the student object that was passed to the function
	public static void addStudent(Student stu){
		indexOfArray = hashFunction(stu.getStudentID());
		LinkedList<Student> studentList = hashStudentArray[indexOfArray];
		if(studentList == null){
			studentList = new LinkedList<Student>();
			studentList.add(stu);
			hashStudentArray[indexOfArray] = studentList;		

		}
		
		// if there was already a linked list with nodes in the specified index of the array then it just creates a new node for the student object
		else{
			studentList.add(stu);		

		}
	}
	
	//same concept as addStudent method
	public static void addFaculty(Faculty employee){
		indexOfArray = hashFunction(employee.getFacultyID());
		LinkedList<Faculty> facultyList = hashFacultyArray[indexOfArray];
		if(facultyList == null){
			facultyList = new LinkedList<Faculty>();
			facultyList.add(employee);
			hashFacultyArray[indexOfArray] = facultyList;		

		}

		else{
			facultyList.add(employee);		

		}
	}
	
	//finds a specific student by taking an id number entered by user and runs it through the hash function then finds if that index is = null, if so it will return a message saying nothing was found
	public static void getStudent(String IdNumber){
		indexOfArray = hashFunction(IdNumber);
		if(hashStudentArray [indexOfArray] == null){
			System.out.println("There are no entries with the ID you are looking for, please try again");
		}
		
		//if the index != null then the linked list at the array index will be traversed until we find a student object that has the same ID if so we will return a message saying so, if not we will also return a message saying so
		else{
			for(Student studentObject: hashStudentArray[indexOfArray]){
				if(IdNumber.equals(studentObject.getStudentID())){
					System.out.println("We have found the folowing student");
					System.out.println(studentObject.toString());
					return;
				}
				
				else{
					System.out.println("There are no student entries with the ID you are looking for, please try again");
				}
			}
		}
	}
	
	//same method as getStudent method just repurposed for faculty
	public static void getFaculty(String IdNumber){
		indexOfArray = hashFunction(IdNumber);
		if(hashFacultyArray [indexOfArray] == null){
			System.out.println("There are no faculty entries with the ID you are looking for, please try again");
		}

		else{
			for(Faculty facultyObject: hashFacultyArray[indexOfArray]){
				if(IdNumber.equals(facultyObject.getFacultyID())){
					System.out.println("We have found the folowing faculty memeber");
					System.out.println(facultyObject.toString());
					return;
				}

				else{
					System.out.println("There are no faculty entries with the ID you are looking for, please try again");
				}
			}
		}
	}
	
	//an exact derivative of the addFaculty method that instead deletes rather than adds
	public static void deleteFaculty(String IdNumber){
		indexOfArray = hashFunction(IdNumber);
		LinkedList<Faculty> facultyList = hashFacultyArray[indexOfArray];
		if(facultyList == null){
			System.out.println("Sorry but there was no employees were found, please try again");
		}

		else{
			for(Faculty facultyObject: facultyList){
				if(facultyObject.getFacultyID().equals(IdNumber)){
					while(true){
					
						//asks the user if he would like the faculty member that was found in the linkedlist of the respective index in the array
						System.out.println("We have found the following employee, enter \"Delete\" to delete the faculty memeber or \"Back\" to return to previous menu");
						System.out.println(facultyObject.toString());

						Scanner keyboard = new Scanner(System.in);
						String choice = keyboard.nextLine();

						// Removes all whitespaces, spaces, tabs, etc from string
						choice = choice.trim().replaceAll("\\s+", "");

						// Transforms the string to all UPPERCASE letters
						choice = choice.toUpperCase();

						//just in case the user does not want to delete he can return to previous menu
						if(choice.equals("BACK")){
							System.out.println("Returning you to previous menu");
							return;
						}
						
						//removes the object from the linked list and returns to add/delete/find menu
						else if(choice.equals("DELETE")){
							facultyList.remove(facultyObject);
							System.out.println("The faculty Member has been removed");
							return;
						}
						//fail safe 
						else{
							System.out.println("The selection you have enterd is invalid, please try again");
						}
					}
				}
			}

		}
	}

	//Same as deleteFaculty method just repurposed for students class 
	public void deleteStudent(String IdNumber){
		indexOfArray = hashFunction(IdNumber);
		LinkedList<Student> studentList = hashStudentArray[indexOfArray];
		if(studentList == null){
			System.out.println("Sorry but no students were found, please try again");
		}

		else{
			for(Student studentObject: studentList){
				if(studentObject.getStudentID().equals(IdNumber)){
					while(true){
						System.out.println("We have found the following Student, enter \"Delete\" to delete the student or \"Back\" to return to previous menu");
						System.out.println(studentObject.toString());

						Scanner keyboard = new Scanner(System.in);
						String choice = keyboard.nextLine();

						// Removes all whitespaces, spaces, tabs, etc from string
						choice = choice.trim().replaceAll("\\s+", "");

						// Transforms the string to all UPPERCASE letters
						choice = choice.toUpperCase();


						if(choice.equals("BACK")){
							System.out.println("Returning you to previous menu");
							return;
						}

						else if(choice.equals("DELETE")){
							studentList.remove(studentObject);
							System.out.println("The student has been removed");
							return;
						}

						else{
							System.out.println("The selection you have enterd is invalid, please try again");
						}
					}
				}
			}

		}
	}

}




