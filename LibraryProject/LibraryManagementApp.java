
public class LibraryManagementApp {
	public static void main(String[] args) {
		LibraryManagement Issues = ListMaker.creategeneralIssueList();
		Library mylibrary = ListMaker.createBooks();
		MemberLibrary memberlibrary = ListMaker.createMemberLibrary();
		LibraryQuery libraryquery = new LibraryQuery(Issues,mylibrary,memberlibrary);
		String s = libraryquery.findMostIssuedBook();
		String name = libraryquery.getMaxIssuedMemberName();
		String mostcopiedbook = libraryquery.findmostCopied();
		String fewestissuedname = libraryquery.getFewestIssuedMemberName();
		int mostprice = libraryquery.findMostPrice();
		String fewest_copied_book = libraryquery.find_fewest_copy();
		
		
		System.out.println("1)" + s);
		System.out.println("2)" + name);
		System.out.println("3)" + mostprice + " TL");
		System.out.println("4)" + mostcopiedbook);
		System.out.println("5)" + fewest_copied_book);
		System.out.println("6)" + fewestissuedname);
		
		
		
		
		
		
		
		
		
	}
}