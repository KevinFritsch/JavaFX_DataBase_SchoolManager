package Model;


import java.util.ArrayList;

public class Student extends Person {
	
	
	/**
	 * Date of birth of the student
	 */
	private String dob;
	/**
	 * List of modules of the student
	 */
	private ArrayList<Object> modules ;
	/**
	 * Constructor of the class student
	 * @param firstName First name of the student
	 * @param middleName Middle name of the student
	 * @param lastName Last name of the student
	 * @param email email of the student
	 * @param phone phone number of the student
	 * @param dob Date of birth of the student
	 * @param modules Modules of the student
	 */
	public Student(String firstName, String middleName, String lastName, String email, String phone, String dob, ArrayList<Object> modules){
		super(firstName, middleName, lastName, email, phone);
		if(modules.size() > 6){
			throw new IllegalArgumentException("A maximum of 6 modules is allowed.");
		}
		if(dob == null){
			throw new IllegalArgumentException("No dob entered.");
		}
		this.dob = dob;
		this.modules = modules;
	}
	/**
	 * Constructor of the class student
	 * @param firstName First name of the student
	 * @param middleName Middle name of the student
	 * @param lastName Last name of the student
	 * @param email email of the student
	 * @param phone phone number of the student
	 * @param dob Date of birth of the student
	 */
	public Student(String firstName, String middleName, String lastName, String email, String phone, String dob){
		super(firstName, middleName, lastName, email, phone);
		if(dob == null){
			throw new IllegalArgumentException("No dob entered.");
		}
		this.dob = dob;
		this.modules = new ArrayList<Object>();
	}
	/**
	 * Constructor of the class student
	 * @param firstName First name of the student
	 * @param lastName Last name of the student
	 * @param email email of the student
	 * @param phone phone number of the student
	 * @param dob Date of birth of the student
	 * @param modules Modules of the student
	 */
	public Student(String firstName, String lastName, String email, String phone, String dob, ArrayList<Object> modules){
		super(firstName, lastName, email, phone);
		this.dob = dob;
		this.modules = modules;
	}
	/**
	 * Constructor of the class student
	 * @param firstName First name of the student
	 * @param lastName Last name of the student
	 * @param email email of the student
	 * @param phone phone number of the student
	 * @param dob Date of birth of the student
	 */
	public Student(String firstName, String lastName, String email, String phone, String dob){
		super(firstName, lastName, email, phone);
		this.dob = dob;
		this.modules = new ArrayList<Object>();
	}
	/**
	 * Function that adds a module to a student
	 * @param module The module to add
	 * @throws CloneNotSupportedException
	 */
	public void addModule(Module module) throws CloneNotSupportedException{
		if(!modules.contains(module) && modules.size() < 6){
			
			modules.add(module);
		}
		else{
			throw new IllegalArgumentException("Module already exists or too many.");
		}
	}
	/**
	 * Function that removes a module
	 * @param module The module to remove
	 */
	public void removeModule(Module module){
		if(modules.contains(module)){
			modules.remove(module);
		}
		else{
			throw new IllegalArgumentException("Module doesn't exists.");
		}
	}
	/**
	 * Function that gets the date of birth
	 * @return The date of birth
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * Function that gets the modules of the student
	 * @return ArrayList that represents the modules of a student
	 */
	public ArrayList<Object> getModules() {
		return modules;
	}
	public void setModules(ArrayList<Object> li) {
		this.modules = li;
	}
	@Override
	public String toString(){
		return super.toString() + " Dob: " + dob;
	}

	
}
