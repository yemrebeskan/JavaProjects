package main;
import Customers.GoldMember;
import Customers.IndividualCustomer;
import Customers.PlatinumMember;
import Customers.SilverMember;
import Rental.CommercialRental;
import Rental.IndividualRental;
import Rental.Rental;

import java.util.ArrayList;
import java.util.Random;
/*the purpose of this class is to reveal statistics and create code for each rental and assign it to that rental */
//Façade
public class Company {
	private ArrayList<Rental> rentallist;

	public Company(ArrayList<Rental> rentallist) {
		super();
		this.rentallist = rentallist;
		generateCodes();
	}
	
	public void calculateAllRentalsPrice() {
		for(int i = 0;i < rentallist.size();i++) {
			rentallist.get(i).calculatePrice();
		}
	}
	//generating code
	private void generateCodes() {
		for(int i = 0;i < rentallist.size();i++) {
			int min = 1000000;
			int max = 9999999;
			int randomnumber = (int)((Math.random() * (max - min)) + min);
			rentallist.get(i).setCode(randomnumber);
		}
	}
	//Total number of cars rented
	private int getNumberOfRental() {
		return rentallist.size();
	}
	//Total number of commercial rentals
	private int getNumberOfCommercialRental() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i) instanceof CommercialRental) {
				total += 1;
			}
		}
		return total;
	}
	//Total number of commercial rental-month
	private int getTotalNumberOfMonths() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i) instanceof CommercialRental) {
				CommercialRental comren = (CommercialRental) rentallist.get(i);
				total += (int) comren.getRented_month();
			}
		}
		return total;
	}
	//Total number of individual rentals
	private int getNumberOfIndividualRental() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i) instanceof IndividualRental) {
				total += 1;
			}
		}
		return total;
	}
	//Total number of individual rental-day
	private int getTotalNumberOfDays() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i) instanceof IndividualRental) {
				IndividualRental inren = (IndividualRental) rentallist.get(i);
				total += (int) inren.getRented_day();
			}
		}
		return total;
	}
	//Total number of rentals of individual non-member customers
	private int getNumberOfNonMemberIndivudualCustomers() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i).getCustomer() instanceof IndividualCustomer) {
				IndividualCustomer individualcustomer = (IndividualCustomer) rentallist.get(i).getCustomer();
				if(!(individualcustomer.isMember())) {
					total += 1;
				}
			}
		}
		return total;
	}
	//Total number of rentals of individual member customers
	private int getNumberOfMemberIndivudualCustomers() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i).getCustomer() instanceof IndividualCustomer) {
				IndividualCustomer individualcustomer = (IndividualCustomer) rentallist.get(i).getCustomer();
				if(individualcustomer.isMember()) {
					total += 1;
				}
			}
		}
		return total;
	}
	//Total number of rentals of silver commercial customers
	private int getNumberOfRentalsOfSilverCommercialCustomers() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i).getCustomer() instanceof SilverMember) {
				total += 1;			
		}
			
	}
		return total;
}
	//Total number of rentals of platinum commercial customers
	private int getNumberOfRentalsOfPlatinumCommercialCustomers() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i).getCustomer() instanceof PlatinumMember) {
				total += 1;			
		}
			
	}
		return total;
}
	//Total number of rentals of gold commercial customers
	private int getNumberOfRentalsOfGoldCommercialCustomers() {
		int total = 0;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i).getCustomer() instanceof GoldMember) {
				total += 1;			
		}
			
	}
		return total;
}
	//display part
	public void display_Infos() {
		// " Rental Price " length --> 14
		System.out.println("			Welcome!");
		System.out.println("-".repeat(63));
		System.out.println("Total number of cars rented: " + getNumberOfRental());
		System.out.println("Total number of commercial rentals: " + getNumberOfCommercialRental());
		System.out.println("Total number of commercial rental-month: " + getTotalNumberOfMonths());
		System.out.println("Total number of individual rentals: " + getNumberOfIndividualRental());
		System.out.println("Total number of indivudual rental-day: " + getTotalNumberOfDays());
		System.out.println("Total number of rentals of individual non-member customers: " + getNumberOfNonMemberIndivudualCustomers());
		System.out.println("Total number of rentals of individual member customers: " + getNumberOfMemberIndivudualCustomers());
		System.out.println("Total number of rentals of silver commercial customers: " + getNumberOfRentalsOfSilverCommercialCustomers());
		System.out.println("Total number of rentals of gold commercial customers: " + getNumberOfRentalsOfGoldCommercialCustomers());
		System.out.println("Total number of rentals of platinum commercial customers: " + getNumberOfRentalsOfPlatinumCommercialCustomers());
		System.out.println("-".repeat(63));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------Individual Rentals--------------------------------------------");
		System.out.println("No | Rental Code | Customer ID | isMember | Number of Days |      Car Model      | Model Year | Rental Price |");
		System.out.println("-".repeat(110));
		System.out.println("-".repeat(110));
		int no = 1;
		for(int i = 0;i < rentallist.size();i++) {
			if(rentallist.get(i) instanceof IndividualRental) {
				IndividualRental inren = (IndividualRental) rentallist.get(i);
				if(inren.getCustomer() instanceof IndividualCustomer) {
					IndividualCustomer individualcus = (IndividualCustomer) inren.getCustomer();
					if(individualcus.isMember()) {
						if((int)inren.getRented_day() < 10) {
							System.out.println(" " + no +" |  " + inren.getCode() + "    | " + individualcus.getId() + "| " + "  Yes" + "    |       " 
									+(int)inren.getRented_day() + "        | " + inren.getCar().getModel() + " ".repeat(20 - inren.getCar().getModel().length()) + "|   " + (int)inren.getCar().getModelyear() + "     |"+ 
										"    " + (int)inren.getPrice() + " TL");
						} else {
							System.out.println(" " + no +" |  " + inren.getCode() + "    | " + individualcus.getId() + "| " + "  Yes" + "    |       " 
									+(int)inren.getRented_day() + "       | " + inren.getCar().getModel() + " ".repeat(20 - inren.getCar().getModel().length()) + "|   " + (int)inren.getCar().getModelyear() + "     |"+ 
										"    " + (int)inren.getPrice() + " TL");
						}
					}
					else {
						System.out.println(" " + no + " |  " + inren.getCode() + "    | " + individualcus.getId() + " |" + "   No" + "     |       " +(int)inren.getRented_day() + 
								"        | " + inren.getCar().getModel() + " ".repeat(20 - inren.getCar().getModel().length()) + "|   " + (int)inren.getCar().getModelyear() + "     |"+ "    " + (int)inren.getPrice() + " TL");
					}
					no++;
					
				}
			}
		}
		System.out.println("-".repeat(110));
		System.out.println("-".repeat(110));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------------------Commercial Rentals----------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("No | Rental Code | Customer ID | Customer Type | Number of Months |      Car Model      | Model Year | Rental Price |");
		System.out.println("-".repeat(117));
		no = 1;
		for(int i = 0; i < rentallist.size(); i++) {
			if(rentallist.get(i) instanceof CommercialRental) {
				CommercialRental comren = (CommercialRental) rentallist.get(i);
				if(comren.getCustomer() instanceof SilverMember) {
					SilverMember silmem = (SilverMember) comren.getCustomer();
					if ((int)comren.getRented_month() > 10) {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + silmem.getId() + "    | " + "Silver"  +  "        |        " 
								+(int)comren.getRented_month() + "        | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() + " TL");
					} else {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + silmem.getId() + "    | " + "Silver"  +  "        |        " 
								+(int)comren.getRented_month() + "         | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() + " TL");
					}
				}
				else if(comren.getCustomer() instanceof GoldMember) {
					GoldMember golmem = (GoldMember) rentallist.get(i).getCustomer();
					if ((int)comren.getRented_month() > 10) {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + golmem.getId() + "    | " + "Gold"  +  "          |        " 
								+(int)comren.getRented_month() + "        | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() + " TL");
					} else {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + golmem.getId() + "    | " + "Gold"  +  "        |        " 
								+(int)comren.getRented_month() + "         | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() + " TL");
				}
				}
				else if(comren.getCustomer() instanceof PlatinumMember) {
					PlatinumMember pilmem = (PlatinumMember) rentallist.get(i).getCustomer();
					if ((int)comren.getRented_month() > 10) {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + pilmem.getId() +"    | "+ "Platinum" +  "      |        " 
								+(int)comren.getRented_month() + "        | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() +" TL");
					} else {
						System.out.println(" " + no + " |  " + comren.getCode() + "    | " + pilmem.getId() +"    | "+ "Platinum" +  "      |        " 
								+(int)comren.getRented_month() + "         | " + comren.getCar().getModel() + " ".repeat(20 - comren.getCar().getModel().length()) + "|    " + (int)comren.getCar().getModelyear() + 
								"    |    " + (int)comren.getPrice() +" TL");
					}
				}
				no++;
			}
		}
		System.out.println("-".repeat(117));
		System.out.println("-".repeat(117));
	}
	
}