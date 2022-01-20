
public class Issue {
	private int ID;
	private int member;
	private String book;
	private String IssueDate;
	private String returningDate;
	
	Issue(int new_ID,int new_member,String new_book,String new_IssueDate,String new_returningDate){
		ID = new_ID;
		member = new_member;
		book = new_book;
		IssueDate = new_IssueDate;
		returningDate = new_returningDate;
	}
	
	public int getID() {
		int copied_ID = ID;
		return copied_ID;
	}
	
	public int getMember() {
		int copied_member = member;
		return copied_member;
	}
	
	public String getBook() {
		return book;
	}
	
	public String getIssueDate() {
		return IssueDate;
		
	}
	
	public String returningDate() {
		return returningDate;
	}
}
