
public class LibraryManagement {
	private  Issue[][] issueList;
	private  int size_Of_Array;

	public LibraryManagement(Issue[][] newlist, int length) { 	//Constructor
		issueList = newlist;
		size_Of_Array = length;
		
	}
	
	public  Issue[][] getIssueList(){	//To prevent privacy leak, We get copy of the all issue arrays by creating new ones with the same length,
		Issue [][] copiedList;				// within the two dimensional array.  //And return the copied one.
		copiedList = new Issue[3][];
		copiedList[0] = new Issue[issueList[0].length];
		copiedList[1] = new Issue[issueList[1].length];
		copiedList[2] = new Issue[issueList[2].length];
		for(int i = 0; i  < size_Of_Array;i++) {
			for(int j = 0; j < issueList[i].length;j++) {
				copiedList[i][j] = issueList[i][j];
			}
		}
		return copiedList;
	}

}
