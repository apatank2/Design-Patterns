package studentOrientation.activity;

import studentOrientation.measurement.CarbonFootprintI;
import studentOrientation.measurement.CostI;
import studentOrientation.measurement.DurationI;
import studentOrientation.measurement.EffortI;
import studentOrientation.util.TravellingOptionEnum;

public class VisitWatsonAcademic implements VisitingSchoolBuildingI, CarbonFootprintI, CostI, DurationI, EffortI {
	private Student student;
	private TravellingOptionEnum travellingOptionEnum;
	
	private double effortOnfoot = 24;
	private double effortbusride = 6.5;
	
	private double durationOnfoot = 8;
	private double durationbusride = 3.5;
	
	private double costOnfoot = 0.8;
	private double costbusride = 1.7;
	
	private double CfOnfoot = 2.1;
	private double Cfbusride = 1.3;
	
	public VisitWatsonAcademic(Student studentIn, TravellingOptionEnum travellingOptionEnumIn)
	{
		student = studentIn;
		travellingOptionEnum = travellingOptionEnumIn;
	}

	@Override
	public Student calculate() {
		calculateEffort();
		calculateDuration();
		calculateCost();
		calculateCarbonFootprint();
		return student;
	}

	public void calculateEffort() {
		switch (travellingOptionEnum) {
		case Busride:
			student.setEffortForVisiting2Building(effortbusride);
			break;
		case Onfoot:
			student.setEffortForVisiting2Building(effortOnfoot);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void calculateDuration() {
		switch (travellingOptionEnum) {
		case Busride:
			student.setDurationForVisiting2Building(durationbusride);
			break;
		case Onfoot:
			student.setDurationForVisiting2Building(durationOnfoot);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void calculateCost() {
		switch (travellingOptionEnum) 
		{
			case Busride:
				student.setCostForVisiting2Building(costbusride);
				break;
			case Onfoot:
				student.setCostForVisiting2Building(costOnfoot);
				break;
			default:
				break;
		}
	}

	@Override
	public void calculateCarbonFootprint() {
		switch (travellingOptionEnum) 
		{
			case Busride:
				student.setCO2ForVisiting2Building(Cfbusride);
				break;
			case Onfoot:
				student.setCO2ForVisiting2Building(CfOnfoot);
				break;
			default:
				break;
		}
		
	}
}
