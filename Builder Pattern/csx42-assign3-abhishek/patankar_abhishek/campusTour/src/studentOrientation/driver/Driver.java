package studentOrientation.driver;

import studentOrientation.activity.ActivityBuilder;
import studentOrientation.activity.Student;
import studentOrientation.util.CafeteriaEnum;
import studentOrientation.util.GiftLocationEnum;
import studentOrientation.util.LectureTypeEnum;
import studentOrientation.util.Results;
import studentOrientation.util.SchoolBuildingEnum;
import studentOrientation.util.StdoutDisplayInterfaceI;
import studentOrientation.util.TravellingOptionEnum;

/**
 * Driver --- program to implement Builder pattern.
 */
public class Driver {
	private StdoutDisplayInterfaceI displayInterfaceI;
	private Student student;
	
	public Driver()
	{
		displayInterfaceI = new Results();
	}
	
	/**
	   * Entry point
	   * @return No return value.
	   */
	public static void main(String[] args) 
	{
		try
		{
			Driver driver = new Driver();
			driver.CreateActivityPlanner();
			driver.Write();
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured while execution");
			System.exit(0);
		}
		finally
		{
			
		}
	}
	
	/**
	   * CreateActivityPlanner
	   * To set enum for each activity
	   * @return No return value.
	*/
	private void CreateActivityPlanner()
	{
		ActivityBuilder activityBuilder = new ActivityBuilder();
		
		//Visiting 2 school building
		SchoolBuildingEnum building1 = SchoolBuildingEnum.SOM;
		SchoolBuildingEnum building2 = SchoolBuildingEnum.Watson;
		
		//TravellingType
		TravellingOptionEnum travellingOption = TravellingOptionEnum.Busride;
		activityBuilder.SetVisitingSchoolBuilding(building1, building2, travellingOption);
		
		//Picking a gift
		GiftLocationEnum giftLocation = GiftLocationEnum.EventCenter;
		activityBuilder.SetPickingaGift(giftLocation);
		
		//Selecting a cafeteria for lunch
		CafeteriaEnum cafeteria = CafeteriaEnum.CIW;
		activityBuilder.SetCafeteriaForLunch(cafeteria);
		
		//attending a short lecture
		LectureTypeEnum lectureType = LectureTypeEnum.CS240;
		activityBuilder.SetShortLecture(lectureType);
		
		
		activityBuilder.constructAcivity();
		//Print information
		student = activityBuilder.GetStudent();
	}
	
	/**
	   * Write
	   * display string on console
	   * @return No return value.
	*/
	private void Write()
	{
		displayInterfaceI.write(student);
	}
}
