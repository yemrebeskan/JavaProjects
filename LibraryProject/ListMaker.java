public class ListMaker {
	public static Library createBooks() { //By this method, we fill the book array with the data taken from files.
		Book booklist1[] = FileIOBooks.FileReader("C:/javaodevleri/Homework 01/L1_Books.csv"); 
		Book booklist2[] = FileIOBooks.FileReader("C:/javaodevleri/Homework 01/L2_Books.csv");
		Book booklist3[] = FileIOBooks.FileReader("C:/javaodevleri/Homework 01/L3_Books.csv");
		Book[] b = ConcatenateArray(booklist1,booklist2,booklist3);
		Library mylibrary = new Library(b,b.length);		//This part creates library objec with wanted arguments.
		return mylibrary;
		
	}
	
	public static LibraryManagement creategeneralIssueList() { //By this method, we fill the issuelist array with the data taken from files.
		Issue[] issueList1 = FileIOIssue.FileReader("C:/javaodevleri/Homework 01/L1_Issues.csv");
		Issue[] issueList2 = FileIOIssue.FileReader("C:/javaodevleri/Homework 01/L2_Issues.csv");
		Issue[] issueList3 = FileIOIssue.FileReader("C:/javaodevleri/Homework 01/L3_Issues.csv");
		Issue [][] a;
		a = new Issue[3][];
		a[0] = new Issue[issueList1.length];
		a[1] = new Issue[issueList2.length];
		a[2] = new Issue[issueList3.length];
		a[0] = issueList1;
		a[1] = issueList2;
		a[2] = issueList3;
		LibraryManagement Issues = new LibraryManagement(a,a.length);
		return Issues;
		
		
	}
	public static Book[] ConcatenateArray(Book[] list1,Book[] list2,Book[] list3){ //This part combines all book lists into one list, and returns.
		int l1 = list1.length;
		int l2 = list2.length;
		int l3 = list2.length;
		Book[] generallist = new Book[l1 + l2 + l3];
		for(int i = 0;i < l1;i++) {
			generallist[i] = list1[i];
		}
		for(int i = l1, j = 0;i < l1 + l2;i++,j++) {
			generallist[i] = list2[j];
		}
		for(int i = l1 + l2, j = 0; i < l1 + l2 + l3;i++,j++) {
			generallist[i] = list3[j];
		}
		return generallist;
		
		
	}
	public static MemberLibrary createMemberLibrary() {// As it understood, this method fills the member array.
		Member[] memberlist = FileIOMember.readMemberFile("C:/javaodevleri/Homework 01/Members.csv");
		MemberLibrary memberlibrary = new MemberLibrary(memberlist,memberlist.length);
		return memberlibrary;
	}

	
}