package Model;

public class Name {
	/**
	 * First name of the name class
	 */
	private String firstName;
	/**
	 * Middle name of the name class
	 */
	private String middleName;
	/**
	 * Last name of the name class
	 */
	private String lastName;
	/**
	 * Constructor of the class name
	 * @param firstName The first name
	 * @param lastName The last name
	 */
	public Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = "";
	}
	/**
	 * Constructor of the class name
	 * @param firstName The first name
	 * @param middleName The middle name
	 * @param lastName The last name
	 */
	public Name(String firstName, String middleName, String lastName){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	/**
	 * Function that gets the first name of the class name
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Function that sets the first name of the class name
	 * @param firstName The fist name 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Function that gets the middle name of the class name
	 * @return The middle name
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * Function that sets the middle name of the class name
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * Function that gets the last name of the class name
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Function that sets the last name of the class name
	 * @param lastName The last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString(){
		if(middleName == ""){
			return firstName + " " + lastName;
		} 
		else{
			return firstName + " " + middleName + " " + lastName;
		}
	}
	
}

