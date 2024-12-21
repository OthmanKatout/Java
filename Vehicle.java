import java.util.*;
public class Vehicle {
 //-------------------------------------------------
	private String type="";
	private String registrationNumber="";
	private String brand="";
	private double rentalRatePerDay=0.0;
	private int rentDays=0;
	private boolean available;
//------------------------------------------------------      ( Variables ) 	

	public Vehicle() {}
	
	public Vehicle(String type , String registrationNumber , String brand , double rentalRatePerDay , boolean available ) {
		this.type=type;
		this.registrationNumber=registrationNumber;
		this.brand=brand;
		this.rentalRatePerDay=rentalRatePerDay;
		this.available=available;
	}
	
//-------------------------------------------------------     ( Constructor )
	
	
	public void printInfo() {
		if(available) {
		System.out.println(type + " " +"(Registration: " + registrationNumber + " ) , " + brand +" -- " + rentalRatePerDay +"/day \n");
		}
	}
	public void print2Info() {
		System.out.println("- Vehicle Code: " + registrationNumber + ", Type: " + type +", Brand: "+brand+", Daily Rate: $"+rentalRatePerDay + " /day \n");    
		
	}
	
	public String regNumber() {
		return registrationNumber;
	}
	public void setAvailable(boolean t) {
		available=t;
	}
	public void setDays(int days) {
		if(days > 0)
		rentDays=days;
	}

	public boolean isAvailable() {
		if(available)return true ;
		return false;
	}
	public double getRentalRatePerDay() {
		return rentalRatePerDay;
	}
	public String getType() {
		return type;
	}
	public int getDays() {
		return rentDays;
	}

	//-------------------------------------------------------   ( Methods )
	
}
