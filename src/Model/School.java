package Model;

import java.util.ArrayList;

public class School {
	/**
	 * List of the classes contained in the school
	 */
	private ArrayList<Object> listClasses;
	/**
	 * Name of the school
	 */
	private String name;
	
	/**
	 * Constructor of the class school
	 * @param name Name of the school
	 * @param listClasses List of the classes contained in the school
	 */
	public School(String name, ArrayList<Object> listClasses){
		if(name.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.name = name;
		this.listClasses = listClasses;
	}
	/**
	 * Constructor of the class school
	 * @param name Name of the school
	 */
	public School(String name){
		if(name.isEmpty()){
			throw new IllegalArgumentException("Please specify a name.");
		}
		this.name = name;
		this.listClasses = new ArrayList<Object>();
	}
	/**
	 * Function that adds a class to the school
	 * @param classes The class to add
	 */
	public void addClasses(Class_Group classes){
		if(!listClasses.contains(classes)){
			listClasses.add(classes);
		}
		else{
			throw new IllegalArgumentException("Class already exists.");
		}
	}
	/**
	 * Function that removes a class from a school
	 * @param classes The class to remove
	 */
	public void removeClasses(Class_Group classes){
		if(listClasses.contains(classes)){
			listClasses.remove(classes);
		}
		else{
			throw new IllegalArgumentException("Class doesn't exists.");
		}
	}
	/**
	 * Function that returns a list of all the classes contained in the school
	 * @return ArrayList of the classes
	 */
	public ArrayList<Object> getListClasses() {
		return listClasses;
	}
	/**
	 * Function that sets a list of classes
	 * @param li ArrayList that represents all the classes
	 */
	public void setListClasses(ArrayList<Object> li){
		this.listClasses = li;
	}
	/**
	 * Function that gets the name of the school
	 * @return The name of the school
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString(){
		return "Name: " + name ;
	}
}
