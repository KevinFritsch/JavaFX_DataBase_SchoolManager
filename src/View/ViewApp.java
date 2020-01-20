package View;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewApp {
	
	/**
	 * error message label
	 */
	private Label lbl_errorMessage;
	//Tabpane and tabs
	/**
	 * main tabpane
	 */
	private TabPane mainApp;
	/**
	 * tab for teachers edit
	 */
	private Tab tab_teachers;
	/**
	 * tab for modules edit
	 */
	private Tab tab_modules;
	/**
	 * tab for school edit
	 */
	private Tab tab_schools;
	
	//border elements
	/**
	 * hbox for top information
	 */
	private HBox hbox_top;
	/**
	 * main pane 
	 */
	private BorderPane root;
	/**
	 * hbox for the utility information
	 */
	private HBox hbox_utility;
	/**
	 * Quit button
	 */
	private Button btn_quit;
	
	//main vbox right
	/**
	 * vbox for the right information
	 */
	private VBox vbox_right_main;
	
	//school manager
	/**
	 * vbox for schools edit
	 */
	private VBox vbox_school;
	/**
	 * Texfield for the name of school
	 */
	private TextField txt_nameschool;
	
	//class manager
	/**
	 * vbox for classes edit
	 */
	private VBox vbox_right_class;
	/**
	 * textfield for the name of the class
	 */
	private TextField txt_nameclass;
	
	//student manager
	/**
	 * vbox for the students edit
	 */
	private VBox vbox_right_student;
	/**
	 * textfield for firstname student
	 */
	private TextField txt_firstnamestudent;
	/**
	 * lastname student
	 */
	private TextField txt_lastnamestudent;
	/**
	 * middle name student
	 */
	private TextField txt_middlenamestudent;
	/**
	 * phone student
	 */
	private TextField txt_phonestudent;
	/**
	 * email student
	 */
	private TextField txt_emailstudent;
	/**
	 * dob student
	 */
	private DatePicker dobStudent;
	
	//teacher manager
	/**
	 * vbox for teachers edit
	 */
	private VBox vbox_left_teacher;
	/**
	 * first name teacher
	 */
	private TextField txt_firstnameTeacher;
	/**
	 * middle name teacher
	 */
	private TextField txt_middlenameTeacher;
	/**
	 * last name teacher
	 */
	private TextField txt_lastnameTeacher;
	/**
	 * phone teacher
	 */
	private TextField txt_phoneTeacher;
	/**
	 * email teacher
	 */
	private TextField txt_emailTeacher;
	/**
	 * degree teacher
	 */
	private TextField txt_degreeTeacher;
	
	//module manager
	/**
	 * vbox modules edit
	 */
	private VBox vbox_module;
	/**
	 * name of module
	 */
	private TextField txt_nameModule;
	/**
	 * buttons for modules edit
	 */
	private HBox hbox_module_btn;
	/**
	 * button add module
	 */
	private Button btn_add_module;
	/**
	 * button to remove a module
	 */
	private Button btn_remove_module;
	
	
	//add and remove buttons right
	/**
	 * buttons right
	 */
	private HBox hbox_btn_right;
	/**
	 * add button
	 */
	private Button btn_add_right;
	/**
	 * remove button
	 */
	private Button btn_remove_right;
	/**
	 * back button
	 */
	private Button btn_back_right;
	/**
	 * open button
	 */
	private Button btn_open_right;
	
	//add and remove buttons teachers
	/**
	 * buttons for teachers edit
	 */
	private HBox hbox_btn_teachers;
	/**
	 * add teacher button
	 */
	private Button btn_add_teachers;
	/**
	 * remove teachers button
	 */
	private Button btn_remove_teachers;
		
	
	//ListViews for displaying the elements
	/**
	 * List view for the right information
	 */
	private ListView<Object> listView;
	/**
	 * list view for the teachers
	 */
	private ListView<Object> listView2;//teachers
	/**
	 * list view for the modules
	 */
	private ListView<Object> listView3;//modules
	
	//borderpanes for each listview
	/**
	 * border pane for the teachers
	 */
	private BorderPane borderpane_teachers;
	/**
	 * border pane for the modules
	 */
	private BorderPane borderpane_modules;
	/**
	 * border pane for the schools
	 */
	private BorderPane borderpane_schools;
	
	/**
	 * constructor of the view class ViewApp.
	 */
	public ViewApp(){
		Label title;
		Label title_right_school;
		Label lbl_nameschool;
		Label title_right_student;
		Label lbl_firstnamestudent;
		Label title_right_class;
		Label lbl_nameclass;
		Label lbl_lastnamestudent;
		Label title_teachers;
		Label lbl_firstnameTeacher;
		Label lbl_middlenamestudent;
		Label lbl_phonestudent;
		Label lbl_emailstudent;
		Label lbl_dobstudent;
		Label lbl_middlenameTeacher;
		Label lbl_lastnameTeacher;
		Label lbl_phoneTeacher;
		Label lbl_emailTeacher;
		Label lbl_degreeTeacher;
		Label title_module;
		Label lbl_nameModule;
		
		
		
		
		this.lbl_errorMessage = new Label();
		lbl_errorMessage.setId("LabelWhite");
		//Initialization of elements
		this.mainApp = new TabPane();
		this.tab_teachers = new Tab("Teachers");
		this.tab_modules = new Tab("Modules");
		this.tab_schools = new Tab("Schools");
		this.borderpane_teachers = new BorderPane();
		title = new Label("School Manager Application");
		title.setId("titleLabel");
		this.hbox_top = new HBox();
		hbox_top.setId("Hbox");
		this.root  = new BorderPane();
		this.hbox_utility = new HBox();
		hbox_utility.setId("Hbox");
		this.btn_quit = new Button("Exit");
		btn_quit.setId("buttonUtility");
		this.listView = new ListView<Object>();
		this.hbox_btn_right = new HBox();
		this.btn_add_right = new Button("Add");
		this.btn_remove_right = new Button("Remove");
		this.btn_open_right = new Button("Open/Manage");
		this.btn_back_right = new Button("Back");
		this.listView2 = new ListView<Object>();
		this.vbox_left_teacher = new VBox();
		lbl_degreeTeacher = new Label("Degree:");
		this.txt_degreeTeacher = new TextField();
		this.hbox_btn_teachers = new HBox();
		this.btn_add_teachers = new Button("Add");
		this.btn_remove_teachers = new Button("Remove");
		this.btn_add_module = new Button("Add");
		this.btn_remove_module = new Button("Remove");
		this.hbox_module_btn = new HBox();
		this.listView3 = new ListView<Object>();
		this.borderpane_modules = new BorderPane();
		this.borderpane_schools = new BorderPane();
		this.vbox_right_main = new VBox();
		this.vbox_school = new VBox();
		title_right_school = new Label("Add School");
		lbl_nameschool = new Label("Name of the school:");
		this.txt_nameschool = new TextField();
		title_teachers = new Label("Add Teacher");
		lbl_firstnameTeacher = new Label("First name:");
		this.txt_firstnameTeacher = new TextField();
		lbl_middlenameTeacher = new Label("Middle name:");
		this.txt_middlenameTeacher = new TextField();
		lbl_lastnameTeacher = new Label("Last name:");
		this.txt_lastnameTeacher = new TextField();
		lbl_phoneTeacher = new Label("Phone number:");
		this.txt_phoneTeacher = new TextField();
		lbl_emailTeacher = new Label("Email:");
		this.txt_emailTeacher = new TextField();
		this.vbox_right_class = new VBox();
		title_right_class = new Label("Add Class");
		lbl_nameclass = new Label("Name of the class:");
		this.txt_nameclass = new TextField();
		this.vbox_right_student = new VBox();
		title_right_student = new Label("Add Student");
		lbl_firstnamestudent = new Label("First name:");
		this.txt_firstnamestudent = new TextField();
		lbl_lastnamestudent = new Label("Last name:");
		this.txt_lastnamestudent = new TextField();
		lbl_middlenamestudent = new Label("Middle name:");
		this.txt_middlenamestudent = new TextField();
		lbl_phonestudent = new Label("Phone number:");
		this.txt_phonestudent = new TextField();
		lbl_emailstudent = new Label("Email:");
		this.txt_emailstudent = new TextField();
		lbl_dobstudent = new Label("Dob (dd/mm/yyyy):");
		this.dobStudent = new DatePicker();
		this.vbox_module= new VBox();
		title_module= new Label("Add Module");
		lbl_nameModule= new Label("Name:");
		this.txt_nameModule= new TextField();
		
		//teachers
		hbox_btn_teachers.getChildren().addAll(btn_add_teachers,btn_remove_teachers);
		hbox_btn_teachers.setPadding(new Insets(20,0,20,0));
		hbox_btn_teachers.setSpacing(3);
		title_teachers.setPadding(new Insets(0,0,20,0));
		vbox_school.getChildren().addAll(title_right_school,lbl_nameschool,txt_nameschool);
		vbox_left_teacher.getChildren().addAll(title_teachers,
				lbl_firstnameTeacher,txt_firstnameTeacher,lbl_middlenameTeacher,txt_middlenameTeacher,lbl_lastnameTeacher,
				txt_lastnameTeacher,lbl_phoneTeacher,txt_phoneTeacher,lbl_emailTeacher,txt_emailTeacher,lbl_degreeTeacher,txt_degreeTeacher, hbox_btn_teachers);
		vbox_left_teacher.setPadding(new Insets(10,30,30,30));

		
		//right
		hbox_btn_right.getChildren().addAll(btn_add_right,btn_remove_right,btn_open_right,btn_back_right);
		hbox_btn_right.setPadding(new Insets(20,0,20,0));
		hbox_btn_right.setSpacing(3);
		title_right_school.setPadding(new Insets(0,0,20,0));
		vbox_right_main.getChildren().addAll(vbox_school,hbox_btn_right);
		vbox_right_class.getChildren().addAll(title_right_class,lbl_nameclass,txt_nameclass);
		vbox_right_student.getChildren().addAll(title_right_student,lbl_firstnamestudent,txt_firstnamestudent,lbl_middlenamestudent,
				txt_middlenamestudent,lbl_lastnamestudent,txt_lastnamestudent,lbl_dobstudent,dobStudent,lbl_phonestudent,txt_phonestudent,
				lbl_emailstudent,txt_emailstudent);
		
		//modules
		title_module.setPadding(new Insets(0,0,20,0));
		hbox_module_btn.getChildren().addAll(btn_add_module, btn_remove_module);
		hbox_module_btn.setPadding(new Insets(20,0,20,0));
		hbox_module_btn.setSpacing(3);
		vbox_module.getChildren().addAll(title_module,lbl_nameModule,txt_nameModule,hbox_module_btn);
		vbox_module.setPadding(new Insets(30,30,30,30));
		
		
		//general
		hbox_utility.getChildren().addAll(btn_quit,lbl_errorMessage);
		hbox_utility.setSpacing(10);
		hbox_utility.setPadding(new Insets(20,0,10,0));
		hbox_top.getChildren().add(title);
		hbox_top.setAlignment(Pos.CENTER);
		hbox_top.setPadding(new Insets(20,0,20,0));
		root.setTop(hbox_top);
		hbox_utility.setAlignment(Pos.CENTER);
        root.setBottom(hbox_utility);
        root.setRight(vbox_right_main);
        vbox_right_main.setPadding(new Insets(30,30,30,30));
		BorderPane.setMargin(vbox_left_teacher, new Insets(20,10,10,0));

		///listviews
		borderpane_teachers.setCenter(listView2);
		borderpane_teachers.setRight(vbox_left_teacher);
		borderpane_schools.setCenter(listView);
		borderpane_schools.setRight(vbox_right_main);
		borderpane_modules.setCenter(listView3);
		borderpane_modules.setRight(vbox_module);

		//set tab content and to tab
		tab_teachers.setContent(borderpane_teachers);

		tab_modules.setContent(borderpane_modules);
		tab_schools.setContent(borderpane_schools);
		mainApp.getTabs().addAll(tab_teachers,tab_modules,tab_schools);
		mainApp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);


		//root
        root.setPadding(new Insets(10,10,10,10));
        root.setCenter(mainApp);

	}
	
	/**
	 * getter function that returns the BorderPane that contains all the view elements.
	 * @return the BorderPane that contains all the view element.
	 */
	public BorderPane getRoot() {
		return root;
	}

	/**
	 * getter button exit
	 * @return Button exit
	 */
	public Button getBtn_quit() {
		return btn_quit;
	}

	/**
	 * getter textfield name school
	 * @return textfield name school
	 */
	public TextField getTxt_nameschool() {
		return txt_nameschool;
	}

	/**
	 * getter button add right
	 * @return Button add right
	 */
	public Button getbtn_add_right() {
		return btn_add_right;
	}
	/**
	 * getter button remove right
	 * @return Button remove right
	 */
	public Button getbtn_remove_right() {
		return btn_remove_right;
	}

	/**
	 * getter button open right
	 * @return Button open right
	 */
	public Button getbtn_open_right() {
		return btn_open_right;
	}

	/**
	 * function that updates the listview
	 * @param list List view updated
	 */
	public void updateListView(List<Object> list){
		this.listView.getItems().clear();
		this.listView.getItems().addAll(list);
		this.listView.getSelectionModel().select(0);
		this.getTxt_nameschool().clear();
		this.getTxt_nameclass().clear();
		this.getTxt_firstnamestudent().clear();
		this.getTxt_middlenamestudent().clear();
		this.getTxt_lastnamestudent().clear();
		this.getTxt_emailstudent().clear();
		this.getTxt_phonestudent().clear();
		this.getDobStudent().getEditor().clear();

	}
	/**
	 * function that updates the listview
	 * @param list List view updated
	 */
	public void updateListView2(List<Object> list){
		this.listView2.getItems().clear();
		this.listView2.getItems().addAll(list);
		this.listView2.getSelectionModel().select(0);
		this.getTxt_firstnameTeacher().clear();
		this.getTxt_middlenameTeacher().clear();
		this.getTxt_lastnameTeacher().clear();
		this.getTxt_phoneTeacher().clear();
		this.getTxt_emailTeacher().clear();
		this.getTxt_degreeTeacher().clear();
		

	}
	/**
	 * function that updates the listview
	 * @param list List view updated
	 */
	public void updateListView3(List<Object> list){
		this.listView3.getItems().clear();
		this.listView3.getItems().addAll(list);
		this.listView3.getSelectionModel().select(0);
		this.getTxt_nameModule().clear();
	}
	/**
	 * getter listview
	 * @return ListView 
	 */
	public ListView<Object> getListView() {
		return listView;
	}

	
	/**
	 * getter vbox right main
	 * @return Vbox right main
	 */
	public VBox getVbox_right_main() {
		return vbox_right_main;
	}
	/**
	 * getter vbox school
	 * @return VBox school
	 */
	public VBox getvbox_school() {
		return vbox_school;
	}

	/**
	 * getter vbox right classes
	 * @return VBox right classes
	 */
	public VBox getVbox_right_class() {
		return vbox_right_class;
	}

	/**
	 * getter button back right
	 * @return Button back right
	 */
	public Button getbtn_back_right() {
		return btn_back_right;
	}
	/**
	 * getter hbox buttons right
	 * @return HBox buttons right
	 */
	public HBox getHbox_btn_right() {
		return hbox_btn_right;
	}

	/**
	 * getter textfield name class
	 * @return TextField name class
	 */
	public TextField getTxt_nameclass() {
		return txt_nameclass;
	}
	/**
	 * getter hbox top
	 * @return HBox top
	 */
	public HBox getHbox_top() {
		return hbox_top;
	}

	/**
	 * getter hbox utility
	 * @return HBox utility
	 */
	public HBox getHbox_utility() {
		return hbox_utility;
	}

	/**
	 * getter vbox student
	 * @return VBox student
	 */
	public VBox getVbox_right_student() {
		return vbox_right_student;
	}
	/**
	 * getter textfield firstname student
	 * @return TextField firstname student
	 */
	public TextField getTxt_firstnamestudent() {
		return txt_firstnamestudent;
	}

	/**
	 * Getter lastname student
	 * @return Lastname student
	 */
	public TextField getTxt_lastnamestudent() {
		return txt_lastnamestudent;
	}
	
	/**
	 * getter middle name student
	 * @return middle name student
	 */
	public TextField getTxt_middlenamestudent() {
		return txt_middlenamestudent;
	}

	/**
	 * getter phone number student
	 * @return phone student
	 */
	public TextField getTxt_phonestudent() {
		return txt_phonestudent;
	}

	/**
	 * getter email student
	 * @return email student
	 */
	public TextField getTxt_emailstudent() {
		return txt_emailstudent;
	}

	/**
	 * getter dob student
	 * @return dob student
	 */
	public DatePicker getDobStudent(){
		return dobStudent;
	}

	/**
	 * getter vbox left teacher
	 * @return vbox left teacher
	 */
	public VBox getVbox_left_teacher() {
		return vbox_left_teacher;
	}

	/**
	 * getter firstname teacher
	 * @return
	 */
	public TextField getTxt_firstnameTeacher() {
		return txt_firstnameTeacher;
	}


	/**
	 * getter middle name teacher
	 * @return middle name teacher
	 */
	public TextField getTxt_middlenameTeacher() {
		return txt_middlenameTeacher;
	}

	/**
	 * getter lastname teacher
	 * @return lastname teacher
	 */
	public TextField getTxt_lastnameTeacher() {
		return txt_lastnameTeacher;
	}

	/**
	 * getter phone teacher
	 * @return phone teacher
	 */
	public TextField getTxt_phoneTeacher() {
		return txt_phoneTeacher;
	}

	/**
	 * getter email teacher
	 * @return email teacher
	 */
	public TextField getTxt_emailTeacher() {
		return txt_emailTeacher;
	}

	/**
	 * getter hox buttons teacher
	 * @return HBOx button teachers
	 */
	public HBox gethbox_btn_teachers() {
		return hbox_btn_teachers;
	}

	
	/**
	 * getter button dd teacher
	 * @return Button add teacher
	 */
	public Button getbtn_add_teachers() {
		return btn_add_teachers;
	}

	/**
	 * getter button remove teacher
	 * @return button remove teacher
	 */
	public Button getbtn_remove_teachers() {
		return btn_remove_teachers;
	}


	/**
	 * getter textfield gedree teacher
	 * @return Degree teacher
	 */
	public TextField getTxt_degreeTeacher() {
		return txt_degreeTeacher;
	}

	/**
	 * getter listview 2
	 * @return ListView
	 */
	public ListView<Object> getListView2() {
		return listView2;
	}

	/**
	 * getter vbox module
	 * @return VBox modules
	 */
	public VBox getVbox_module() {
		return vbox_module;
	}


	/**
	 * getter name module
	 * @return Name module
	 */
	public TextField getTxt_nameModule() {
		return txt_nameModule;
	}
	/**
	 * getter button add module
	 * @return
	 */
	public Button getBtn_add_right() {
		return btn_add_right;
	}

	/**
	 * getter button remove right
	 * @return Button remove right
	 */
	public Button getBtn_remove_right() {
		return btn_remove_right;
	}

	/**
	 * getter listview3
	 * @return listview 3
	 */
	public ListView<Object> getListView3() {
		return listView3;
	}

	
	/**
	 * getter button add module
	 * @return Button add module
	 */
	public Button getBtn_add_module() {
		return btn_add_module;
	}
	
	/**
	 * getter button remove module
	 * @return Button remove module
	 */
	public Button getBtn_remove_module() {
		return btn_remove_module;
	}
	/**
	 * getter label errormessage
	 * @return Label error message
	 */
	public Label getLbl_errorMessage() {
		return lbl_errorMessage;
	}



	
}
