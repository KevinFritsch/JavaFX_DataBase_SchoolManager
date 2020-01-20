package PackTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.Module;
import Model.Teacher;
import database.Connect;

public class TestConnectionProject3 {

	@Test
	public void testTeacher() throws Exception {
		Teacher t = new Teacher("Test", "test","test","test","test");
		
		ArrayList<Object> list = new ArrayList<Object>(Connect.getTeachers());
		assertTrue(!list.contains(t));
		int listsize = list.size();
		
		//add the teacher
		Connect.storeTeacher(t);
		list = new ArrayList<Object>(Connect.getTeachers());
		assertEquals(list.size(), listsize+1);
		
		//remove the teacher
		Connect.removeTeacher(t);
		list = new ArrayList<Object>(Connect.getTeachers());
		assertEquals(list.size(), listsize);
	}
	
	@Test
	public void testModule() throws Exception{
		Module m = new Module("MathTest");
		
		ArrayList<Object> list = new ArrayList<Object>(Connect.getModules());
		
		assertTrue(!list.contains(m));
		int listsize = list.size();
		
		//add module
		Connect.storeModule(m);
		list = new ArrayList<Object>(Connect.getModules());
		assertEquals(list.size(), listsize+1);
		
	}
	

}
