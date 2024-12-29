package Try;
import java.util.*;
import java.util.Collection;
public class Main {

	public static void main(String[] args) {

		   ArrayList<PatientBase> patients = new ArrayList<>(Arrays.asList(
		            new EmergencyPatient("112201", "Bashar Al Assad", 59, "Murder",
		                new Department("001201", "Russia NO 4"), 100000),
		            new EmergencyPatient("112721", "Leo Messi", 40, "Broken",
		                new Department("010 NO.3", "1021"), 1500),
		            new LongTermPateint("199", "Hameedo", 12, "Broken",
		                new Department("1gg1", "N.4"), 1, 16.7)
		        ));
		   Department dp = new Department("12.NO2" ,"st.Ameer_Hassan");
		   Department dp2 = new Department("9.NO8" ,"st.Al Ersaal");
		   Department dp3 = new Department("1.NO10" ,"st.Nablus genaral street");
		   
         ArrayList<Doctor> doctors = new ArrayList<>(Arrays.asList(
        		 new Doctor("1232" ,"Omar" , "legs" , "PhD" , 1550.5 , 159 , 20.5 , new Department("N0.0" , "Al ersal")) , 
        		 new Doctor("12122" ,"Maher al assad" , "Faces" , "Bachelor" , 155.5 , 152 , 22.5 , new Department("N0.1" , "Al ersal")) , 
        		 new Doctor("3332" ,"Ahmad" , "Face" , "Master" , 12131 , 1532 , 20.25 , new Department("N0.2" , "Al ersal"))
        		 ));
		   
		   ArrayList<HospitalService> Hs = new ArrayList<>(Arrays.asList(
				   new HospitalService("X-ray" , 1005 , patients.get(0)),
				   new HospitalService("MRI" , 105 , patients.get(1)),
				   new HospitalService("lab tests" , 15 , patients.get(2))
				   ));
		   
		   System.out.println(patients.get(2).calculateBill());
		   Collections.sort(patients);
		   sortDoctorsBySalary(doctors);
		   for(int i = 0; i < doctors.size() ; i++) {
			   System.out.println(doctors.get(i).getName() + " " + doctors.get(i).calculateSalary());
		   }
		   generateBill(patients);
		   calculateTotalpatientsBill(patients);
		   
	}
	
	public static void sortDoctorsBySalary(ArrayList<Doctor> Dr) {
		Collections.sort(Dr);
	}
	
	public static double calculateTotalpatientsBill(ArrayList<PatientBase> ps) {
		double res = 0.0 ;
		for(int i = 0 ; i < ps.size() ; i ++) {
			res+=ps.get(i).calculateBill();
		}
		return res;
	}
	public static void generateBill(ArrayList<PatientBase> ps) {
		for(PatientBase it : ps) {
			System.out.println(it.toString());
		}
	}
	

}
