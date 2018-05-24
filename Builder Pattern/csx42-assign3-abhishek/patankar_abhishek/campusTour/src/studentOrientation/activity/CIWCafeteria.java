package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;

public class CIWCafeteria implements CafetriaI, CarbonFootprintI, CostI, DurationI, EffortI {
	private Student student;
	
	private double effort = 20;
	private double duration = 10.5;
	private double cost = 30;
	private double cf = 2.5;
	
	public CIWCafeteria(Student studentIn)
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
