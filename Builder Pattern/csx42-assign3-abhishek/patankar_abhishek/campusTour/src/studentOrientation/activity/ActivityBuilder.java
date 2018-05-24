package studentOrientation.activity;

import studentOrientation.util.CafeteriaEnum;
import studentOrientation.util.GiftLocationEnum;
import studentOrientation.util.LectureTypeEnum;
import studentOrientation.util.SchoolBuildingEnum;
import studentOrientation.util.TravellingOptionEnum;

/**
 * Driver --- Activity Builder
 * Builder to construct all activities
 */
public class ActivityBuilder {
	private ActivityI visitingSchool;
	private ActivityI pickingGift;
	private ActivityI cafeteriaForLunch;
	private ActivityI attendingLecture;
	private Student student;
	
	//private StudentBuilder studentBuilder;
	
	/**
	   * Constructor
	   * @return No return value.
	   */
	public ActivityBuilder()
	{
		//studentBuilder = new StudentBuilder();
		student = new Student();
	}
	
	/**
	   * SetVisitingSchoolBuilding
	   * initialize VisitingSchoolBuilding with enum values
	   * @return No return value.
	   */
	public void SetVisitingSchoolBuilding(SchoolBuildingEnum building1, SchoolBuildingEnum building2, TravellingOptionEnum travellingOption)
	{
		visitingSchool = new VisitingSchoolBuilding(building1, building2, travellingOption);
	}
	
	/**
	   * SetPickingaGift
	   * initialize PickingGift with enum values
	   * @return No return value.
	   */
	public void SetPickingaGift(GiftLocationEnum giftLocationEnum)
	{
		pickingGift = new PickingGift(giftLocationEnum);
	}
	
	/**
	   * SetCafeteriaForLunch
	   * initialize CafeteriaForLunch with enum values
	   * @return No return value.
	   */
	public void SetCafeteriaForLunch(CafeteriaEnum cafeteriaEnum)
	{
		cafeteriaForLunch = new CafeteriaForLunch(cafeteriaEnum);
	}
	
	/**
	   * SetShortLecture
	   * initialize ShortLecture with enum values
	   * @return No return value.
	   */
	public void SetShortLecture(LectureTypeEnum lectureTypeEnum)
	{
		attendingLecture = new ShortLecture(lectureTypeEnum);
	}
	
	/**
	   * GetStudent
	   * @return student.
	   */
	public Student GetStudent()
	{
		return student;
	}
	
	/**
	   * constructAcivity
	   * construct activities
	   * @return No return value.
	   */
	public void constructAcivity()
	{
		//studentBuilder.CreateNewSudent();
		//Student student = studentBuilder.GetStudent();
		student = visitingSchool.performOperation(student);
		student = pickingGift.performOperation(student);
		student = cafeteriaForLunch.performOperation(student);
		student = attendingLecture.performOperation(student);
	}
}
