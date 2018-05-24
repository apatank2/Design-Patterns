package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public class Graduated implements CoursePlannerStateI{
	CourseAllocation Course;
	private String status;
	private String CoursesCompleted;
	/**
	 * Constructor
	 * @param C :- Instance of Context Class
	 */
	public Graduated(CourseAllocation C)
	{
		Course = C;
	}
	/**
	 * Appends Courses Completed to Results instance for following state
	 */
	public void PrintResult(Results ResultIn) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Course.Courses_Completed.size(); i++) {
			if (i==0)
			{
				CoursesCompleted = Course.Courses_Completed.get(i);
			}
			else
			{
				CoursesCompleted = CoursesCompleted + " " + Course.Courses_Completed.get(i);
			}
		}
		status = Course.Bnumber + " " + "Graduated:" + " " + CoursesCompleted + ", Sem : " +  Course.NoOfSemesterCompleted;
		ResultIn.Courses.add(status);
	}
	/**
	 * Changes State from Graduate to Not Graduate based on the Graduation Criteria
	 */
	public void MeetGraduationCriteia(String CourseIn) {
		// TODO Auto-generated method stub
		if (Course.Long_Programming.size() >= 2 && Course.DSF.size()  >= 2 &&
				Course.HardSeq.size()  >= 2 && Course.Data_Analytics.size() >= 2 && Course.Elective  >= 2 &&
				Course.Courses_Completed.size() >= 10)
			{
			  Course.Grad = true;
			  Course.CurrentState = Course.Graduated;
			}
		else
		{
			Course.CurrentState = Course.NotGraduated;
		}
	}
	public void AssignCourse(String CourseIn) {
		// TODO Auto-generated method stub
	}
	public void ProcessWaitlist() {
		// TODO Auto-generated method stub
	}
}
