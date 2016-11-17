package br.com.valmirjunior.gradbook.model;

public class Consts {
	public static final String APP="GradBook";
	
	
	/**
	 * Consts to EJBS
	 * */
	public static final String USERDAO="";
	public static final String COLABORATOR_DAO="";
	
	
	/**
	 * Consts to database;
	 * */
	public  static final String SCHEMA="gradbook";
	public static final int ALLOCATION_SIZE=1;
	public static final int MAX_SIZE_NORMAL_TEXT=30;
	public static final int MAX_SIZE_SMALL_TEXT=5;
	public static final int SIZE_CPF=11;
	/** 
	 * <p>Contants to table Collaborators;</p>
	 */
	public  static final String SEQUENCE_COLLABORATOR="CollaboratorSequence";
	public  static final String SEQUENCE_NAME_COLLABORATOR="SQ_ID_COLLABORATOR";
	public  static final String UNIQUE_CONSTRAINT_COLLABORATOR="UNIQUE_COLUMNS_COLLABORATOR";	
	public  static final String TABLE_COLLABORATOR="Collaborators";
	public  static final String COLUMN_ID_COLLABORATOR="ID_Collaborator";
	public  static final String COLUMN_NAME_COLLABORATOR="Name_Collaborator";
	public  static final String COLUMN_CPF_COLLABORATOR="CPF_Collaborator";
	public  static final String COLLABORATOR="collaborator";
	
	/** 
	 * <p>Contants to table Tasks;</p>
	 */
	public  static final String SEQUENCE_TASK="TaskSequence";
	public  static final String SEQUENCE_NAME_TASK="SQ_ID_TASK";
	public  static final String UNIQUE_CONSTRAINT_TASK="UNIQUE_COLUMNS_TASK";	
	public  static final String TABLE_TASK="Tasks";
	public  static final String COLUMN_ID_TASK="ID_Task";
	public  static final String COLUMN_DATE_STARTER_TASK="Date_Starter_Task";
	public  static final String COLUMN_DATE_END_TASK="Date_End_Task";
	public  static final String COLUMN_DISCIPLINE_TASK="Discipline_ID_Task";
	public  static final String COLUMN_FUNCTION_TASK="Function_ID_Task";
	public  static final String COLUMN_COLLABORATOR_TASK="Collaborator_ID_Task";
	public  static final String FK_ID_DISCIPLINE_TASK="FK_ID_DISCIPLINE";
	public  static final String FK_ID_FUNCTION_TASK="FK_ID_FUNCTION";
	public  static final String FK_ID_COLLABORATOR_TASK="FK_ID_COLLABORATOR";
	
	public  static final String TASK="task";
	
	/** 
	 * <p>Contants to table course;</p>
	 */
	public  static final String SEQUENCE_COURSE="CourseSequence";
	public  static final String SEQUENCE_NAME_COURSE="SQ_ID_COURSE";
	public  static final String UNIQUE_CONSTRAINT_COURSE="UNIQUE_COLUMNS_COURSE";	
	public  static final String TABLE_COURSE="Courses";
	public  static final String COLUMN_ID_COURSE="ID_Course";
	public  static final String COLUMN_NAME_COURSE="Name_Course";
	public  static final String COLUMN_ABREVIATION_COURSE="Abreviation_Course";
	public  static final String COURSE="course";
	/** 
	 * <p>Contants to table semesters;</p>
	 */
	public  static final String SEQUENCE_SEMESTER="SemesterSequence";
	public  static final String SEQUENCE_NAME_SEMESTER="SQ_ID_SEMESTER";
	public  static final String TABLE_SEMESTER="semesters";
	public  static final String COLUMN_ID_SEMESTER="ID_Semester";
	public  static final String COLUMN_NAME_SEMESTER="Name_Semester";
	public  static final String COLUMN_COURSE_SEMESTER="Course_ID_Semester";
	public  static final String FK_ID_COURSE_SEMESTER="FK_ID_COURSE";
	public  static final String SEMESTER="semester";
	
