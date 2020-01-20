package PackTest;

import java.util.ArrayList;

import Model.Module;
import Model.School;
import Model.Teacher;
import database.Connect;

public class TestMemory {
	public static void main(String[] args) throws Exception{
		
		for(int i=0; i < 20000; i++){
			//add student in database
			Teacher t = new Teacher("student","student","student","student","student");
			Connect.storeTeacher(t);
			Connect.removeTeacher(t);
		}
		
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		ArrayList<Module> listModules = new ArrayList<Module>();
		ArrayList<School> listSchools = new ArrayList<School>();

		
		for(int i = 0; i < 2000000000; i++){
			Teacher t = new Teacher("student","student","student","student","student");
			list.add(t);
			School s = new School("CIT");
			listSchools.add(s);
			Module m = new Module("Test");
			listModules.add(m);
		}
		
	}

}
