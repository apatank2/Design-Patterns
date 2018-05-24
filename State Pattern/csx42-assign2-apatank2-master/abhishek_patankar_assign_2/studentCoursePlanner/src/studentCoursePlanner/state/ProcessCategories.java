package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public class ProcessCategories implements CoursePlannerStateI{
	CourseAllocation Course;
	private String status;
	private String CoursesCompleted;
	/**
	 * Constructor
	 * @param C :- Instance of Context Class
	 */
	public ProcessCategories(CourseAllocation C)
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
		status = Course.Bnumber+" " +"Not Graduated:" + " " + CoursesCompleted + " " +  Course.NoOfSemesterCompleted;
		ResultIn.Courses.add(status);
	}
	/**
	 * Changes the State from Not Graduate to Graduate based on the Graduation Criteria
	 * else change it to not graduated so that next courses can be processed
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
	public void RegisterCourse(String CourseIn)
	{
		Course.Courses_Completed.add(CourseIn);
		if (Course.Courses_Completed.size() % Course.SubPerSemester == 1)
		Course.NoOfSemesterCompleted++;
		
	}
	/**
	 * Process the Waitlist before start of new semester for the Courses against 
	 * Pre and Co-requisites Categories
	 */
	public void ProcessWaitlist()
	{
		int Lp_size = Course.Long_Programming.size();
		int Dsf_size = Course.DSF.size();
		int Hs_size = Course.HardSeq.size();
		int Da_size = Course.Data_Analytics.size();
		for (int i = 0; i < Course.WaitList.size(); i++) {
			if (Course.WaitList.get(i).equals(Courses.LP.A.toString()) || Course.WaitList.get(i).equals(Courses.LP.B.toString()) || 
					Course.WaitList.get(i).equals(Courses.LP.C.toString()) || Course.WaitList.get(i).equals(Courses.LP.D.toString()))
			{
				if (Course.Long_Programming.size() == 0)
				{
				RegisterCourse(Course.WaitList.get(i));
				Course.Long_Programming.add(Course.WaitList.get(i)); 
				Course.Long_Programming.sort(null);
				}
				else
				{
					if (Lp_size == 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.Long_Programming.add(Course.WaitList.get(i)); 
						Course.Long_Programming.sort(null);
					}
					else
					{
					String HigherOrderCourse = Course.Long_Programming.get(Lp_size-1);
					int result = HigherOrderCourse.compareTo(Course.WaitList.get(i));
					if (result < 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.Long_Programming.add(Course.WaitList.get(i)); 
						Course.Long_Programming.sort(null);
					}
					}
				}
				
			}
			if (Course.WaitList.get(i).equals(Courses.DSF.E.toString()) || Course.WaitList.get(i).equals(Courses.DSF.F.toString()) || 
					Course.WaitList.get(i).equals(Courses.DSF.G.toString()) || Course.WaitList.get(i).equals(Courses.DSF.H.toString()))
			{
				if (Course.DSF.size() == 0)
				{
				RegisterCourse(Course.WaitList.get(i));
				Course.DSF.add(Course.WaitList.get(i)); 
				Course.DSF.sort(null);
				}
				else
				{
					if (Dsf_size == 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.DSF.add(Course.WaitList.get(i)); 
						Course.DSF.sort(null);
					}
					else
					{
					String HigherOrderCourse = Course.DSF.get(Dsf_size-1);
					int result = HigherOrderCourse.compareTo(Course.WaitList.get(i));
					if (result < 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.DSF.add(Course.WaitList.get(i)); 
						Course.DSF.sort(null);
					}
					}
				}
				
				
			}
			if (Course.WaitList.get(i).equals(Courses.HS.I.toString()) || Course.WaitList.get(i).equals(Courses.HS.J.toString()) || 
					Course.WaitList.get(i).equals(Courses.HS.K.toString()) || Course.WaitList.get(i).equals(Courses.HS.L.toString()))
			{
				if (Course.HardSeq.size() == 0)
				{
				RegisterCourse(Course.WaitList.get(i));
				Course.HardSeq.add(Course.WaitList.get(i)); 
				Course.HardSeq.sort(null);
				}
				else
				{
					if (Hs_size == 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.HardSeq.add(Course.WaitList.get(i)); 
						Course.HardSeq.sort(null);
					}
					else
					{
					String HigherOrderCourse = Course.HardSeq.get(Hs_size-1);
					int result = HigherOrderCourse.compareTo(Course.WaitList.get(i));
					if (result < 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.HardSeq.add(Course.WaitList.get(i)); 
						Course.HardSeq.sort(null);
					}
				    }
				}
				
			}
			if (Course.WaitList.get(i).equals(Courses.DA.M.toString()) || Course.WaitList.get(i).equals(Courses.DA.N.toString()) || 
					Course.WaitList.get(i).equals(Courses.DA.O.toString()) || Course.WaitList.get(i).equals(Courses.DA.P.toString()))
			{
				if (Course.Data_Analytics.size() == 0)
				{
				RegisterCourse(Course.WaitList.get(i));
				Course.Data_Analytics.add(Course.WaitList.get(i)); 
				Course.Data_Analytics.sort(null);
				}
				else
				{
					if (Da_size == 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.Data_Analytics.add(Course.WaitList.get(i)); 
						Course.Data_Analytics.sort(null);
					}
					else
					{
					String HigherOrderCourse = Course.Data_Analytics.get(Da_size-1);
					int result = HigherOrderCourse.compareTo(Course.WaitList.get(i));
					if (result < 0)
					{
						RegisterCourse(Course.WaitList.get(i));
						Course.Data_Analytics.add(Course.WaitList.get(i)); 
						Course.Data_Analytics.sort(null);
					}
					}
				}
				
			}
			MeetGraduationCriteia(null);
			if (Course.Grad == true)
			{
				break;
			}
			
		}
		Course.WaitList.removeAll(Course.WaitList);
	}
	/**
	 * Assigns new course or add it to Waitlist based on pre and co-requisites
	 * @param s :- New Course
	 */
	public void AssignCourse(String CourseIn) {
		// TODO Auto-generated method stub
		if (CourseIn.equals(Courses.LP.A.toString()) || CourseIn.equals(Courses.LP.B.toString()) || CourseIn.equals(Courses.LP.C.toString()) || CourseIn.equals(Courses.LP.D.toString()))
		{
			if(Course.Long_Programming.size() == 0 && CourseIn.equals(Courses.LP.A.toString()))	
				 {
					    RegisterCourse(CourseIn);
						Course.Long_Programming.add(CourseIn); 
						Course.Long_Programming.sort(null);
				 }
				else
				{
					    if(Course.Long_Programming.size() == 0)
					    Course.WaitList.add(CourseIn);
					    else
					    {
					    int size = Course.Long_Programming.size();
						String HigherOrderCourse = Course.Long_Programming.get(size-1);
						int result = HigherOrderCourse.compareTo(CourseIn);
						if (result < 0)
						{
							Course.WaitList.add(CourseIn);
						}
						else
						{
							Course.CourseNo = Course.CourseNo - 1;
						}
					    }
				}
			
				if (Course.TotalCourses == Course.CourseNo)
				{
				 ProcessWaitlist();
				}
					
		}
		else if (CourseIn.equals(Courses.DSF.E.toString()) || CourseIn.equals(Courses.DSF.F.toString()) || CourseIn.equals(Courses.DSF.G.toString()) || CourseIn.equals(Courses.DSF.H.toString()))
		{
			if(Course.DSF.size() == 0 && CourseIn.equals(Courses.DSF.E.toString()))	
				 {
					    RegisterCourse(CourseIn);
						Course.DSF.add(CourseIn); 
						Course.DSF.sort(null);
				 }
				else
				{
					if(Course.DSF.size() == 0)
					    Course.WaitList.add(CourseIn);
					    else
					    {
					    int size = Course.DSF.size();
						String HigherOrderCourse = Course.DSF.get(size-1);
						int result = HigherOrderCourse.compareTo(CourseIn);
						if (result < 0)
						{
							Course.WaitList.add(CourseIn);
						}
						else
						{
							Course.CourseNo = Course.CourseNo - 1;
						}
					    }
				}
			
			if (Course.TotalCourses == Course.CourseNo)
			{
			 ProcessWaitlist();
			}
		}
		else if (CourseIn.equals(Courses.HS.I.toString()) || CourseIn.equals(Courses.HS.J.toString()) || CourseIn.equals(Courses.HS.K.toString()) || CourseIn.equals(Courses.HS.L.toString()))
		{
			if(Course.HardSeq.size() == 0 && CourseIn.equals(Courses.HS.I.toString()))	
				 {
					    RegisterCourse(CourseIn);
						Course.HardSeq.add(CourseIn); 
						Course.HardSeq.sort(null);
				 }
				else
				{
					if(Course.HardSeq.size() == 0)
					    Course.WaitList.add(CourseIn);
					    else
					    {
					    int size = Course.HardSeq.size();
						String HigherOrderCourse = Course.HardSeq.get(size-1);
						int result = HigherOrderCourse.compareTo(CourseIn);
						if (result < 0)
						{
							Course.WaitList.add(CourseIn);
						}
						else
						{
							Course.CourseNo = Course.CourseNo - 1;
						}
					    }
				}
			
			if (Course.TotalCourses == Course.CourseNo)
			{
			 ProcessWaitlist();
			}
		}
		else if (CourseIn.equals(Courses.DA.M.toString()) || CourseIn.equals(Courses.DA.N.toString()) || CourseIn.equals(Courses.DA.O.toString()) || CourseIn.equals(Courses.DA.P.toString()))
		{
			if(Course.Data_Analytics.size() == 0 && CourseIn.equals(Courses.DA.M.toString()))	
				 {
					    RegisterCourse(CourseIn);
						Course.Data_Analytics.add(CourseIn); 
						Course.Data_Analytics.sort(null);
				 }
				else
				{
					if(Course.Data_Analytics.size() == 0)
					    Course.WaitList.add(CourseIn);
					    else
					    {
					    int size = Course.Data_Analytics.size();
						String HigherOrderCourse = Course.Data_Analytics.get(size-1);
						int result = HigherOrderCourse.compareTo(CourseIn);
						if (result < 0)
						{
							Course.WaitList.add(CourseIn);
						}
						else
						{
							Course.CourseNo = Course.CourseNo - 1;
						}
					    }
				}
			if (Course.TotalCourses == Course.CourseNo)
			{
			 ProcessWaitlist();
			}
			}
		MeetGraduationCriteia(CourseIn);
	}
	
}