	/** 
	 * <p>Contants to table Poles;</p>
	 */
	public  static final String SEQUENCE_POLE="PoleSequence";
	public  static final String SEQUENCE_NAME_POLE="SQ_ID_POLE";
	public  static final String UNIQUE_CONSTRAINT_POLE="UNIQUE_COLUMNS_POLE";	
	public  static final String TABLE_POLE="poles";
	public  static final String COLUMN_ID_POLE="ID_Pole";
	public  static final String COLUMN_NAME_POLE="Name_Pole";
	public  static final String POLE="pole";
	
	/** 
	 * <p>Contants to table Functions;</p>
	 */
	public  static final String SEQUENCE_FUNCTION="FunctionSequence";
	public  static final String SEQUENCE_NAME_FUNCTION="SQ_ID_FUNCTION";
	public  static final String UNIQUE_CONSTRAINT_FUNCTION="UNIQUE_COLUMNS_FUNCTION";	
	public  static final String TABLE_FUNCTION="functions";
	public  static final String COLUMN_ID_FUNCTION="ID_Function";
	public  static final String COLUMN_NAME_FUNCTION="Name_Function";
	public  static final String FUNCTION="function";
	/** 
	 * <p>Contants to table disciplines;</p>
	 */
	public static final int MAX_VALUE_WORK_LOAD=100;
	public static final int MIN_VALUE_WORK_LOAD=20;
	public  static final String SEQUENCE_DISCIPLINE="DisciplineSequence";
	public  static final String SEQUENCE_NAME_DISCIPLINE="SQ_ID_DISCIPLINE";
	public  static final String UNIQUE_CONSTRAINT_DISCIPLINE="UNIQUE_COLUMNS_DISCIPLINE";	
	public  static final String TABLE_DISCIPLINE="Disciplines";
	public  static final String COLUMN_ID_DISCIPLINE="ID_Discipline";
	public  static final String COLUMN_NAME_DISCIPLINE="Name_Discipline";
	public  static final String COLUMN_WORK_LOAD_DISCIPLINE="Work_Load_Discipline";
	public  static final String COLUMN_SEMESTER_DISCIPLINE="Semester_ID_Discipline";
	public  static final String FK_ID_SEMESTER_DISCIPLINE="FK_ID_SEMESTER";
	public  static final String DISCIPLINE="discipline";
	
	/** 
	 * <p>Contants to table Teams;</p>
	 */
	public  static final String SEQUENCE_TEAM="TeamSequence";
	public  static final String SEQUENCE_NAME_TEAM="SQ_ID_TEAM";
	public  static final String UNIQUE_CONSTRAINT_TEAM="UNIQUE_COLUMNS_TEAM";	
	public  static final String TABLE_TEAM="Teams";
	public  static final String COLUMN_ID_TEAM="ID_Team";
	public  static final String COLUMN_NAME_TEAM="Name_Team";
	public  static final String COLUMN_SEMESTER_TEAM="Semester_ID_Team";
	public  static final String COLUMN_POLE_TEAM="Semester_ID_Pole";
	public  static final String FK_ID_SEMESTER_TEAM="FK_ID_SEMESTER";
	public  static final String FK_ID_POLE_TEAM="FK_ID_POLE";
	public  static final String TEAM="team";
	
	/** 
	 * <p>Contants to table users;</p>
	 */
	public  static final String SEQUENCE_USER="UserSequence";
	public  static final String SEQUENCE_NAME_USER="SQ_ID_USER";
	public  static final String UNIQUE_CONSTRAINT_USER="UNIQUE_COLUMNS_USER";	
	public  static final String TABLE_USER="Users";
	public  static final String COLUMN_ID_USER="ID_User";
	public  static final String COLUMN_LOGIN_USER="Login_User";
	public  static final String COLUMN_PASSWORD_USER="Password_User";
	public  static final String COLUMN_ROLE_USER="Role_User";
	public  static final String FK_ID_ROLE_USER="FK_ID_ROLE";
	public  static final String USER="user";
	
	
	
	

}
