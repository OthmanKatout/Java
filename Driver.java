import java.util.*;
public class Driver {

	public static void main(String[] args) {

		Scanner sc= new Scanner (System.in);
		
		System.out.println("Enter the number of customers : ");
		int numberOfCustomer=sc.nextInt();
		
		Vehicle[] availableVehicles = { 
				new Vehicle("Car", "ABC123", "Toyota", 50.0 , true), 
				new Vehicle("Bike", "DEF456", "Honda", 20.0 , true), 
				new Vehicle("Truck", "GHI789", "Ford", 80.0 , true), 
				new Vehicle("Car", "JKL012", "Hyundai",55.0 , true), 
				new Vehicle("Bike", "MNO345", "Yamaha",160.0, true) 
				};
		
		Customer [] customer = new Customer[numberOfCustomer]; // array of customers 
		
		for(int i=0;i<numberOfCustomer;i++) {
		System.out.println("Enter details for customer " + (i + 1)+"\n");
		
		System.out.println("Enter the name of the customer : \n");
		///**********************
		sc.nextLine();
		String name=sc.nextLine();
		
		System.out.println("Enter the ID for the customer : \n ");

		int id=sc.nextInt();
		
		System.out.println("Enter the license number : \n");

		String licensenumber=sc.next();
		
    	System.out.println("Enter the maximum number of Vehicle : \n");
		
    	int maximum_number_of_V=sc.nextInt(); // we can say that this is the Teacher array size for every customer
		
		customer[i]=new Customer(name , id , licensenumber , maximum_number_of_V);
		
		//------------------------------------------------------------------------------
		
		System.out.println("Enter the number of vehicle to rent now : \n"); // how many cars do you want to rent ? 
		
		int numberTorent=sc.nextInt();
		if(numberTorent != 0) {
		System.out.println("Available vehicles for rental : \n");
		
		for(Vehicle it : availableVehicles) { // print the set of the vehicles 
		it.printInfo();
		}
		
		}		
		int index=0;
		
		while(index < numberTorent) { // while the number of the cars 
		
			if(!customer[i].isValid()) { // if we excess the limits 
			
				System.out.println("You have reached your rental limit \n");
				
				break;
			}
			
			System.out.println("Enter registration number of vehicle " + (index + 1) + " to rent or type exit to stop renting : \n"); // get the registration number 
			
			String regnum=sc.next();
			if(regnum.equals("exit")) {System.out.println("rental process ended by customer .\n ");
			break;
			}
			
			boolean ok=false , okk=false; // to check the cases 
			
			for(int j=0;j<availableVehicles.length;j++) { // to search about the car 
				// check if it is found 
			if( (availableVehicles[j].regNumber()).equals(regnum)) {
				
				if(!(availableVehicles[j].isAvailable() )) { // we found it but is it available ? 
					okk=true; // no it is not 
					break; // finish the search 
				}
				
				ok=true;// it is available 
				System.out.println("Enter the rental days : \n ");
				int days=sc.nextInt();
				System.out.println("Vehicle rented successfully. \n");//---
				index++;// the number of cars 
				// rent the car
				customer[i].rentVehicle(availableVehicles[j] , days ); // using the rentVehcile method in the customer class 
				availableVehicles[j].setAvailable(false); // it is not available any more 
				
				break; // end the search
			}
				
			}
			
			if(okk) {
			System.out.println("Vehicle not available. Please choose another. \n");	
			
			}
			else if(!ok) {
				
				System.out.println("Vehicle not found. Please enter a valid registration number again . \n");
			
			}
			
			 
		
		}
		
		}
		
		// now we finish the first part , let's write the menu : 
		int Choice = 0;
		
		do {
			System.out.println("Main Menu: ");
			System.out.println("1: Print Customer Information ");
			System.out.println("2: Display Total Rental Cost for a Customer ");
			System.out.println("3: Count Rented Vehicles by Type ");
			System.out.println("4: Rent a New Vehicle  ");
			System.out.println("5: Return a Vehicle  ");
			System.out.println("6: Display All Available Vehicles in Ascending Order of Price ");
			System.out.println("7: Display All Available Vehicles in Alphabetical Order of Type  ");
			System.out.println("8: Exit ");

			Choice =sc.nextInt();
			if(Choice > 8 || Choice < 0 ) {
				continue;
			}
			switch(Choice) { // Every Choice have something to do 
			
			case 1 : printCustomerInformation(customer); // print the informations
			break;
			
			case 2 : Choice2(customer);
			break;
			
			case 3 : Choice3(customer);
			break;
			
			case 4 : Choice4(customer , availableVehicles);
			break;
			
			case 5 : Choice5(customer,availableVehicles);
			break;
			
			case 6: displayVehiclesByPrice(availableVehicles);
			break;
			
			case 7: displayVehiclesByType(availableVehicles);
			break;
			
			case 8: System.out.println("Goodbye!"); 
				break;
			
			}
			
			
			
		}while(Choice != 8 ); // while we not pressing Exit 
     
		
		
		
		
		
	}
	
