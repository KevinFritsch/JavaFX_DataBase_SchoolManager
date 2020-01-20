package Model;

import java.util.ArrayList;

public class Class_Group {
	/**
	 * List of the students
	 */
	private ArrayList<Object> listStudents;
	/**
	 * Name of a class
	 */
	private String name;
	
	/**
	 * Constructor of the class Class_Group
	 * @param name Name of the class_group
	 */
	public Class_Group(String name){
		if(name.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.listStudents = new ArrayList<Object>();
		this.name = name;
	}
	/**
	 * Constructor of the class Class_Group
	 * @param name Name of the Class_Group
	 * @param listStudents List of the students
	 */
	public Class_Group(String name, ArrayList<Object> listStudents){
		if(name.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.name = name;
		this.listStudents = listStudents;
	}
	/**
	 * Function that adds a student to the list of students
	 * @param student Student to be added
	 */
	public void addStudent(Student student){
		if(!listStudents.contains(student)){
			this.listStudents.add(student);
		}
		else{
			throw new IllegalArgumentException("Student already exists.");
		}
	}
	/**
	 * Function that removes a student from a class_group
	 * @param student Student to be removed
	 */
	public void removeStudent(Student student){
		if(listStudents.contains(student)){
			this.listStudents.remove(student);
		}
		else{
			throw new IllegalArgumentException("Student doesn't exists.");
		}
	}
	
	@Override
	public String toString(){
		return "Name: " + name;
	}
	/**
	 * Function that returns a list of all the students contained in the class_group
	 * @return ArrayList of object representing the students
	 */
	public ArrayList<Object> getListStudents() {
		return listStudents;
	}
	/**
	 * Function that sets the list of students
	 * @param listStudents ArrayList of object representing the students
	 */
	public void setListStudents(ArrayList<Object> listStudents) {
		this.listStudents = listStudents;
	}
	/**
	 * Function that gets the name of a class_group
	 * @return String that represents the name of the class_group
	 */
	public String getName() {
		return name;
	}
	
}
