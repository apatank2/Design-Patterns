package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public class NotGraduated implements CoursePlannerStateI{
		CourseAllocation Course;
		private String status;
		private String CoursesCompleted;
		/**
		 * Constructor
		 * @param C :- Instance of Context Class
		 */
		public NotGraduated(CourseAllocation C)
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
			status = Course.Bnumber + " " + "Not Graduated:" + " " + CoursesCompleted + ", Sem : " +  Course.NoOfSemesterCompleted;
			ResultIn.Courses.add(status);
		}
		/**
		 * Changes the State from Not Graduate to Graduate based on the Graduation Criteria
		 * else changes it to Process Categories state or Process Elective state so that 
		 * next course can be assigned
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
				AssignCourse(CourseIn);
			}
		}
		/**
		 * Based on Next Course it decides the next state
		 */
		public void AssignCourse(String CourseIn) {
			// TODO Auto-generated method stub
			if (CourseIn.equals(Courses.LP.A.toString())  || CourseIn.equals(Courses.LP.B.toString()) || CourseIn.equals(Courses.LP.C.toString()) || CourseIn.equals(Courses.LP.D.toString()) ||
				CourseIn.equals(Courses.DSF.E.toString()) || CourseIn.equals(Courses.DSF.F.toString()) || CourseIn.equals(Courses.DSF.G.toString()) || CourseIn.equals(Courses.DSF.H.toString()) ||
				CourseIn.equals(Courses.HS.I.toString()) || CourseIn.equals(Courses.HS.J.toString()) || CourseIn.equals(Courses.HS.K.toString()) || CourseIn.equals(Courses.HS.L.toString()) ||
				CourseIn.equals(Courses.DA.M.toString()) || CourseIn.equals(Courses.DA.N.toString()) || CourseIn.equals(Courses.DA.O.toString()) || CourseIn.equals(Courses.DA.P.toString()))
			{
				Course.CurrentState = Course.ProcessCategories;
			}
			else if (CourseIn.equals(Courses.ELECT.Q.toString()) || CourseIn.equals(Courses.ELECT.R.toString()) || CourseIn.equals(Courses.ELECT.S.toString()) || CourseIn.equals(Courses.ELECT.T.toString()) ||
					CourseIn.equals(Courses.ELECT.U.toString()) || CourseIn.equals(Courses.ELECT.V.toString()) || CourseIn.equals(Courses.ELECT.W.toString()) || CourseIn.equals(Courses.ELECT.X.toString()) ||
					CourseIn.equals(Courses.ELECT.Y.toString()) || CourseIn.equals(Courses.ELECT.Z.toString()))
			{
				Course.CurrentState = Course.ProcessElectives;
			}
			
		}
        /**
         * Process Waitlist before start of every new Semester 
         */
		public void ProcessWaitlist() {
			// TODO Auto-generated method stub
			Course.CurrentState = Course.ProcessCategories;
			Course.CurrentState.ProcessWaitlist();
			if (Course.Long_Programming.size() >= 2 && Course.DSF.size()  >= 2 &&
					Course.HardSeq.size()  >= 2 && Course.Data_Analytics.size() >= 2 && Course.Elective  >= 2 &&
					Course.Courses_Completed.size() >= 10)
				{
				  Course.Grad = true;
				  Course.CurrentState = Course.Graduated;
				}
			else
			Course.CurrentState = Course.NotGraduated;
		}


}
