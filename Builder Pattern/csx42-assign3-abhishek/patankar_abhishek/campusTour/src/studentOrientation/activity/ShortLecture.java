package studentOrientation.activity;

import studentOrientation.util.LectureTypeEnum;

/**
 * Driver --- ShortLecture
 * Event for Selecting short lecture from below options
 * CS240, CS350VideoStreaming
 */
public class ShortLecture extends StudentBuilder implements ActivityI {
	//private Student student;
	private LectureTypeEnum lectureTypeEnum;
	private LectureTypeI lectureTypeI;
	
	/**
	   * ShortLecture
	   * constructor 
	   * input - accepting appropriate enum
	   * @return no return.
	*/
	public ShortLecture(LectureTypeEnum lectureTypeEnumIn)
	{
		lectureTypeEnum = lectureTypeEnumIn;
	}
	
	/**
	   * performOperation
	   * selecting a short lecture depending on enum value
	   * @return updated Student.
	*/
	public Student performOperation(Student student) {
		//student = GetStudent();
		switch (lectureTypeEnum) 
		{
			case CS240:
				lectureTypeI = new CS240Lecture(student);
				student = lectureTypeI.calculate();
				break;
				
			case CS350VideoStreaming:
				lectureTypeI = new CS350VideoStreamingLecture(student);
				student = lectureTypeI.calculate();
				break;
		
			default:
				break;
		}
		//SetStudent(student);
		return student;
	}

}
