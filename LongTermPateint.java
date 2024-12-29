package Try;
import java.util.*;

public class LongTermPateint extends PatientBase{

	private int daysAdmitted;
	private double dailyRate;
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	public LongTermPateint(String patientId, String name, int age, String medicalHistory, Department department,
			int daysAdmitted, double dailyRate) {
		super(patientId, name, age, medicalHistory, department);
		this.daysAdmitted = daysAdmitted;
		this.dailyRate = dailyRate;
	}
	
	LongTermPateint(){}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	public int getDaysAdmitted() {
		return daysAdmitted;
	}
	public void setDaysAdmitted(int daysAdmitted) {
		this.daysAdmitted = daysAdmitted;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
	@Override
	public String toString() {
		return "LongTermPateint [daysAdmitted =" + daysAdmitted + ", dailyRate =" + dailyRate + ", " + super.toString() +" ]";
	}
	

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
	public double calculateBill() {
		double service_costs = 0.0;
		for(int i = 0 ; i < getlengthHospital() ; i ++ ) {
			
			service_costs += getHospitalService(i).getServiceCost();
		
		}
		return (daysAdmitted * dailyRate + service_costs) * ( 1 + TAX_RATE);
	}


	
}
