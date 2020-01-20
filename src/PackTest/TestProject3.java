package PackTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Class_Group;
import Model.Module;
import Model.Name;
import Model.School;
import Model.Student;
import Model.Teacher;

public class TestProject3 {

	@Test
	public void testStudent() throws CloneNotSupportedException {
		Student stu1 = new Student("Kevin","Fritsch","kevin@fri.com","078119293839","11/07/1999");
		assertEquals(stu1.getDob(), "11/07/1999");
		assertEquals(stu1.getFirstName(), "Kevin");
		assertEquals(stu1.getLastName(), "Fritsch");
		assertEquals(stu1.getEmail(), "kevin@fri.com");
		assertEquals(stu1.getPhone(), "078119293839");
		assertEquals(stu1.getModules().size(), 0);

		//add and remove modules
		Module m1 = new Module("Math");
		Module m2 = new Module("Statistics");
		stu1.addModule(m1);
		assertEquals(stu1.getModules().size(), 1);
		assertEquals(stu1.getModules().get(0), m1);
		
		stu1.addModule(m2);
		assertEquals(stu1.getModules().size(), 2);
		assertEquals(stu1.getModules().get(1), m2);
		
		stu1.removeModule(m1);
		assertEquals(stu1.getModules().size(), 1);
		assertEquals(stu1.getModules().get(0), m2);		
			
		stu1.addModule(new Module("Math2"));
		assertEquals(stu1.getModules().size(),2);
		((Module) stu1.getModules().get(1)).setGrade(30);
		assertEquals(((Module) stu1.getModules().get(1)).getGrade(), 30);
		
	}	
	
	@Test
	public void testModule(){
		Module m1 = new Module("Math");
		Module m2 = new Module("French", 89);//   grade --> 89/100
		assertEquals(m1.getGrade(), -1);
		assertEquals(m2.getGrade(),89);
		
		m1.setGrade(100);
		assertEquals(m1.getGrade(), 100);
	
	}
	
	@Test
	public void testTeacher(){
		Teacher t1 = new Teacher("Marion", "Lepen", "marion@lepen.fr","082028802", "Master");
		assertEquals(t1.getFirstName(), "Marion");
		assertEquals(t1.getLastName(), "Lepen");
		assertEquals(t1.getEmail(),"marion@lepen.fr");
		assertEquals(t1.getPhone(),"082028802");
		assertEquals(t1.getDegree(),"Master");

	}
	@Test
	public void testSchool(){
		School s1 = new School("CIT");
		assertEquals(s1.getName(), "CIT");
		assertEquals(s1.getListClasses().size(),0);
		
		Class_Group class1 = new Class_Group("Class1");
		s1.addClasses(class1);
		
		assertEquals(s1.getListClasses().size(),1);
		assertEquals(s1.getListClasses().get(0),class1);
		
		s1.removeClasses(class1);
		assertEquals(s1.getListClasses().size(),0);

	}
	@Test
	public void testClass(){
		Class_Group c1 = new Class_Group("Class1");
		assertEquals(c1.getName(),"Class1");
		assertEquals(c1.getListStudents().size(),0);
		
		//add students in it
		Student stu1 = new Student("Kevin","Fritsch","kevin@fri.com","078119293839","11/07/1999");
		Student stu2 = new Student("test","test","kevin@test.com","038082","11/07/1999");
		
		c1.addStudent(stu1);
		c1.addStudent(stu2);
		assertEquals(c1.getListStudents().size(),2);
		assertEquals(c1.getListStudents().get(0),stu1);
		assertEquals(c1.getListStudents().get(1),stu2);
		
		c1.removeStudent(stu1);
		assertEquals(c1.getListStudents().size(),1);
		assertEquals(c1.getListStudents().get(0),stu2);
		
	}
	@Test
	public void testName(){
		Name n1 = new Name("Kevin","David","Fritsch");
		assertEquals(n1.getFirstName(),"Kevin");
		assertEquals(n1.getMiddleName(),"David");
		assertEquals(n1.getLastName(),"Fritsch");

	}

}
