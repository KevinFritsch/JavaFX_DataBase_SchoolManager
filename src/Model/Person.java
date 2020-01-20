package Model;

public abstract class Person {
	/**
	 * The name of the person
	 */
	private Name name;
	/**
	 * The email of the person
	 */
	private String email;
	/**
	 * The phone number of a person
	 */
	private String phone;
	/**
	 * Constructor of the class Person
	 * @param firstName The first name of the person
	 * @param middleName The middle name of the person
	 * @param lastName The last name of the person
	 * @param email The email of the person
	 * @param phone The phone number of the person
	 */
	public Person(String firstName, String middleName, String lastName, String email, String phone){
		if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()){
			throw new IllegalArgumentException("One of the inputs is empty.");
		}
		Name name = new Name(firstName, middleName, lastName);
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	//no middleName
	/**
	 * Constructor of the class Person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @param email The email of the person
	 * @param phone The phone number of the person
	 */
	public Person(String firstName, String lastName, String email, String phone){
		if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()){
			throw new IllegalArgumentException("One of the inputs is empty.");
		}
		Name name = new Name(firstName, lastName);
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	/**
	 * Function that gets the first name of the class person
	 * @return The first name of the person
	 */
	public String getFirstName() {
		return name.getFirstName();
	}
	/**
	 * Function that gets the middle name of the person
	 * @return The middle name of the person
	 */
	public String getMiddleName() {
		return name.getMiddleName();
	}
	/**
	 * Function that gets the last name of the person
	 * @return The last name of the person
	 */
	public String getLastName() {
		return name.getLastName();
	}
	/**
	 * Function that gets the email of the person
	 * @return The email of the person
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Function that gets the phone number of the person
	 * @return The phone number of the person
	 */
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString(){
		return name.toString() + " | Email: " + email + " | Phone: " + phone + " | ";
	}
}
