package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Class_Group;
import Model.Module;
import Model.School;
import Model.Student;
import Model.Teacher;

public class Connect{

	/**
	 * Static function that returns the connection to the database
	 * @return COnnection of the database
	 * @throws Exception
	 */
	public static  Connection getConnection() throws Exception{
	try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/school_manager";
			String username = "root";
			String password = "kf1112214";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 * Static function that store a teacher object into the database
	 * @param t Teacher to be stored in the database
	 * @throws Exception
	 */
	public static void storeTeacher(Teacher t) throws Exception{
		Connection conn = getConnection();
		//store name of teacher
		String generatedColumns[] = { "idname" };

		
		PreparedStatement statementName = conn.prepareStatement("INSERT INTO name(firstname, middlename, lastname) "
				+ "VALUES(?,?,?)", generatedColumns);
		statementName.setString(1,t.getFirstName());
		statementName.setString(2,t.getMiddleName());
		statementName.setString(3,t.getLastName());
		statementName.executeUpdate();
		
		ResultSet rs = statementName.getGeneratedKeys();
		
		long idname = 0;
		if (rs.next()) {
			idname = rs.getLong(1);
		}		
		//store teacher
		PreparedStatement statementTeacher = conn.prepareStatement("INSERT INTO teacher(nameId, email, phone, degree) "
				+ "VALUES(?,?,?,?)");
		statementTeacher.setLong(1,idname);
		statementTeacher.setString(2,t.getEmail());
		statementTeacher.setString(3,t.getPhone());
		statementTeacher.setString(4,t.getDegree());
		statementTeacher.executeUpdate();
		
	}
	
	/**
	 * Static function that removes a teacher from the database
	 * @param t Teacher to be removed
	 * @throws Exception
	 */
	public static void removeTeacher(Teacher t) throws Exception{
		Connection conn = getConnection();

		
		PreparedStatement statementName = conn.prepareStatement("DELETE t,n FROM teacher t JOIN name n WHERE "
				+ " t.nameId = n.idname AND n.firstname = ? AND n.middlename = ? AND n.lastname = ? AND"
				+ " t.email = ? AND t.phone = ? AND t.degree = ?");
		
		statementName.setString(1,t.getFirstName());
		statementName.setString(2,t.getMiddleName());
		statementName.setString(3,t.getLastName());
		statementName.setString(4,t.getEmail());
		statementName.setString(5,t.getPhone());
		statementName.setString(6,t.getDegree());
		statementName.executeUpdate();
		

	}
	/**
	 * Static function that returns an ArrayList of all the teachers in the database
	 * @return ArrayList of the teacher
	 * @throws Exception
	 */
	public static ArrayList<Object> getTeachers() throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		Statement stmtNameId = conn.createStatement();

		ResultSet rs = stmtNameId.executeQuery("SELECT n.firstname, n.middlename, n.lastname,"
				+ " t.email, t.phone, t.degree FROM teacher t JOIN name n WHERE"
				+ " n.idname=t.nameId ");
		while(rs.next()){
			Teacher teacher = new Teacher(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			//Name nameres = null;
			res.add(teacher);
		}
		
		return res;
	}
	/**
	 * Static function that stores a module in the database
	 * @param m Module to be stored in the database
	 * @throws Exception
	 */
	public static void storeModule(Module m) throws Exception{
		Connection conn = getConnection();
		//get student id
		//Statement stmtNameId = conn.createStatement();
		//ResultSet rs = stmtNameId.executeQuery("SELECT s.idstudent FROM student s JOIN name n"

		
		PreparedStatement statementModule = conn.prepareStatement("INSERT INTO module(moduleName) "
				+ "VALUES(?)");
		statementModule.setString(1,m.getTitle());


		statementModule.executeUpdate();
		
	}
	/**
	 * Static function that removes a module from a database
	 * @param m Module to be removed
	 * @throws Exception
	 */
	public static void removeModule(Module m) throws Exception{
		Connection conn = getConnection();

		
		PreparedStatement statementModule = conn.prepareStatement("DELETE m FROM module m WHERE "
				+ " m.moduleName = ?");
		
		statementModule.setString(1,m.getTitle());
		
		statementModule.executeUpdate();
	}
	/**
	 * Static function that returns all the modules of the database
	 * @return ArrayList of all the modules
	 * @throws Exception
	 */
	public static ArrayList<Object> getModules() throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		Statement stmtNameId = conn.createStatement();

		ResultSet rs = stmtNameId.executeQuery("SELECT moduleName FROM module");
		while(rs.next()){
			Module module = new Module(rs.getString(1));
			res.add(module);
		}
		
		return res;
	}
	/**
	 * Static function that returns all the schools of the database
	 * @return ArrayList of all the schools
	 * @throws Exception
	 */
	public static ArrayList<Object> getSchools() throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT schoolName FROM school");
		while(rs.next()){
			School module = new School(rs.getString(1));
			res.add(module);
		}
		
