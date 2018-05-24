package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public class ProcessElectives implements CoursePlannerStateI{
	CourseAllocation Course;
	private String status;
	private String CoursesCompleted;
	/**
	 * Constructor
	 * @param C :- Instance of Context Class
	 */
	public ProcessElectives(CourseAllocation C)
	{
		Course = C;
	}
	/**
	 * Appends Courses Completed to Results instance for following state
	 */
	public void PrintResult(Results r) {
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
		status = Course.Bnumber+" " +"Not Graduated:" + " " + CoursesCompleted + " " + Course.NoOfSemesterCompleted;
		r.Courses.add(status);
	}
	/**
	 * Changes the State from Not Graduate to Graduate based on the Graduation Criteria
	 * else change it to not graduated so that next courses can be processed
	 */
	public void MeetGraduationCriteia(String s) {
		// TODO Auto-generated method stubs
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
	/**
	 * Assigns Elective
	 * @param s :- Elective Course
	 */
	public void AssignCourse(String s) {
		// TODO Auto-generated method stub
		Course.Courses_Completed.add(s);
		if (Course.Courses_Completed.size() % Course.SubPerSemester == 1)
		Course.NoOfSemesterCompleted++;
		Course.Elective++;
		MeetGraduationCriteia(s);
	}

	public void ProcessWaitlist() {
		// TODO Auto-generated method stub
	}

}
