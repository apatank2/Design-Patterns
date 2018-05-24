package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;

public class EventCenterGiftLocation implements GiftLocationI, CarbonFootprintI, CostI, DurationI, EffortI {

	private Student student;
	
	private double effort = 30;
	private double duration = 25;
	private double cost = 15;
	private double cf = 2.5;
	
	public EventCenterGiftLocation(Student studentIn)
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
		student.setEffortForPickingGift(effort);
	}

	@Override
	public void calculateDuration() {
		student.setDurationForPickingGift(duration);
	}

	@Override
	public void calculateCost() {
		student.setCostForPickingGift(cost);
	}

	@Override
	public void calculateCarbonFootprint() {
		student.setCO2ForPickingGift(cf);
	}

}
