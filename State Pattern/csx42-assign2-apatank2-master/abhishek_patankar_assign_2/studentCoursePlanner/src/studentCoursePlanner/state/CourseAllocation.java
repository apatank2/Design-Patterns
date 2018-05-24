package studentCoursePlanner.state;
import java.util.ArrayList;
import java.util.List;

import studentCoursePlanner.util.Results;

public class CourseAllocation {
	CoursePlannerStateI ProcessElectives;
	CoursePlannerStateI ProcessCategories;
	CoursePlannerStateI Graduated;
	CoursePlannerStateI NotGraduated;
	CoursePlannerStateI CurrentState;
	public List<String> WaitList = new ArrayList<String>();
	public List<String> Long_Programming = new ArrayList<String>();
	public List<String> DSF = new ArrayList<String>();
	public List<String> HardSeq = new ArrayList<String>();
	public List<String> Data_Analytics = new ArrayList<String>();
	public List<String> Courses_Completed = new ArrayList<String>();
	boolean Grad;
	int NoOfSemesterCompleted,Elective;
	int SubPerSemester;
	int Bnumber;
	int CourseNo;
	int TotalCourses;
	/**
	 * Constructor for Context Class
	 * Create State instances, initializes state to NotGraduated and sets other variables.
	 */
	public CourseAllocation(){
		ProcessCategories = new ProcessCategories(this);
		ProcessElectives = new ProcessElectives(this);
		Graduated = new Graduated(this);
		NotGraduated = new NotGraduated(this);	
		Elective = 0;
		NoOfSemesterCompleted = 0;
		SubPerSemester = 3;
		Grad = false;
		CurrentState = NotGraduated;
		CourseNo = 0;
		TotalCourses = 0;
	}
	/**
	 * Changes the state based on the Graduation Criteria or Courses Categories
	 * @param s
	 */
	public void MeetGraduationCriteia(String s)
	{
	   CurrentState.MeetGraduationCriteia(s);
	}
	/**
	 * Assigns Courses One by One by Changing the State
	 * @param s :- String of Courses
	 */
	public void AssignCourse(String CoursesIn)
	{
		String Ignore = "[:]";
		String[] tokens = CoursesIn.split(Ignore);
		Bnumber = Integer.parseInt(tokens[0]);
		String string = tokens[1];
		string = string.replaceAll("\\s", "");
		TotalCourses =  string.length() - 1;
		for (int i =  0; i < string.length(); i++) {
			if (Grad == true)
			{
				break;
			}
			else
			{
			   int CourseAlreadyCompleted = 0;
				for (int i1 = 0; i1 < Courses_Completed.size(); i1++)
				{
					if(Courses_Completed.get(i1).equals(Character.toString(string.charAt(i))))
						CourseAlreadyCompleted = 1;
				}
				if (CourseAlreadyCompleted == 0)
				{
			 	CourseNo++;
			 	if (CourseNo > 3 && CourseNo % SubPerSemester == 1)
				{
					ProcessWaitlist();
				}
			 	if (TotalCourses == CourseNo && (Character.toString(string.charAt(i))).equals(Courses.ELECT.Q.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.R.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.S.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.T.toString()) ||
			 			Character.toString(string.charAt(i)).equals(Courses.ELECT.U.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.V.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.W.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.X.toString()) ||
			 			Character.toString(string.charAt(i)).equals(Courses.ELECT.Y.toString()) || Character.toString(string.charAt(i)).equals(Courses.ELECT.Z.toString()))
				{
				 ProcessWaitlist();
				}
			 	if (Grad == true)
				{
					break;
				}
			    MeetGraduationCriteia(Character.toString(string.charAt(i)));
			    CurrentState.AssignCourse(Character.toString(string.charAt(i)));
				}
			}
		}
		
	}
	/**
	 * Process the Waitlist before start of new semester for Co-requisites and Pre-requisites.
	 */
	public void ProcessWaitlist()
	{
		CurrentState.ProcessWaitlist();
	}
	/**
	 * Calls the respective state to append the Result to Results instance.
	 */
	public void PrintResult(Results ResultIn)
	{
		CurrentState.PrintResult(ResultIn);
	}
	@Override
	public String toString() {
		return "Courses_Completed=" + Courses_Completed
				+ ", NoOfSemesterCompleted=" + NoOfSemesterCompleted
				+ ", Bnumber=" + Bnumber + "]";
	}
	
}
