import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {												//Our class used to get data from csv file.
	public static ArrayList<String> FileReader(String Filename) {
		ArrayList<String> arraylist = new ArrayList<>();
		try{
				
			File myObj = new File(Filename);
			Scanner myReader = new Scanner(myObj);
			while(myReader.hasNextLine()) {
				String fileLine = myReader.nextLine();
				arraylist.add(fileLine); /*added new object to list.*/ 
					
						
			}
			return arraylist;
		}
		catch(FileNotFoundException e){
			System.out.println("An error occured.");
			e.printStackTrace();
			return arraylist;
					
		}
				
	}
}

