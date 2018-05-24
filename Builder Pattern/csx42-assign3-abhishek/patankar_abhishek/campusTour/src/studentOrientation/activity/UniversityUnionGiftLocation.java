package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;

public class UniversityUnionGiftLocation implements GiftLocationI, CarbonFootprintI, CostI, DurationI, EffortI {
	private Student student;
	
	private double effort = 25;
	private double duration = 12;
	private double cost = 8;
	private double cf = 1.78;
	
	public UniversityUnionGiftLocation(Student studentIn)
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
		student.setEffortForselectingCafeteriaForLunch(effort);
	}

	@Override
	public void calculateDuration() {
		student.setDurationForselectingCafeteriaForLunch(duration);
	}

	@Override
	public void calculateCost() {
		student.setCostForselectingCafeteriaForLunch(cost);
	}

	@Override
	public void calculateCarbonFootprint() {
		student.setCO2ForselectingCafeteriaForLunch(cf);
	}
}