		return res;
	}
	/**
	 * Static function that removes a school from the database
	 * @param s School to be removed
	 * @throws Exception
	 */
	public static void removeSchool(School s) throws Exception{
		Connection conn = getConnection();

		
		PreparedStatement statement = conn.prepareStatement("DELETE s,c,st FROM school s JOIN class c JOIN student st WHERE "
				+ " s.idschool = c.idSchool AND c.idclass = st.idCLass AND s.schoolName = ?");
		
		statement.setString(1,s.getName());
		
		statement.executeUpdate();
	}
	/**
	 * Static function that stores a school in the database
	 * @param s School to be stored in the database
	 * @throws Exception
	 */
	public static void storeSchool(School s) throws Exception{
		Connection conn = getConnection();
	
		
		PreparedStatement statement = conn.prepareStatement("INSERT INTO school(schoolName) "
				+ "VALUES(?)");
		statement.setString(1,s.getName());

		statement.executeUpdate();
		
	}
	/**
	 * Static function that stores a class_group in the database depending on a school
	 * @param c Class_Group to be stored in the database
	 * @param s School where the class has to be stored
	 * @throws Exception
	 */
	public static void storeClass(Class_Group c, School s) throws Exception{
		Connection conn = getConnection();
		
		//store class in db
		PreparedStatement statement = conn.prepareStatement("INSERT INTO class(className, idSchool) "
				+ "VALUES(?,?)");
		statement.setString(1,c.getName());
		statement.setInt(2,getSchoolId(s));


		statement.executeUpdate();
		
	}
	/**
	 * Static function that removes a class_group from the database
	 * @param c Class_Group to be removed from the database
	 * @param s School where the class is stored
	 * @throws Exception
	 */
	public static void removeClass(Class_Group c, School s) throws Exception{
		Connection conn = getConnection();
		
		PreparedStatement statement = conn.prepareStatement("DELETE c,s FROM class c JOIN student s WHERE "
			+ " s.idClass = c.idclass AND c.className = ? AND c.idSchool = ?");
		
		statement.setString(1,c.getName());
		statement.setInt(2,getSchoolId(s));
		
		statement.executeUpdate();
	}
	/**
	 * Static function that returns all the classes of a school
	 * @param s School that we want to get the classes
	 * @return ArrayList of classes
	 * @throws Exception
	 */
	public static ArrayList<Object> getClass(School s) throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		
		PreparedStatement statement = conn.prepareStatement("SELECT className FROM class WHERE idschool = ?");
		statement.setInt(1,getSchoolId(s));
	
		ResultSet rs2 = statement.executeQuery();
		
		while(rs2.next()){
			Class_Group class_added = new Class_Group(rs2.getString(1));
			res.add(class_added);
		}
		
		return res;
	}
	/**
	 * Static function that stores a student in the database depending on the class
	 * @param s Student to be stored
	 * @param c Class_group where the student has to be stored
	 * @throws Exception
	 */
	public static void storeStudent(Student s, Class_Group c) throws Exception{
		Connection conn = getConnection();
	
		
		//store name of student
		String generatedColumns[] = { "idname" };

		
		PreparedStatement statementName = conn.prepareStatement("INSERT INTO name(firstname, middlename, lastname) "
				+ "VALUES(?,?,?)", generatedColumns);
		statementName.setString(1,s.getFirstName());
		statementName.setString(2,s.getMiddleName());
		statementName.setString(3,s.getLastName());
		statementName.executeUpdate();
		
		ResultSet rsId = statementName.getGeneratedKeys();
		
		long idname = 0;
		if (rsId.next()) {
			idname = rsId.getLong(1);
		}		

		//store student
		PreparedStatement statementStudent = conn.prepareStatement("INSERT INTO student(nameId, email, phone, dob, idClass) "
				+ "VALUES(?,?,?,?,?)");
		statementStudent.setLong(1,idname);
		statementStudent.setString(2,s.getEmail());
		statementStudent.setString(3,s.getPhone());
		statementStudent.setString(4,s.getDob());
		statementStudent.setInt(5,getClassId(c));


		statementStudent.executeUpdate();
		
	}
	/**
	 * Static function that removes a student from a database
	 * @param s Student to be removed
	 * @param c Class_Group Class where the student is
	 * @throws Exception
	 */
	public static void removeStudent(Student s, Class_Group c) throws Exception{
		Connection conn = getConnection();
		
		PreparedStatement statement = conn.prepareStatement("DELETE s,n FROM student s JOIN name n WHERE "
				+ " s.nameId = n.idname AND n.firstname = ? AND n.middlename = ? AND n.lastname = ? AND"
				+ " s.email = ? AND s.phone = ? AND s.dob = ? AND s.idClass = ?");
		
		statement.setString(1,s.getFirstName());
		statement.setString(2,s.getMiddleName());
		statement.setString(3,s.getLastName());
		statement.setString(4,s.getEmail());
		statement.setString(5,s.getPhone());
		statement.setString(6,s.getDob());
		statement.setInt(7,getClassId(c));

		statement.executeUpdate();

		
		statement.executeUpdate();
	}
	/**
	 * Static function that returns all the students depending on a class_group
	 * @param c Class_Group where the students are
	 * @return ArrayList of all the students
	 * @throws Exception
	 */
	public static ArrayList<Object> getStudents(Class_Group c) throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		
		PreparedStatement statement = conn.prepareStatement("SELECT n.firstname, n.middlename,"
				+ " n.lastname, s.email, s.phone, s.dob FROM student s JOIN name n WHERE s.nameId = n.idname AND "
				+ "s.idClass = ?");
		statement.setInt(1,getClassId(c));
	

	
		ResultSet rs2 = statement.executeQuery();
		
		while(rs2.next()){
			Student student_added = new Student(rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),
					rs2.getString(5),rs2.getString(6));
			res.add(student_added);
		}
		
		return res;
	}
	
	/**
	 * Static function that returns all the grades depending on a student
	 * @param s Student whom we want the grades
	 * @return ArrayList of the grades
	 * @throws Exception
	 */
	public static ArrayList<Object> getGrades(Student s) throws Exception{
		ArrayList<Object> res = new ArrayList<Object>();
		Connection conn = getConnection();
		
		PreparedStatement statement = conn.prepareStatement("SELECT m.moduleName, g.grade FROM grade g JOIN module m WHERE g.idModule = m.idmodule"
				+ " AND g.idStudent = ?");
		statement.setInt(1,getStudentId(s));
	

	
		ResultSet rs2 = statement.executeQuery();
		
		while(rs2.next()){
			Module module_added = new Module(rs2.getString(1), rs2.getInt(2));
			res.add(module_added);
		}
		
		return res;
	}
	/**
	 * Static function that stores a Grade in the database depending on the module and the student
	 * @param m
	 * @param grade
	 * @param s
	 * @throws Exception
	 */
	public static void storeGrade(Module m, int grade, Student s) throws Exception{
		Connection conn = getConnection();
	
		//store grade
		PreparedStatement statementGrade = conn.prepareStatement("INSERT INTO grade(idModule, grade, idStudent) "
				+ "VALUES(?,?,?)");
		statementGrade.setInt(1,getModuleId(m));
		statementGrade.setInt(2,grade);
		statementGrade.setInt(3,getStudentId(s));
	


		statementGrade.executeUpdate();
		
	}
	/**
	 * Static Function that updates a grade to a module for a student
	 * @param grade Grade of the student
	 * @param s Student to change the grade
	 * @param m Module of the changed grade
	 * @throws Exception
	 */
	public static void updateGradeToModule(int grade, Student s, Module m) throws Exception{
		Connection conn = getConnection();
		
		//update grade
		PreparedStatement statementGrade = conn.prepareStatement("UPDATE grade SET grade = ? WHERE "
				+ " idModule = ? AND idStudent = ?");
		statementGrade.setInt(1,grade);
		statementGrade.setInt(2,getModuleId(m));
		statementGrade.setInt(3,getStudentId(s));
	


		statementGrade.executeUpdate();

	}
	/**
	 * Static Function that deletes a module from a student
	 * @param m Module to be deleted
	 * @param s Student 
	 * @throws Exception
	 */
	public static void deleteModuleFromStudent(Module m, Student s) throws Exception{
		Connection conn = getConnection();
		
		//delete grade
		PreparedStatement statementGrade = conn.prepareStatement("DELETE FROM grade WHERE idStudent = ?"
				+ " AND idModule = ?");
		statementGrade.setInt(1,getStudentId(s));
		statementGrade.setInt(2,getModuleId(m));



		statementGrade.executeUpdate();
	}
	/**
	 * Static Function that deletes all the grades from a module depending on a student
	 * @param s Student to delete the grades
	 * @throws Exception
	 */
	public static void deleteGradesFromModule(Student s) throws Exception{
		Connection conn = getConnection();
		
		
		//delete grades
		PreparedStatement statementGrade = conn.prepareStatement("DELETE FROM grade WHERE idStudent = ?");
		statementGrade.setInt(1,getStudentId(s));
	


		statementGrade.executeUpdate();

	}
	/**
	 * Static Function that gets the id of a student
	 * @param s Student 
	 * @return The id of the student
	 * @throws Exception
	 */
	private static int getStudentId(Student s) throws Exception{
		Connection conn = getConnection();
		
		//get Student id
		PreparedStatement statementGet = conn.prepareStatement("SELECT s.idstudent FROM student s JOIN name n WHERE "
				+ " s.nameId = n.idname AND n.firstname = ? AND n.middlename = ? AND n.lastname = ? AND"
				+ " s.email = ? AND s.phone = ? AND s.dob = ?");
		statementGet.setString(1,s.getFirstName());
		statementGet.setString(2,s.getMiddleName());
		statementGet.setString(3,s.getLastName());
		statementGet.setString(4,s.getEmail());
		statementGet.setString(5,s.getPhone());
		statementGet.setString(6,s.getDob());

	
		ResultSet rs = statementGet.executeQuery();
		
		int idStudent = -1;
		if(rs.next()){
			idStudent = rs.getInt(1);
		}
		
		return idStudent;
	}
	/**
	 * Static Function that gets the id of a school
	 * @param s School
	 * @return The id of a school
	 * @throws Exception
	 */
	private static int getSchoolId(School s) throws Exception{
		Connection conn = getConnection();
		
		//get school id
		PreparedStatement statementGet = conn.prepareStatement("SELECT idschool FROM school WHERE "
				+ " schoolName = ?");
		statementGet.setString(1,s.getName());

		ResultSet rs = statementGet.executeQuery();
		
		int idSchool = -1;
		if(rs.next()){
			idSchool = rs.getInt(1);
		}
		return idSchool;
	}
	/**
	 * Static Function that gets the id of a module
	 * @param m Module
	 * @return The id of a module
	 * @throws Exception
	 */
	private static int getModuleId(Module m) throws Exception{
		Connection conn = getConnection();
		
		//get module id
		PreparedStatement statement = conn.prepareStatement("SELECT idModule FROM module WHERE moduleName = ?");
		statement.setString(1,m.getTitle());
	
		ResultSet rs2 = statement.executeQuery();
		
		int idModule = -1;
		if(rs2.next()){
			idModule = rs2.getInt(1);
		}
		return idModule;
	}
	/**
	 * Static Function that gets the id of a class_group
	 * @param c Class_Group
	 * @return The id of a class_group
	 * @throws Exception
	 */
	private static int getClassId(Class_Group c) throws Exception{
		Connection conn = getConnection();
		
		//get class id
		PreparedStatement statementGet = conn.prepareStatement("SELECT idclass FROM class WHERE "
				+ " className = ?");
		statementGet.setString(1,c.getName());
	
		ResultSet rs = statementGet.executeQuery();
		
		int idClass = -1;
		if(rs.next()){
			idClass = rs.getInt(1);
		}
		return idClass;
	}
	
	

}
