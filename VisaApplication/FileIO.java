import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class FileIO {
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

