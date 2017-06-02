
public class Faculty implements Comparable <Faculty> {
	private String firstName;
	private String lastName;
	private String FacultyID;

	//Constructors
	public Faculty(String firstName, String lastName, String FacultyID) {
		this.firstName = firstName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.FacultyID = FacultyID.toUpperCase();
	}

	public Faculty() {
		this.firstName = null;
		this.lastName = null;
		this.FacultyID = null;
	}

	//Accessors
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFacultyID() {
		return FacultyID;
	}

	//Mutators
	public void setFirstName(String value) {
		firstName = value;
	}

	public void setLastName(String value) {
		lastName = value;
	}

	public void setFacultyID(String value) {
		FacultyID = value;
	}
	
	public int compareTo(Faculty other) {

        //return getLastName().compareTo(other.getLastName());
		
		//if Faculty's last name is greater than the one being compared to then 1 is outputed
		if (getLastName().compareTo(other.getLastName()) > 0) {
			return 1;
		} 
		//if Faculty's last name is less than the one being compared to then -1 is outputed
		else if (getLastName().compareTo(other.getLastName()) < 0) {
			return -1;
		}
		//if both studen't last names are the same then the first names are to be compared 
		else{
			System.out.println("The last names of both Facultys match, will begin to compare the Faculty's first names");
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
				System.out.println("It Seems that both Faculty's last names and first names are completley identical");
				return 0;
			}	
		}


	}
	//returns the object
	public String toString(){
		String objectResult = 
				" Last Name: " + getLastName() + "\n" + 
						" First Name: " + getFirstName() + "\n" +
						" Faculty ID: " + getFacultyID() +"\n";
		return objectResult;
	}
	//overrides the original equals method and replaces it to be able to check if objects or certain paremeters in the object are equal
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true; 
		if(!(o instanceof Faculty)) return false;
		Faculty that = (Faculty) o;
		return this.getFacultyID() == that.getFacultyID();
	}
}





