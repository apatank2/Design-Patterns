package studentOrientation.activity;

import studentOrientation.util.SchoolBuildingEnum;
import studentOrientation.util.TravellingOptionEnum;

/**
 * Driver --- CafeteriaForLunch
 * Event for Visiting School Building from below options
 * SOM, Watson, AcademicBuilding
 * Busride, Onfoot
 */
public class VisitingSchoolBuilding extends StudentBuilder implements ActivityI {

	//private Student student;
	SchoolBuildingEnum building1;
	SchoolBuildingEnum building2;
	TravellingOptionEnum travellingOption;
	VisitingSchoolBuildingI visitingSchoolBuildingI;
	public VisitingSchoolBuilding(SchoolBuildingEnum building1In, SchoolBuildingEnum building2In, TravellingOptionEnum travellingOptionIn)
	{
		building1 = building1In;
		building2 = building2In;
		travellingOption = travellingOptionIn;
	}
	
	/**
	   * performOperation
	   * Visiting 2 building depending on enum value
	   * @return updated Student.
	*/
	public Student performOperation(Student student) {
		//student = GetStudent();
		if(building1 == SchoolBuildingEnum.SOM && building2 == SchoolBuildingEnum.Watson ||
				building1 == SchoolBuildingEnum.Watson && building2 == SchoolBuildingEnum.SOM)
		{
			visitingSchoolBuildingI =  new VisitSOMWatson(student, travellingOption);
			student = visitingSchoolBuildingI.calculate();
			//SetStudent(student);
		}
		else if (building1 == SchoolBuildingEnum.Watson && building2 == SchoolBuildingEnum.AcademicBuilding ||
				building1 == SchoolBuildingEnum.AcademicBuilding && building2 == SchoolBuildingEnum.Watson)
		{
			visitingSchoolBuildingI =  new VisitWatsonAcademic(student, travellingOption);
			student = visitingSchoolBuildingI.calculate();
		}
		else if (building1 == SchoolBuildingEnum.SOM && building2 == SchoolBuildingEnum.AcademicBuilding ||
				building1 == SchoolBuildingEnum.AcademicBuilding && building2 == SchoolBuildingEnum.SOM)
		{
			visitingSchoolBuildingI =  new VisitSOMAcademic(student, travellingOption);
			student = visitingSchoolBuildingI.calculate();
		}
		return student;
	}

}
