package File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class FileIO {
	//This class is used to take data from "HW4_Rentals.csv" file and stores data in arraylist.
	public static ArrayList<String> getData() {

        ArrayList<String> arraylist = new ArrayList<String>();

        File selectedFile = new File("C://Users//X550V//Desktop//homework4//HW4_Rentals.csv");

        try {
            Scanner scan = new Scanner(selectedFile);
            while(scan.hasNextLine()) {
                arraylist.add(scan.nextLine());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arraylist;
    }
}
