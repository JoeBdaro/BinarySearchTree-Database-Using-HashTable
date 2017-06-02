
public class Student implements Comparable <Student> {
	private String firstName;
	private String lastName;
	private String studentID;

	//Constructors
	public Student(String firstName, String lastName, String studentID) {
		this.firstName = firstName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.studentID = studentID.toUpperCase();
	}

	public Student() {
		this.firstName = null;
		this.lastName = null;
		this.studentID = null;
	}

	//Accessors
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStudentID() {
		return studentID;
	}

	//Mutators
	public void setFirstName(String value) {
		firstName = value;
	}

	public void setLastName(String value) {
		lastName = value;
	}

	public void setStudentID(String value) {
		studentID = value;
	}

	public int compareTo(Student other) {
		//if student's last name is greater than the one being compared to then 1 is outputed
		if (getLastName().compareTo(other.getLastName()) > 0) {
			return 1;
		} 
		//if student's last name is less than the one being compared to then -1 is outputed
		else if (getLastName().compareTo(other.getLastName()) < 0) {
			return -1;
		}
		//if both studen't last names are the same then the first names are to be compared 
		else{
			System.out.println("The last names of both students match, will begin to compare the student's first names");
			//if first name of the first object is bigger then the second object, output is 1
			if (getFirstName().compareTo(other.getFirstName()) > 0){
				return 1;
			}
			//if first name of the first object is less then the second object, output is -1
			else if (getFirstName().compareTo(other.getFirstName()) < 0){
				return -1;
			}
			// both objects have the last name and first name and a 0 will be outputed 
			else{
				System.out.println("It Seems that both student's last names and first names are completley identical");
				return 0;
			}	
		}
	}

	//returns the object
	public String toString(){
		String objectResult = 
				" Last Name: " + getLastName() + "\n" + 
				" First Name: " + getFirstName() + "\n" +
				" Student ID: " + getStudentID() +"\n";
		return objectResult;
	}
	//overrides the original equals method and replaces it to be able to check if objects or certain paremeters in the object are equal
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true; 
		if(!(o instanceof Student)) return false;
		Student that = (Student) o;
		return this.getStudentID() == that.getStudentID();
	}
}



