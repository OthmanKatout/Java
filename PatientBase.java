package Try;
import java.util.*;
import java.lang.Comparable;
public abstract class PatientBase implements Comparable <PatientBase> , Billable {

	private String patientId;
	private String name;
	private int age;
	private String medicalHistory;
	private Department department;
	private ArrayList<HospitalService> services = new ArrayList<>();
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	public PatientBase(String patientId, String name, int age, String medicalHistory, Department department) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.department = department;
	}
	
	PatientBase(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
    public HospitalService getHospitalService(int i) {
    	return services.get(i);
    }
    public int getlengthHospital() {
    	return services.size();
    }
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	
	abstract public double calculateBill();


	@Override
	public String toString() {
		return "PatientBase [patientId=" + patientId + ", name=" + name + ", age=" + age + ", medicalHistory="
				+ medicalHistory + ", department=" + department.toString() + "]";
	}
	
	@Override
	public int compareTo(PatientBase pb) {
		return Double.compare(this.calculateBill(), pb.calculateBill());
	}

	public void addHostbital(HospitalService H) {
		services.add(H);
	}
	
	
	
}
