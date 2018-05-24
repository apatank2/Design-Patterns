package studentOrientation.activity;

public class StudentBuilder {
	private Student student;
	
	public void CreateNewSudent()
	{
		student = new Student();
	}
	
	public Student GetStudent()
	{
		if(student == null)
			student = new Student();
		
		return student;
	}
	
	public void SetStudent(Student studentIn)
	{
		student = studentIn;
	}
}
