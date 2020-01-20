package Model;


public class Module  implements Cloneable{
	/**
	 * Title of the module
	 */
	private String title;
	/**
	 * Grade of the module
	 */
	private int grade;
	
	/**
	 * Constructor of the class Module
	 * @param title Title of the module
	 */
	public Module(String title){
		if(title.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.title = title;
		this.grade = -1;
	}
	/**
	 * COnstructor of the class Module
	 * @param title Title of the module
	 * @param grade Grade of the module
	 */
	public Module(String title, int grade){
		if(title.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.title = title;
		this.grade = grade;
	}
	/**
	 * Function that gets the title of the module
	 * @return String that represents the title of the module
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Function that gets the grade of the module	
	 * @return Integer that represents the grade of the module
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * Function that sets the grade of a module
	 * @param grade The grade of the module
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString(){
		if(grade == -1){
			return title ;
		}
		else{
			return title + " Grade: "+grade + "/100";
		}
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
