import java.util.*;
public class Customer {
Scanner sc=new Scanner (System.in);
	
	private String name="" ;
	private int id;
	private String lincenseNumeber="";
	private int numberOfCurrentRented=0;
	private int maxVehicles=0;
	private Vehicle [] vehiclesRented;
	//----------------------------------------------- (Variables)
	
	public Customer() {}
	
	public Customer(String name , int id , String licenseNumber , int maxVehicles ) {
		this.name = name;
		this.id = id;	
		this.lincenseNumeber = licenseNumber;
        this.maxVehicles=maxVehicles;
	    vehiclesRented=new Vehicle[maxVehicles];
	}
	
     
	//----------------------------------------------- (Constructor)

   public void rentVehicle(Vehicle vehicle , int day ) {
        if(numberOfCurrentRented >= vehiclesRented.length) {
        return;
     }
	   vehiclesRented[numberOfCurrentRented]=vehicle;
	   vehiclesRented[numberOfCurrentRented].setDays(day);
	   numberOfCurrentRented++;
	   
   }
   
   public void returnVehicle(Vehicle vehicle ) {
	   for(int i=0;i<vehiclesRented.length;i++) {
		   if(vehiclesRented[i] == null)continue;
		   
		   if(vehiclesRented[i] == vehicle ) {
			   shifting(i);
			   numberOfCurrentRented--;
			   break;
		   }
	   }
	   
   }
   public void shifting(int index) {
	   for(int i=index ; i < vehiclesRented.length - 1;i++ ) {
		   vehiclesRented[i]=vehiclesRented[i + 1];
	   }
	   
   }
   
   public double calculateRent() {
	   double Cost=0;
	   for(int i=0 ; i < numberOfCurrentRented ;i++) {
		   Cost += (vehiclesRented[i].getDays() * vehiclesRented[i].getRentalRatePerDay());
	   }
	   return Cost;
	   
   }
	
   public double calculateRent(String type) {
	  double Cost = 0;
	  for(int i=0;i < vehiclesRented.length ;i++) {
		  if(vehiclesRented[i].getType().equals(type)) {
			  Cost+=vehiclesRented[i].getRentalRatePerDay();
		  }
	  }
	  return Cost;
	   
   }
   
	public int countVehiclesByType(String type) {
		 int numberOfcars=0;
		   for(int i=0;i<numberOfCurrentRented;i++) {
			   if((vehiclesRented[i].getType()).equals(type)) {
				   numberOfcars++;
			   }
		   }
		   return numberOfcars;
		
	}
	
	public void printInfo() {
		
		System.out.println("Customer Information :");
		System.out.println("Name: " + name );
		System.out.println("ID: " +id);
		System.out.println("License Number: " + lincenseNumeber);
		System.out.println("Vehicles Rented: \n");
		
		if(numberOfCurrentRented == 0) {
			System.out.println("\nThere's no vehicle \n ");
		}
		
		for(int i=0;i<numberOfCurrentRented;i++) {
			vehiclesRented[i].print2Info();
		}
		
		
	}
	public boolean isValid() {
		
		if(numberOfCurrentRented < vehiclesRented.length) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getnumberOfCurrentRented() {
		return numberOfCurrentRented;
	}
	
	public Vehicle getVehicle(int index) {
		
		return vehiclesRented[index];
		
	}
	
	public void printVehicles() {
		
		for(int i=0;i<numberOfCurrentRented;i++) {
			
			if(vehiclesRented[i] == null)continue;
			
			vehiclesRented[i].print2Info();
			
		}
		
	}
	public Vehicle getVehicle(String number) {
		Vehicle V = null;
		for(int i=0;i<numberOfCurrentRented;i++) {
			if(vehiclesRented[i] == null)continue;
			if(vehiclesRented[i].regNumber().equals(number)) {
				return vehiclesRented[i];
			}
		}
		return V;
	}
	public boolean canRet() {
		if(numberOfCurrentRented == 0) {
			return false;
		}
		return true;
	}
	
}
