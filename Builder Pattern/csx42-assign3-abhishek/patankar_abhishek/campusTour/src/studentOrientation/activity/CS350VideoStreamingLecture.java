package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;

public class CS350VideoStreamingLecture implements LectureTypeI, CarbonFootprintI, CostI, DurationI, EffortI {
	private Student student;
	
	private double effort = 30.6;
	private double duration = 170;
	private double cost = 50;
	private double cf = 3.6;
	
	public CS350VideoStreamingLecture(Student studentIn)
	{
		student = studentIn;
	}

	@Override
	public Student calculate() {
		calculateEffort();
		calculateDuration();
		calculateCost();
		calculateCarbonFootprint();
		return student;
	}

	@Override
	public void calculateEffort() {
		student.setEffortForAttendingLecture(effort);
	}

	@Override
	public void calculateDuration() {
		student.setDurationForAttendingLecture(duration);
	}

	@Override
	public void calculateCost() {
		student.setCostForAttendingLecture(cost);
	}

	@Override
	public void calculateCarbonFootprint() {
		student.setCO2ForAttendingLecture(cf);
	}
}
