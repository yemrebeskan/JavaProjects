import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOMember {
	public static Member[] readMemberFile(String Filename) {
		Member[] memberlist = new Member[SizeOfLists.count_Of_Items(Filename)];
		try {
			int counter = 0;
			File myobj = new File(Filename); 
			Scanner myReader = new Scanner(myobj);
			while(myReader.hasNextLine()) {
				String fileLine = myReader.nextLine();
				String[] line = fileLine.split(","); /*implemented split method.*/
				if(counter == 0) { /*if in first loop it is in first firstline*/ 
					String ID = line[0]; 
					String name = line[1];
					String email = line[2];
					Member new_member = new Member(ID,name,email);/*created member class*/
					memberlist[counter] = new_member;/*added member list*/
					counter += 1;
				}
				else {
					int ID = Integer.parseInt(line[0]);
					String name = line[1];
					String email = line[2];
					Member new_member = new Member(ID,name,email);
					memberlist[counter] = new_member;		
					counter += 1;
				}
				
			}
			return memberlist;
			
		}catch(FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
			return memberlist;
			
		}
	}
	
}
