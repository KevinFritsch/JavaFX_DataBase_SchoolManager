package Controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import Model.Class_Group;
import Model.Module;
import Model.Person;
import Model.School;
import Model.Student;
import Model.Teacher;
import View.ViewApp;
import View.ViewManageModules;
import database.Connect;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class ControllerApp {

	Comparator<Object> compName = Comparator.comparing(Student->((Person) Student).getLastName());

	/**
	 * Main view of the application
	 */
	private ViewApp view;
	/**
	 * Grades view of the application
	 */
	private ViewManageModules viewManageModules;
	/**
	 * List of schools contained in the application
	 */
	private ArrayList<Object> schools;
	/**
	 * List of the teachers contained in the application
	 */
	private ArrayList<Object> teachers;
	/**
	 * List of the modules contained in the application
	 */
	private ArrayList<Object> modules;
	/**
	 * School focused of the application
	 */
	private School selected_school = null;
	/**
	 * Class_group focused of the application
	 */
	private Class_Group selected_class = null;
	/**
	 * Student focused of the application
	 */
	private Student selected_student = null;
	/**
	 * Status of displaying information
	 */
	private String status[] = {"school","class","student","moduleManage"};
	/**
	 * Index of the status
	 */
	private int indexStatus = 0;
	
	/**
	 * Constructor of the controller class
	 * @throws Exception
	 */
	public ControllerApp() throws Exception{
		view = new ViewApp();
		schools = new ArrayList<Object>(Connect.getSchools());
		view.updateListView(schools);
		teachers = new ArrayList<Object>(Connect.getTeachers());
		view.updateListView2(teachers);
		modules = new ArrayList<Object>(Connect.getModules());
		view.updateListView3(modules);


	}
	/**
	 * Function that initializes the application
	 */
	public void initApp(){
		view.getbtn_add_right().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
    	       try {
				add();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     	
        	}
        });
		view.getTxt_nameschool().setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	     	       try {
					add();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     	
	            }
	        }
	    });
		view.getTxt_nameclass().setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	     	       try {
					add();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     	
	            }
	        }
	    });
		view.getTxt_emailstudent().setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	     	       try {
					add();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     	
	            }
	        }
	    });
		view.getbtn_remove_right().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	try {
					remove();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	            	
        	}
        });
		view.getBtn_add_module().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
    	       try {
				add_module();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     	
        	}
        });
		view.getTxt_nameModule().setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	     	       try {
					add_module();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     	
	            }
	        }
	    });
		view.getBtn_remove_module().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	try {
					remove_module();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	            	
        	}
        });
		view.getbtn_add_teachers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
    	       try {
				add_teacher();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     	
        	}
        });
		view.getTxt_degreeTeacher().setOnKeyPressed(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER))
	            {
	     	       try {
					add_teacher();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     	
	            }
	        }
	    });
		view.getbtn_remove_teachers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	try {
					remove_teacher();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	            	
        	}
        });
		view.getbtn_open_right().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	try {
					open();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
		view.getbtn_back_right().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	back();
        	}
        });
		view.getBtn_quit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	System.exit(0);
        	}
        });
		
	}
	/**
	 * Function that adds a module to a student
	 * @throws Exception
	 */
	public void add_modulemanage() throws Exception{
		selected_student.setModules(Connect.getGrades(selected_student));
		
		Object obj = viewManageModules.getAvailablemodules().getSelectionModel().getSelectedItem();
		if(obj instanceof Module){
			Module add_module = (Module)obj;
			if(!selected_student.getModules().contains(add_module)){
				
				boolean veri = false;
				for(Object m : selected_student.getModules()){
					if(m instanceof Module){
						if(((Module) m).getTitle().equals(add_module.getTitle())){
							veri = true;
							break;
						}
					}
					
				}
				if(!veri){
					selected_student.getModules().add(add_module);
					Connect.storeGrade(add_module, -1, selected_student);
					viewManageModules.updateListView(selected_student.getModules());
	    			view.updateListView(selected_class.getListStudents());

				}
				
			}
		}
	}
	/**
	 * Function that removes a module from a student
	 * @throws Exception
	 */
	public void remove_modulemanage() throws Exception{
		Object obj = viewManageModules.getModules().getSelectionModel().getSelectedItem();
		if(obj instanceof Module){
			Module remove_module = (Module)obj;
			selected_student.getModules().remove(remove_module);
			Connect.deleteModuleFromStudent(remove_module, selected_student);
			viewManageModules.updateListView(Connect.getGrades(selected_student));
			view.updateListView(selected_class.getListStudents());

		}
	}
	/**
	 * Function that resets all the modules 
	 * @throws Exception
	 */
	public void reset_modulemanage() throws Exception{
		selected_student.getModules().clear();
		Connect.deleteGradesFromModule(selected_student);
		viewManageModules.updateListView(Connect.getGrades(selected_student));
		view.updateListView(selected_class.getListStudents());
	}
	/**
	 * Function that add a module
	 * @throws Exception
	 */
	public void add_module() throws Exception{
		String module_name = view.getTxt_nameModule().getText();
		
		if(!module_name.isEmpty()){
			if(checkModule(module_name)){
				Module new_module = new Module(module_name);
				
				modules.add(new_module);
				Connect.storeModule(new_module);
				setMessage("Module added.");
				view.updateListView3(modules);
			}
		}
		else{
			setMessage("Specify a module name.");
		}
		
		
	}
	/**
	 * Function that removes a module
	 * @throws Exception
	 */
	public void remove_module() throws Exception{
		Object obj = view.getListView3().getSelectionModel().getSelectedItem();
		if(obj instanceof Module){
			Module module_selected = (Module)obj;
			modules.remove(module_selected);
			Connect.removeModule(module_selected);
			setMessage("Module removed.");
			view.updateListView3(modules);
		}	
	}
	/**
	 * Function that add a teacher
	 * @throws Exception
	 */
	public void add_teacher() throws Exception{
		String teacher_firstname = view.getTxt_firstnameTeacher().getText();
		String teacher_middlename = view.getTxt_middlenameTeacher().getText();
		String teacher_lastname = view.getTxt_lastnameTeacher().getText();
		String teacher_email = view.getTxt_emailTeacher().getText();
		String teacher_phone = view.getTxt_phoneTeacher().getText();
		String teacher_degree = view.getTxt_degreeTeacher().getText();

		if(!teacher_firstname.isEmpty() && !teacher_lastname.isEmpty() && !teacher_email.isEmpty() &&
				!teacher_phone.isEmpty() && !teacher_degree.isEmpty()){
			Teacher new_teacher = null;
			if(teacher_middlename.isEmpty()){
				new_teacher = new Teacher(teacher_firstname,teacher_lastname,teacher_email,teacher_phone,teacher_degree);
			}
			else{
				new_teacher = new Teacher(teacher_firstname,teacher_middlename,teacher_lastname,teacher_email,teacher_phone,teacher_degree);
			}
			teachers.add(new_teacher);
			Connect.storeTeacher(new_teacher);
			setMessage("Teacher added.");
			view.updateListView2(teachers);
		}
		else{
			setMessage("Fill all the inputs to add a teacher.");
		}
		
	}
	/**
	 * Function that removes a teacher
	 * @throws Exception
	 */
	public void remove_teacher() throws Exception{
		Object obj = view.getListView2().getSelectionModel().getSelectedItem();
		if(obj instanceof Teacher){
			Teacher teacher_selected = (Teacher)obj;
			teachers.remove(teacher_selected);
			Connect.removeTeacher(teacher_selected);
			setMessage("Teacher removed.");
			view.updateListView2(teachers);
		}	
		
	}
	/**
	 * Function that goes back at the displaying forms
	 */
	public void back(){
		if(indexStatus >0){
    		indexStatus--;
    		
    		if(status[indexStatus].equals("school")){
    			//change add/delete form
    			view.getVbox_right_main().getChildren().clear();
    			view.getVbox_right_main().getChildren().addAll(view.getvbox_school(), view.getHbox_btn_right());
    			view.updateListView(schools);
    		}
    		else if(status[indexStatus].equals("class")){
    			//change add/delete form
    			view.getVbox_right_main().getChildren().clear();
    			view.getVbox_right_main().getChildren().addAll(view.getVbox_right_class(), view.getHbox_btn_right());
    			view.updateListView(selected_school.getListClasses());
    		}
    	}
	}
	/**
	 * Function that opens the current status element
	 * @throws Exception
	 */
	public void open() throws Exception{
		if(indexStatus < 3){
    		indexStatus++;
    		
    		if(status[indexStatus].equals("class")){    			
    			//update the list
    			Object obj = view.getListView().getSelectionModel().getSelectedItem();
    			if(obj instanceof School){
    				selected_school = (School)obj;
    				selected_school.setListClasses(Connect.getClass(selected_school));
        			view.updateListView(selected_school.getListClasses());
        			//change add/delete form
        			view.getVbox_right_main().getChildren().clear();
        			view.getVbox_right_main().getChildren().addAll(view.getVbox_right_class(), view.getHbox_btn_right());
    			}	
    		}
    		if(status[indexStatus].equals("student")){    			
    			//update the list
    			Object obj = view.getListView().getSelectionModel().getSelectedItem();
    			
    			if(obj instanceof Class_Group){
    				selected_class = (Class_Group)obj;
    				selected_class.setListStudents(Connect.getStudents(selected_class));
    				selected_class.getListStudents().sort(compName);
        			view.updateListView(selected_class.getListStudents());
        			//change add/delete form
        			view.getVbox_right_main().getChildren().clear();
        			view.getVbox_right_main().getChildren().addAll(view.getVbox_right_student(), view.getHbox_btn_right());
    			}	
    		}
    		if(status[indexStatus].equals("moduleManage")){
    			Object obj = view.getListView().getSelectionModel().getSelectedItem();
    			if(obj instanceof Student){
    				indexStatus--;
    				selected_student = (Student)obj;
    				
    				
    				
        			
        			
        			viewManageModules = new ViewManageModules(modules, selected_student);
        			viewManageModules.updateListView(Connect.getGrades(selected_student));
        			view.updateListView(selected_class.getListStudents());
        			
        			viewManageModules.getBtn_add_modulemanage().setOnAction(new EventHandler<ActionEvent>() {
        	            @Override
        	            public void handle(ActionEvent e) {
        	            	try {
								add_modulemanage();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        	        	}
        	        });
        			viewManageModules.getBtn_remove_modulemanage().setOnAction(new EventHandler<ActionEvent>() {
        	            @Override
        	            public void handle(ActionEvent e) {
        	            	try {
								remove_modulemanage();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        	        	}
        	        });
        			viewManageModules.getBtn_reset_modulemanage().setOnAction(new EventHandler<ActionEvent>() {
        	            @Override
        	            public void handle(ActionEvent e) {
        	            	try {
								reset_modulemanage();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        	        	}
        	        });
        			viewManageModules.getBtn_exit().setOnAction(new EventHandler<ActionEvent>() {
        	            @Override
        	            public void handle(ActionEvent e) {
        	            	viewManageModules.getNewWindow().close();
        	        	}
        	        });
        			viewManageModules.getBtn_add_grade().setOnAction(new EventHandler<ActionEvent>() {
        	            @Override
        	            public void handle(ActionEvent e) {
        	            	try {
								add_grade();
							} catch (CloneNotSupportedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        	        	}
        	        });
        			
        			
    			}
    		}
    	}
	
		
	}
	/**
	 * Function that add a grade to a student
	 * @throws CloneNotSupportedException
	 */
	public void add_grade() throws CloneNotSupportedException{
		String gradeString = viewManageModules.getTxt_add_grade().getText();
		viewManageModules.getTxt_add_grade().clear();
		
		if(!gradeString.isEmpty()){
			try{
				int new_grade = Integer.parseInt(gradeString);
				if(new_grade > -1 && new_grade < 101){
					Object obj = viewManageModules.getModules().getSelectionModel().getSelectedItem();
					if(obj instanceof Module){
						Module module = (Module)obj;
						Module cloned_module = (Module) module.clone();
						cloned_module.setGrade(new_grade);
						Connect.updateGradeToModule(new_grade, selected_student, cloned_module);
						for(Object mo : selected_student.getModules()){
							if(mo instanceof Module){
								Module mog = (Module)mo;
								if(mog.getTitle().equals(cloned_module.getTitle())){
									selected_student.getModules().remove(mog);
									selected_student.getModules().add(cloned_module);
								}
							}
						}
						setMessageView2("Grade added.");

	        			viewManageModules.updateListView(Connect.getGrades(selected_student));
		    			view.updateListView(selected_class.getListStudents());
					}
				}
				else{
					setMessageView2("Enter a grade between 0 and 100.");
				}
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				setMessageView2("Enter a number to add a grade.");
			}
			
		}
		else{
			setMessageView2("Fill the input to add a grade.");
		}
	}
	/**
	 * Function that adds an object into the database
	 * @throws Exception
	 */
	public void add() throws Exception{
		if(status[indexStatus].equals("school")){
			String school_name = view.getTxt_nameschool().getText();
			if(!school_name.isEmpty()){
				//check if school doesn't already exist
				if(checkSchool(school_name)){
					School new_school = new School(school_name);
					schools.add(new_school);
					Connect.storeSchool(new_school);
					setMessage("School added.");
				}
			}
			else{
				setMessage("Fill all the inputs to add a school.");
			}
			view.updateListView(schools);			

				
		}
		else if(status[indexStatus].equals("class")){
			String class_name = view.getTxt_nameclass().getText();
			if(!class_name.isEmpty()){
				//check if school doesn't already exist
				if(checkClass(class_name)){
					Class_Group new_class = new Class_Group(class_name);
					selected_school.addClasses(new_class);
					Connect.storeClass(new_class, selected_school);
					setMessage("Class added.");

				}
				
			}
			
			else{
				setMessage("Fill all the inputs to add a class.");
			}
			view.updateListView(selected_school.getListClasses());

		}
		else if(status[indexStatus].equals("student")){
			String student_firstname = view.getTxt_firstnamestudent().getText();
			String student_middlename = view.getTxt_middlenamestudent().getText();
			String student_lastname = view.getTxt_lastnamestudent().getText();
			String student_email = view.getTxt_emailstudent().getText();
			String student_phone = view.getTxt_phonestudent().getText();
			try{
				String student_dob = view.getDobStudent().getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				if(!student_firstname.isEmpty() && !student_lastname.isEmpty() && !student_email.isEmpty() &&
						!student_phone.isEmpty() && !student_dob.isEmpty()){
				
					Student new_student;
					if(student_middlename.isEmpty()){
						new_student = new Student(student_firstname,student_lastname,student_email,student_phone,student_dob );
					}
					else{
						new_student = new Student(student_firstname,student_middlename,student_lastname,student_email,student_phone,student_dob );
		
					}
					selected_class.addStudent(new_student);
					Connect.storeStudent(new_student, selected_class);
					
					setMessage("Student added.");
		
				}
				else{
					setMessage("Fill all the inputs to add a student.");
				}
				selected_class.setListStudents(Connect.getStudents(selected_class));
				selected_class.getListStudents().sort(compName);
				view.updateListView(selected_class.getListStudents());
				

			}
			catch(Exception e){
				setMessage("Fill all the inputs to add a student.");

			}
			
			
		}
	}
	/**
	 * Function that removes an object from a database
	 * @throws Exception
	 */
	public void remove() throws Exception{
		if(status[indexStatus].equals("school")){
			Object obj = view.getListView().getSelectionModel().getSelectedItem();
			if(obj instanceof School){
				School school_selected = (School)obj;
				schools.remove(school_selected);
				Connect.removeSchool(school_selected);
				setMessage("School removed.");

				view.updateListView(schools);
			}	
		}
		else if(status[indexStatus].equals("class")){
			Object obj = view.getListView().getSelectionModel().getSelectedItem();
			if(obj instanceof Class_Group){
				Class_Group classdelete = (Class_Group)obj;
				selected_school.getListClasses().remove(classdelete);
				Connect.removeClass(classdelete, selected_school);
				setMessage("Class removed.");

    			view.updateListView(selected_school.getListClasses());
			}
		}
		else if(status[indexStatus].equals("student")){
			Object obj = view.getListView().getSelectionModel().getSelectedItem();
			if(obj instanceof Student){
				Student student_selected = (Student)obj;
				selected_class.getListStudents().remove(student_selected);
				Connect.removeStudent(student_selected, selected_class);
				setMessage("Student removed.");

    			view.updateListView(selected_class.getListStudents());
			}
		}
	}
	/**
	 * Function that checks if a modules already exists in the list
	 * @param module_name The module
	 * @return Boolean value, if the module already exists
	 */
	public boolean checkModule(String module_name){
		boolean res = true;
		for(Object s : modules){
			if(s instanceof Module){
				if(((Module)s).getTitle().equals(module_name)){
					res = false;
					break;
				}
			}
			
		}
		return res;
	}
	/**
	 * Function that checks if a class_group already exists in the list
	 * @param class_name The class_group
	 * @return Boolean value, if the class_group already exists
	 */
	public boolean checkClass(String class_name){
		boolean res = true;
		for(Object s : selected_school.getListClasses()){
			if(s instanceof Class_Group){
				if(((Class_Group)s).getName().equals(class_name)){
					res = false;
					break;
				}
			}
			
		}
		return res;
	}
	/**
	 * Function that checks if a school_name already exists in the list
	 * @param school_name The school_name
	 * @return Boolean value, if the school_name already exists
	 */
	public boolean checkSchool(String school_name){
		boolean res = true;
		for(Object s : schools){
			if(s instanceof School){
				if(((School)s).getName().equals(school_name)){
					res = false;
					break;
				}
			}
			
		}
		return res;
	}
	/**
	 * Function that gets the root which is a borderpane
	 * @return BorderPane that represents the main view
	 */
	public BorderPane getRoot(){
		return view.getRoot();
	}
	/**
	 * method that allows to set a message depending on the parameter.
	 * @param message String that represents the message to display.
	 */
	private void setMessage(String message){
		view.getLbl_errorMessage().setText(message);
		Timeline timeline = new Timeline(new KeyFrame(
		        Duration.millis(2500),
		        ae -> view.getLbl_errorMessage().setText("")));
		timeline.play();
	}
	/**
	 * method that allows to set a message depending on the parameter.
	 * @param message String that represents the message to display.
	 */
	private void setMessageView2(String message){
		viewManageModules.getLbl_errorMessage().setText(message);
		Timeline timeline = new Timeline(new KeyFrame(
		        Duration.millis(2500),
		        ae -> viewManageModules.getLbl_errorMessage().setText("")));
		timeline.play();
	}
	
	
}
