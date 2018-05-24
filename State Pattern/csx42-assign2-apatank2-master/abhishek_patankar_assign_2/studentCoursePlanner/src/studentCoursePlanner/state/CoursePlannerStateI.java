package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public interface CoursePlannerStateI {
	public void MeetGraduationCriteia(String CourseIn);
	public void AssignCourse(String CourseIn);
	public void PrintResult(Results ResultIn);
	public void ProcessWaitlist();
}
