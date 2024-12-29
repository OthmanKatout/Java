package Try;
import java.util.*;
public class Department {

	private String departmentId;
	private String name;
	private ArrayList<PatientBase> patient = new ArrayList<>();
	private ArrayList<Doctor> doctors = new ArrayList<>();

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public Department(String departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}	
	
	Department(){}

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	public void  addDoctor(Doctor dr) {
		
		doctors.add(dr);
		
	}
	
   public void  addPatient(PatientBase Ps) {
		
	   patient.add(Ps);
		
	}

	
   // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", name=" + name +
			" ]";
}
   
   
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -




	
	
	
}
