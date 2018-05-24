package studentOrientation.activity;

import studentOrientation.util.CafeteriaEnum;

/**
 * Driver --- CafeteriaForLunch
 * Event for Selecting a cafeteria for lunch from below options
 * CIWCafeteria, MountainView
 */
public class CafeteriaForLunch extends StudentBuilder implements ActivityI {

	private CafeteriaEnum cafeteriaEnum;
	private CafetriaI cafetriaI;
	
	/**
	   * CafeteriaForLunch
	   * constructor 
	   * input - accepting appropriate enum
	   * @return no return.
	*/
	public CafeteriaForLunch(CafeteriaEnum cafeteriaEnumIn)
	{
		cafeteriaEnum = cafeteriaEnumIn;
	}
	
	/**
	   * performOperation
	   * Selecting a cafeteria for lunch depending on enum value
	   * @return updated Student.
	*/
	public Student performOperation(Student student) {
		//student =  GetStudent();
		switch (cafeteriaEnum) 
		{
			case CIW:
				cafetriaI = new CIWCafeteria(student);
				student = cafetriaI.calculate();
				break;
				
			case MountainView:
				cafetriaI = new MountainViewCafeteria(student);
				student = cafetriaI.calculate();
				break;
		
			default:
				break;
		}
		//SetStudent(student);
		return student;
	}

}
