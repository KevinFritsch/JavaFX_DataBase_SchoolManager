package Model;


public class Teacher extends Person{

	/**
	 * The degree of the teacher
	 */
	private String degree;
	/**
	 * Constructor of the class Teacher
	 * @param firstName First name of the teacher
	 * @param lastName Last name of the teacher
	 * @param email email of the teacher
	 * @param phone phone of the teacher
	 * @param degree degree of the teacher
	 */
	public Teacher(String firstName, String lastName, String email, String phone, String degree){
		super(firstName, lastName, email, phone);
		if(degree.isEmpty()){
			throw new IllegalArgumentException("No degree entered.");
		}
		this.degree = degree;
	}
	/**
	 * Constructor of the class Teacher
	 * @param firstName First name of the teacher
	 * @param middleName Middle name of the teacher
	 * @param lastName Last name of the teacher
	 * @param email email of the teacher
	 * @param phone phone of the teacher
	 * @param degree degree of the teacher
	 */
	public Teacher(String firstName, String middleName, String lastName, String email, String phone, String degree){
		super(firstName, middleName, lastName, email, phone);
		if(degree.isEmpty()){
			throw new IllegalArgumentException("No degree entered.");
		}
		this.degree = degree;
	}

	/**
	 * Function that gets the degree of the teacher
	 * @return The degree of the teacher
	 */
	public String getDegree() {
		return degree;
	}
	
	
	@Override
	public String toString(){
		return super.toString() + " " + degree;
	}
	
	
}
