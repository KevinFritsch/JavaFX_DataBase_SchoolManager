package View;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewManageModules {

	/**
	 * button to add module
	 */
	private Button btn_add_modulemanage = new Button("Add");
	/**
	 * button to remove module
	 */
    private Button btn_remove_modulemanage = new Button("Remove");
    /**
     * button to reset modules
     */
    private Button btn_reset_modulemanage = new Button("Reset");
    /**
     * list view of the modules
     */
    private ListView<Object> modules = new ListView<Object>();
    /**
     * list view of available modules
     */
    private ListView<Object> availablemodules = new ListView<Object>();
    /**
     * button exit
     */
    private Button btn_exit;
    /**
     * stage of the current window
     */
    private Stage newWindow;
    /**
     * textfield of new grade
     */
    private TextField txt_add_grade;
    /**
     * button add grade
     */
    private Button btn_add_grade;
    /**
     * label error message
     */
    private Label lbl_errorMessage;
    /**
     * Constructor of the class ViewManageModules
     * @param listModules The modules
     * @param student Student focused on
     */
	public ViewManageModules(ArrayList<Object> listModules, Student student){
		 
		lbl_errorMessage = new Label();
		lbl_errorMessage.setId("LabelWhite");
		BorderPane root = new BorderPane();
		
		VBox root2  = new VBox();
		root2.setId("Vbox");
		root2.setPadding(new Insets(40,40,40,40));
        Label lbl_title = new Label("Manage Modules");
        lbl_title.setId("titleLabel");
        HBox hbox_top = new HBox();
        hbox_top.setId("Hbox");
        hbox_top.getChildren().add(lbl_title);
        hbox_top.setAlignment(Pos.CENTER);
        hbox_top.setPadding(new Insets(20,20,50,20));

        
        HBox hbox_btn = new HBox();
        hbox_btn.getChildren().addAll(btn_add_modulemanage,btn_remove_modulemanage,btn_reset_modulemanage);
        hbox_btn.setPadding(new Insets(20,20,20,20));
        hbox_btn.setSpacing(5);
        hbox_btn.setAlignment(Pos.CENTER);
        
        HBox hbox_bottom = new HBox();
        hbox_bottom.setId("Hbox");
        hbox_bottom.setPadding(new Insets(20,0,20,0));
        btn_exit = new Button("Exit");
        hbox_bottom.getChildren().addAll(btn_exit, lbl_errorMessage);
        hbox_bottom.setSpacing(10);
        hbox_bottom.setAlignment(Pos.CENTER);
        
        Label lbl_availablemodules = new Label("Available modules:");
        
        Label lbl_modules = new Label("Student's modules:");
        
        HBox hbox_add = new HBox();
        btn_add_grade = new Button("Add grade");
        txt_add_grade = new TextField();
        txt_add_grade.setPrefWidth(60);
        hbox_add.getChildren().addAll(txt_add_grade,btn_add_grade);
        hbox_add.setSpacing(4);
        
        HBox hbox_add_grade = new HBox();
        hbox_add_grade.setSpacing(20);
        hbox_add_grade.getChildren().addAll(lbl_modules,hbox_add);
        hbox_add_grade.setPadding(new Insets(0,0,5,0));
        
        availablemodules.getItems().addAll(listModules);
        
        modules.getItems().addAll(student.getModules());
        
        root2.getChildren().addAll(lbl_availablemodules,availablemodules,hbox_btn,hbox_add_grade,modules);
      
        root.setTop(hbox_top);
        root.setCenter(root2);
        root.setBottom(hbox_bottom);
        Scene secondScene = new Scene(root, 1400, 700);
        secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // New window (Stage)
        newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.show();
	}
	/**
	 * getter add grade textfield
	 * @return textfield 
	 */
	public TextField getTxt_add_grade() {
		return txt_add_grade;
	}

	
	/**
	 * getter button add grade
	 * @return textfield
	 */
	public Button getBtn_add_grade() {
		return btn_add_grade;
	}

	/**
	 * getter button add module manage
	 * @return button add module
	 */
	public Button getBtn_add_modulemanage() {
		return btn_add_modulemanage;
	}

	
	/**
	 * getter button remove module manage
	 * @return Button remove module manage
	 */
	public Button getBtn_remove_modulemanage() {
		return btn_remove_modulemanage;
	}


	/**
	 * getter button reset module manage
	 * @return Button reset module manage
	 */
	public Button getBtn_reset_modulemanage() {
		return btn_reset_modulemanage;
	}


	/**
	 * getter modules
	 * @return list view of the modules
	 */
	public ListView<Object> getModules() {
		return modules;
	}


	/**
	 * getter available modules
	 * @return List view modules
	 */
	public ListView<Object> getAvailablemodules() {
		return availablemodules;
	}

	/**
	 * getter button exit
	 * @return exit button
	 */
	public Button getBtn_exit() {
		return btn_exit;
	}

	/**
	 * getter stage of current window
	 * @return current window
	 */
	public Stage getNewWindow() {
		return newWindow;
	}

	/**
	 * getter label error message
	 * @return label of error message
	 */
	public Label getLbl_errorMessage() {
		return lbl_errorMessage;
	}

	/**
	 * function that update the listview
	 * @param list ListView to be updated
	 */
	public void updateListView(List<Object> list){
		this.modules.getItems().clear();
		this.modules.getItems().addAll(list);
		this.modules.getSelectionModel().select(0);

	}
	
}
