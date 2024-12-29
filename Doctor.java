package Try;
import java.util.*;
import java.lang.Comparable;
public class Doctor implements Comparable <Doctor>{

	private String doctorId;
	private String name;
	private String specialty;
	private String degree;
	private double basesalary;
	private double overtimeHours;
	private double overtimeRate;
	private Department department;

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	
	public Doctor(String doctorId, String name, String specialty, String degree, double basesalary,
			double overtimeHours, double overtimeRate, Department department) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialty = specialty;
		this.degree = degree;
		this.basesalary = basesalary;
		this.overtimeHours = overtimeHours;
		this.overtimeRate = overtimeRate;
		this.department = department;
	}
	

	Doctor(){}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public double getBasesalary() {
		return basesalary;
	}

	public void setBasesalary(double basesalary) {
		this.basesalary = basesalary;
	}

	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public double getOvertimeRate() {
		return overtimeRate;
	}

	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	public double calculateSalary() {
		if(degree.equals("Bachelor")) {
			return basesalary + (0.1 * basesalary);
		}
		else if(degree.equals("Master")) {
			return basesalary + (0.2 * basesalary);
		}
		else if(degree.equals("PhD")) {
			return basesalary + (0.3 * basesalary);
		}
		return 0.0;
	}
	
	public double calculateOvertimePay() {
		return overtimeHours * overtimeRate;
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialty=" + specialty + ", degree=" + degree
				+ ", basesalary=" + basesalary + ", overtimeHours=" + overtimeHours + ", overtimeRate=" + overtimeRate
				+ ", department=" + department.toString() + "]";
	}
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	@Override
	public int compareTo(Doctor Dr) {
		return Double.compare(this.calculateSalary(), Dr.calculateSalary());
	}
	
	
}
