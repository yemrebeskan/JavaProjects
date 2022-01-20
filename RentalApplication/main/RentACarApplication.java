package main;
import java.util.ArrayList;

import File.FileIO;
import Rental.Rental;

public class RentACarApplication {
	public static void main(String[] args) throws NotAppropiateException {
		ArrayList<Rental> rentals = Creator.createRentals();
		Company company = new Company(rentals);
		company.calculateAllRentalsPrice();
		company.display_Infos();
	}
}
