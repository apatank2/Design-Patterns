package studentOrientation.activity;

import studentOrientation.util.GiftLocationEnum;

/**
 * Driver --- PickingGift
 * Event for PickingGift from below options
 * EventCenter, UniversityUnion
 */
public class PickingGift extends StudentBuilder implements ActivityI {
	//private Student student;
	private GiftLocationEnum giftLocationEnum;
	private GiftLocationI giftLocationI;
	
	/**
	   * PickingGift
	   * constructor 
	   * input - accepting appropriate enum
	   * @return no return.
	*/
	public PickingGift(GiftLocationEnum giftLocationEnumIn)
	{
		giftLocationEnum = giftLocationEnumIn;
	}
	
	/**
	   * performOperation
	   * Picking Gift location depending on enum value
	   * @return updated Student.
	*/
	public Student performOperation(Student student) {
		//student = GetStudent();
		switch (giftLocationEnum) 
		{
			case EventCenter:
				giftLocationI = new EventCenterGiftLocation(student);
				student = giftLocationI.calculate();
				break;
				
			case UniversityUnion:
				giftLocationI = new UniversityUnionGiftLocation(student);
				student = giftLocationI.calculate();
				break;
		
			default:
				break;
		}
		//SetStudent(student);
		return student;
	}

}
