package studentOrientation.activity;

public class Student {
	
	private double visiting2BuildingEffort = 0;
	private double visiting2BuildingDuration =0;
	private double visiting2BuildingCost = 0;
	private double visiting2BuildingCO2 = 0;
	
	private double selectingCafeteriaForLunchEffort = 0;
	private double selectingCafeteriaForLunchDuration = 0;
	private double selectingCafeteriaForLunchCost = 0;
	private double selectingCafeteriaForLunchCO2 = 0;
	
	private double pickingGiftEffort = 0;
	private double pickingGiftDuration = 0;
	private double pickingGiftCost = 0;
	private double pickingGiftCO2 = 0;
	
	private double attendingLectureEffort = 0;
	private double attendingLectureDuration = 0;
	private double attendingLectureCost = 0;
	private double attendingLectureCO2 = 0;
	
	private double totalEffort = 0;
	private double totalDuration = 0;
	private double totalCost = 0;
	private double totalCO2 = 0;
	
	public Student()
	{
		totalEffort = 0;
		totalDuration = 0;
		totalCost = 0;
		totalCO2 = 0;
	}
	
	public void setEffortForVisiting2Building(double effortIn)
	{
		visiting2BuildingEffort = effortIn;
		totalEffort += effortIn;
	}
	
	
	public void setDurationForVisiting2Building(double durationIn)
	{
		visiting2BuildingDuration = durationIn;
		totalDuration += durationIn;
	}
	
	public void setCostForVisiting2Building(double CostIn)
	{
		visiting2BuildingCost = CostIn;
		totalCost += CostIn;
	}
	
	public void setCO2ForVisiting2Building(double Co2In)
	{
		visiting2BuildingCO2 = Co2In;
		totalCO2 += Co2In;
	}
	
	public void setEffortForselectingCafeteriaForLunch(double effortIn)
	{
		selectingCafeteriaForLunchEffort = effortIn;
		totalEffort += effortIn;
	}
	
	
	public void setDurationForselectingCafeteriaForLunch(double durationIn)
	{
		selectingCafeteriaForLunchDuration = durationIn;
		totalDuration += durationIn;
	}
	
	
	public void setCostForselectingCafeteriaForLunch(double CostIn)
	{
		selectingCafeteriaForLunchCost = CostIn;
		totalCost += CostIn;
	}
	
	
	public void setCO2ForselectingCafeteriaForLunch(double Co2In)
	{
		selectingCafeteriaForLunchCO2 = Co2In;
		totalCO2 += Co2In;
	}
	
	public void setEffortForPickingGift(double effortIn)
	{
		pickingGiftEffort = effortIn;
		totalEffort += effortIn;
	}
	
	public void setDurationForPickingGift(double durationIn)
	{
		pickingGiftDuration = durationIn;
		totalDuration += durationIn;
	}
	
	public void setCostForPickingGift(double CostIn)
	{
		pickingGiftCost = CostIn;
		totalCost += CostIn;
	}
	
	public void setCO2ForPickingGift(double Co2In)
	{
		pickingGiftCO2 = Co2In;
		totalCO2 += Co2In;
	}
	
	public void setEffortForAttendingLecture(double effortIn)
	{
		attendingLectureEffort = effortIn;
		totalEffort += effortIn;
	}
	
	public void setDurationForAttendingLecture(double durationIn)
	{
		attendingLectureDuration = durationIn;
		totalDuration += durationIn;
	}
	
	public void setCostForAttendingLecture(double CostIn)
	{
		attendingLectureCost = CostIn;
		totalCost += CostIn;
	}
	
	public void setCO2ForAttendingLecture(double Co2In)
	{
		attendingLectureCO2 = Co2In;
		totalCO2 += Co2In;
	}
	
	public double GetTotalEffort()
	{
		return totalEffort;
	}
	
	public double GetTotalDuration()
	{
		return totalDuration;
	}
	
	public double GetTotalCost()
	{
		return totalCost;
	}
	
	public double GetTotalCo2()
	{
		return totalCO2;
	}
	
	public String toString()
	{
		String writer = "";
		writer += String.format("Visiting 2 building: \n");
		writer += String.format("Effort:  %s", visiting2BuildingEffort + " calories" + "\n");
		writer += String.format("Duration:  %s", visiting2BuildingDuration + " minutes" + "\n");
		writer += String.format("Cost:  %s", visiting2BuildingCost + " dollar" + "\n");
		writer += String.format("Carbon Footprint:  %s", visiting2BuildingCO2 + " tons" + "\n \n");
		
		writer += String.format("Selecting Cafeteria For Lunch: \n");
		writer += String.format("Effort:  %s", selectingCafeteriaForLunchEffort + " calories" + "\n");
		writer += String.format("Duration:  %s", selectingCafeteriaForLunchDuration + " minutes" + "\n");
		writer += String.format("Cost:  %s", selectingCafeteriaForLunchCost + " dollar" + "\n");
		writer += String.format("Carbon Footprint:  %s", selectingCafeteriaForLunchCO2 + " tons" + "\n \n");
		
		writer += String.format("Picking a Gift: \n");
		writer += String.format("Effort:  %s", pickingGiftEffort + " calories" + "\n");
		writer += String.format("Duration:  %s", pickingGiftDuration + " minutes" + "\n");
		writer += String.format("Cost:  %s", pickingGiftCost + " dollar" + "\n");
		writer += String.format("Carbon Footprint:  %s", pickingGiftCO2 + " tons" + "\n \n");
		
		writer += String.format("Attending a Short Lecture: \n");
		writer += String.format("Effort:  %s", attendingLectureEffort + " calories" + "\n");
		writer += String.format("Duration:  %s", attendingLectureDuration + " minutes" + "\n");
		writer += String.format("Cost:  %s", attendingLectureCost + " dollar" + "\n");
		writer += String.format("Carbon Footprint:  %s", attendingLectureCO2 + " tons" + "\n \n");
		
		writer += String.format("Total Effort:  %.2f", GetTotalEffort()) + " calories" + "\n";
		writer += String.format("Total Duration:  %.2f", GetTotalDuration()) + " minutes" + "\n";
		writer += String.format("Total Cost:  %.2f", GetTotalCost()) + " dollar" + "\n";
		writer += String.format("Total Carbon Footprint:  %.2f", GetTotalCo2()) + " tons" + "\n";
		return writer;
	}
}
