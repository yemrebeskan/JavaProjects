package main;
import java.util.ArrayList;

import Car.Car;
import Customers.Customer;
import Customers.GoldMember;
import Customers.IndividualCustomer;
import Customers.PlatinumMember;
import Customers.SilverMember;
import File.FileIO;
import Rental.CommercialRental;
import Rental.IndividualRental;
import Rental.Rental;
//This clas is used to take data from "HW4_Rentals.csv" file and creating proper objects 
//Then it storages datas into the rental arraylist and string arraylist.
public class Creator {
	public static ArrayList<Rental> createRentals() throws NotAppropiateException{
		ArrayList<String> filelist = FileIO.getData();
		ArrayList<Rental> rentalList = new ArrayList<>();
		for(int i = 0;i < filelist.size();i++) {
			String[] elements = filelist.get(i).split(",");
			if(elements[0].equals("Individual")) {
				try {
					if(elements[1].length() != 11 && elements[1].length() != 12) {
						throw new NotAppropiateException();
					}
					Customer customer = new IndividualCustomer(elements[1]);
					double rented_day = Double.parseDouble(elements[2]);
					String carmodel = elements[3];
					double year = Double.parseDouble(elements[4]);
					double basePrice = Double.parseDouble(elements[5]);
					Car car = new Car(year,carmodel,basePrice);
					Rental indrental = new IndividualRental(customer,car,rented_day); //Creating Car, Individual Customer, Individual Rental objects.
					rentalList.add(indrental);
				}catch(NotAppropiateException e) {
					System.out.println(e.getMessage());
				}
					
			}
			else if(elements[0].equals("Commercial")) { 
				try {
					if(elements[1].length() != 8) {
						throw new NotAppropiateException();
					}
					if(elements[1].startsWith("G")) {
						Customer customer = new GoldMember(elements[1]);
						double rented_month = Double.parseDouble(elements[2]);
						String carmodel = elements[3];
						double year = Double.parseDouble(elements[4]);
						double basePrice = Double.parseDouble(elements[5]);
						Car car = new Car(year,carmodel,basePrice);
						Rental comRental = new CommercialRental(customer,car,rented_month); //Creating Car,Gold Member Customer, Commercial Rental objects.
						rentalList.add(comRental);
					}
					else if(elements[1].startsWith("P")) { //Creating Car, Platinum Member Customer, Commercial Rental objects.
						Customer customer = new PlatinumMember(elements[1]);
						double rented_month = Double.parseDouble(elements[2]);
						String carmodel = elements[3];
						double year = Double.parseDouble(elements[4]);
						double basePrice = Double.parseDouble(elements[5]);
						Car car = new Car(year,carmodel,basePrice);
						Rental comRental = new CommercialRental(customer,car,rented_month);
						rentalList.add(comRental);
					}
					else if(elements[1].startsWith("S")) { //Creating Car, Silver Member Customer, Commercial Rental objects.
						Customer customer = new SilverMember(elements[1]);
						double rented_month = Double.parseDouble(elements[2]);
						String carmodel = elements[3];
						double year = Double.parseDouble(elements[4]);
						double basePrice = Double.parseDouble(elements[5]);
						Car car = new Car(year,carmodel,basePrice);
						Rental comRental = new CommercialRental(customer,car,rented_month);
						rentalList.add(comRental);
					}
				}catch(NotAppropiateException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
		return rentalList;
	}
	
}