	public static void printCustomerInformation(Customer [] Ct ) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer ID: \n ");
		int ID=sc.nextInt();

		Customer customer=findCustomerById(Ct , ID);
		if(customer == null) {
			System.out.println("Customer not found. \n");
		}
		else {
			customer.printInfo();
		}
		
	}
	
	public static void Choice2 (Customer [] Ct) { // calculate the prices 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer ID: \n");
		int id=sc.nextInt();
	
		Customer customer=findCustomerById(Ct , id);
		if(customer == null) {
			System.out.println("Customer not found. \n");
		}
		else {
			
			System.out.println("Total Rental Cost for John Doe: $" + customer.calculateRent() +" \n");
		}
		
	}
	
	public static void Choice3 (Customer [] Ct) { // Count the number of a specific Vehicle based on it's type
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter customer ID: \n");
		
		int id=sc.nextInt();
		
		System.out.println("Enter vehicle type to count (e.g., Car, Bike): \n");
		
		String type=sc.next();
		

		Customer customer=findCustomerById(Ct , id );
		if(customer == null) {
			System.out.println("The id that you entered not found :( \n");
		}
		else {
			System.out.println("Number of " +type +"(s)" + " rented by " + customer.getName() +" : " + customer.countVehiclesByType(type) + " \n");
		}
		
		
	}
	
	public static void Choice4(Customer[] Ct ,Vehicle[] Ve) { // rent a new car from the original array of Vehicles 
		Scanner sc=new Scanner(System.in);
		boolean okk=false;
		for(int i=0;i<Ve.length;i++) {
			if(Ve[i].isAvailable()) {
				okk=true;
				break;
			}
		}
		if(!okk) {
		System.out.println("There's nothing to rent :( \n");
		return;
		}
		System.out.print("Enter customer ID : ");
		int id=sc.nextInt();

		Customer customer=findCustomerById(Ct , id );
		
		if(!customer.isValid()) {
			System.out.println("You have reach the limit \n");
			return;
		}
		
		System.out.println("Enter the type of vehicle to rent (e.g., Car, Bike): \n");
		String type=sc.next();
		int it=1;
		boolean ok=true;
		for(int i=0;i<Ve.length;i++) {
			
			if(Ve[i].getType().equals(type) && Ve[i].isAvailable()==true ) {
			System.out.print(it +".");
			Ve[i].printInfo();
			it++;
			ok=false;
	      }
			
	}
		while(ok) {
			System.out.println("Enter the type of vehicle to rent (e.g., Car, Bike): \n");
			String type2=sc.next();
			int it2=1;
			for(int i=0;i<Ve.length;i++) {
				
				if(Ve[i].getType().equals(type2) && Ve[i].isAvailable()==true ) {
				System.out.print(it2 +".");
				Ve[i].printInfo();
				it2++;
				ok=false;
		      
				}
				
		}
			
		}
		
		System.out.println("Enter registration number of the vehicle to rent: \n");
		String number=sc.next();
		System.out.println("Enter the number of rental days: \n ");
		int days=sc.nextInt();
	   Vehicle V=findVehicleByRegistrationNumber(Ve , number);
	   
		for(int i=0;i<Ve.length;i++) {
			if(Ve[i] == V) {
            Ve[i].setAvailable(false);
            break;
			}
		}

		customer=findCustomerById(Ct , id );
		if(customer != null ) {
			customer.rentVehicle(V, days);
		}
		else {
			System.out.println("Sorry , not found :( \n ");
			return;
		}
		
		System.out.println("Vehicle " + number + " rented successfully. \n");
	}
	
	public static void Choice5(Customer [] Ct , Vehicle []availableVehicles) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter customer ID : \n");
		int id=sc.nextInt();
		
		for(int i=0;i<Ct.length;i++) {
			// don't forget to use the searching method 
			if(Ct[i].getId() == id ) {
				if(!Ct[i].canRet()) {
					System.out.println("Sorry for that , but you don't have cars to return :( \n");
					break;
				}
				System.out.println("List of vehicles currently rented : \n");
				
				Ct[i].printVehicles();  
				
				System.out.println("Enter registration number of the vehicle to return: \n");
				
				
				String regNum=sc.next(); // D O D
				
				Vehicle V = Ct[i].getVehicle(regNum);
				
			if(V!=null) {
				Ct[i].returnVehicle(V);
				
				for(int j=0;j<availableVehicles.length;j++) {
				
					if(availableVehicles[j].regNumber().equals(regNum)) {
					
						availableVehicles[j].setAvailable(true);
						
						break;
					
					}
				
				}
				System.out.println("Vehicle "+ regNum +" returned successfully. \n");
			}
			else {
				System.out.println("Sorry it's not found \n");
			}
				break;
			}
		}
		
	}
	
	//********* Merge Sort ***********************//
	
	public static void mergeSort(Vehicle [] array , boolean ok) {
		
		int left = array.length / 2;
		int right = array.length - left ;
		if(array.length <= 1) return;
		 
		
		Vehicle [] leftArray = new Vehicle[left]; 
		Vehicle [] rightArray =new Vehicle[right];
		for(int i=0; i < left ;i++) {
			leftArray[i]=array[i];
		}
		for(int i=left , j=0 ; i < array.length ;i++ , j++) {
			rightArray[j]=array[i];
		}
		mergeSort(leftArray ,ok);
		mergeSort(rightArray , ok);
		merge(leftArray , rightArray , array , ok);
		
		
	}
	
	public static void merge(Vehicle [] left , Vehicle[] right , Vehicle[] arr , boolean ok) {
		
		int left_size=left.length;
		int right_size=right.length;
		
		int l=0 , r=0 , i=0;
		while(l < left_size && r < right_size ) {
			if(ok) {
				
			if(left[l].getRentalRatePerDay() < right[r].getRentalRatePerDay()) {
				arr[i]=left[l];
				i++;
				l++;
			}
			else {
				arr[i]=right[r];
				i++;
				r++;
			}
			}
			else {
				if(left[l].getType().compareTo(right[r].getType()) > 0 ) {
					arr[i]=left[l];
					i++;
					l++;
				}
				else {
					arr[i]=right[r];
					i++;
					r++;
				}
			}
			
		}
		
	while(l < left_size) {
		arr[i]=left[l];
		i++;
		l++;
	}
		while(r < right_size) {
			arr[i]=right[r];
			i++;
			r++;
		}
		
	}
	
	//********* Merge Sort ***********************//
	
	public static void displayVehiclesByPrice(Vehicle [] availableVehicles) {
		
		Vehicle [] copy_Vechicles=availableVehicles;
		
		mergeSort(copy_Vechicles , true);
		
		for(int i=0;i<copy_Vechicles.length;i++) {
			copy_Vechicles[i].printInfo();
		}
		
	}
	
	public static void displayVehiclesByType(Vehicle [] availableVehicles) {
		Vehicle [] copy_Vechicles=availableVehicles;
		
		mergeSort(copy_Vechicles , false);
		
		for(int i=0 ; i< copy_Vechicles.length; i++) {
			copy_Vechicles[i].printInfo();
		}
	
	}
	
	public static Customer findCustomerById(Customer [] customer , int customerId) {
		for(int i=0;i<customer.length;i++) {
			if(customer[i].getId() == customerId) {
				return customer[i];
			}
		}
		
		
		return null;
	}

	public static Vehicle findVehicleByRegistrationNumber(Vehicle[] vehicles , String regNumber) {
		
		for(int i=0;i<vehicles.length;i++) {
			if(vehicles[i].regNumber().equals(regNumber)) {
				return vehicles[i];
			}
		}
		
		
		return null;
	}
	
	

}
