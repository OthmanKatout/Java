package Try;
import java.util.*;
public class EmergencyPatient extends PatientBase {

private double emergencyFee;

public EmergencyPatient(String patientId, String name, int age, String medicalHistory, Department department,
		double emergencyFee) {
	super(patientId, name, age, medicalHistory, department);
	this.emergencyFee = emergencyFee;
}

EmergencyPatient(){}

public double getEmergencyFee() {
	return emergencyFee;
}

public void setEmergencyFee(double emergencyFee) {
	this.emergencyFee = emergencyFee;
}

public double calculateBill() {
	
	double service_costs = 0.0;
	for(int i = 0 ; i < getlengthHospital() ; i ++ ) {
		
		service_costs += getHospitalService(i).getServiceCost();
	
	}
	
	return emergencyFee + service_costs * (1 + TAX_RATE); 
	
}

@Override
public String toString() {
	return "EmergencyPatient [emergencyFee=" + emergencyFee + ", Name =" + getName() + ", Age =" + getAge()
			+ ", getMedicalHistory =" + getMedicalHistory() + ", "  + super.toString() + "]";
}

	

}
