package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;

public class MountainViewCafeteria implements CafetriaI, CarbonFootprintI, CostI, DurationI, EffortI {
	private Student student;
	
	private double effort = 16.7;
	private double duration = 5.5;
	private double surcharge = 1.5;
	private double cost = 30 + surcharge;
	private double cf = 1.4;
	
	public MountainViewCafeteria(Student studentIn)
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
