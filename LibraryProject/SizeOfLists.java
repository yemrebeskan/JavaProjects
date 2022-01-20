import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SizeOfLists {
	public static  int count_Of_Items(String Filename) { //This method helps us find the number of lines of the file we will read, 
		int counter = 0;								//so we can create our arrays of this size.
		try{
			
			File myObj = new File(Filename);
			Scanner myReader = new Scanner(myObj);
			while(myReader.hasNextLine()) {
				String fileLine = myReader.nextLine();
				counter += 1;
			
				
			}						
			return counter;			//Returns the lines of file. When the file reading is over, we get that value.
		
		}
		catch(FileNotFoundException e){
			System.out.println("An error occured.");
			e.printStackTrace();
			return counter;
			
			}
		
		}
}