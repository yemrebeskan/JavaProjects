import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOBooks {
	public static Book[] FileReader(String Filename) {
		Book listOfBooks[] = new Book[SizeOfLists.count_Of_Items(Filename)];
		try{
			int counter = 0;
			File myObj = new File(Filename);
			Scanner myReader = new Scanner(myObj);
			while(myReader.hasNextLine()) {
				String fileLine = myReader.nextLine();
				String[] line = fileLine.split(","); /*implemented split methods.*/
				String ID = line[0];
				String title = line[1];
				String author = line[2];
				String publisher = line[3];
				int edition = Integer.parseInt(line[4]);
				String genre = line[5];
				int quantity = Integer.parseInt(line[6]);
				Book newBook = new Book(ID,title,author,publisher,edition,genre,quantity);/*created book object.*/	
				listOfBooks[counter] = newBook; /*added new object to list.*/
				counter += 1;
				
			}
			return listOfBooks;
		}
		catch(FileNotFoundException e){
			System.out.println("An error occured.");
			e.printStackTrace();
			return listOfBooks;
			
		}
		
	}
}
