import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileIOIssue {
	public static Issue[] FileReader(String FileName) {
		Issue[] issueList = new Issue[SizeOfLists.count_Of_Items(FileName)];
		try {
			int counter = 0;
			File myobj = new File(FileName);
			Scanner myReader = new Scanner(myobj);
			while(myReader.hasNextLine()) {
				String fileline = myReader.nextLine();
				String[] line = fileline.split(","); /*implemented split method.*/
				int ID = Integer.parseInt(line[0]);
				int member = Integer.parseInt(line[1]);
				String book = line[2];
				String IssueDate = line[3];
				String returningDate = line[4];
				Issue new_issue = new Issue(ID,member,book,IssueDate,returningDate);/*created issue object*/
				issueList[counter] = new_issue;/*added new issue.*/
				counter += 1;
			
			}
			return issueList;
		}catch(FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
			return issueList;
		}
	}

}
