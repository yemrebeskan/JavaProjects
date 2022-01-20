
public class LibraryQuery {
	
	private  LibraryManagement Issues;
	private  Library mylibrary;
	private  MemberLibrary memberlibrary;
	
	LibraryQuery(LibraryManagement new_Issues,Library new_library,MemberLibrary memberslibrary){
		Issues = new_Issues;
		mylibrary = new_library;
		memberlibrary = memberslibrary;
	}
	
	
	
	
	public String findMostIssuedBook() {
		String BookID = findMaxIssuedBook();
		Book[] booklist = this.mylibrary.getBooks();
		for(int i = 0;i < booklist.length;i++) {
			if(BookID.equals(booklist[i].getId())) {
				return booklist[i].getTitle();
			}
		}
		return null ;
		
		
		
	}
	private String findMaxIssuedBook() {
		Issue [][] issuelist = this.Issues.getIssueList();
		int size = 0;
		for(int i = 0;i < 3;i++) {
			size += issuelist[i].length;
		}
		String[] variables = new String[size * 2];/*that list contains book name and it's count.*/ 
		int index = 0;
		int real_size = 0;
		int max_Count = 0;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < issuelist[i].length;j++) { /*find the number of books for every object */
				int count = 0; /*number of each book*/
				
				for(int k = 0; k <3;k++) {
					for(int l = 0;l < issuelist[k].length;l++) {
						if(issuelist[i][j].getBook().equals(issuelist[k][l].getBook()) ) {
							count += 1; 
						}
					}
				}
				if(count > max_Count) {
					max_Count = count;
					variables[index] = issuelist[i][j].getBook();
					String s = Integer.toString(max_Count);
					variables[index + 1] = s;
					index += 2;
					real_size += 2;
				}
				
		
		
			}
	
		}
		return variables[real_size - 2]; /*return max number of book's ID and type is string.*/
	}
	
	
	
	
	public String getMaxIssuedMemberName() {
		int ID = this.findIDofMembersIssue();
		Member[] memberlist = memberlibrary.getMemberList();
		for(int i = 0;i < memberlist.length;i++) {
			if(i > 0) {
				if(memberlist[i].getIntID() == ID ) {
					return memberlist[i].getName(); /*find the member name.*/
				}
			}
		}
		return null;
	}
	
	public String getFewestIssuedMemberName() {
		int ID = findIDoffewestMembersIssue();
		Member[] memberlist = this.memberlibrary.getMemberList();
		for(int i = 0;i < memberlist.length;i++) {
			if(i > 0) {
				if(memberlist[i].getIntID() == ID ) {
					return memberlist[i].getName(); /*find the member name.*/
				}
			}
		}
		return null;
		
	}
	
	
	
	
	
	
	private int findIDofMembersIssue() { /*same algorithm with find max number of book.*/
		Issue [][] issuelist = this.Issues.getIssueList();
		int size = 0;
		for(int i = 0;i < 3;i++) {
			size += issuelist[i].length;
		}
		int[] variables = new int[size * 2];
		int index = 0;
		int real_size = 0;
		int max_Count = 0;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < issuelist[i].length;j++) {/*find the number of member for every object */
				int count = 0; /*number of member.*/
				
				for(int k = 0; k <3;k++) {
					for(int l = 0;l < issuelist[k].length;l++) {
						if(issuelist[i][j].getMember() == issuelist[k][l].getMember()) {
							count += 1;
						}
					}
				}
				if(count > max_Count) {
					max_Count = count;
					variables[index] = issuelist[i][j].getMember();
					variables[index + 1] = max_Count;
					index += 2;
					real_size += 2;
				}
				
		
		
			}
	
		}
		return variables[real_size - 2];
	}
	
	
	public String findmostCopied() {
		int max_copy = 0;
		Book[] booklist = this.mylibrary.getBooks();
		int[] quantitylist = new int[booklist.length];
		for(int i = 0;i < booklist.length;i++) {
			if(booklist[i].getQuantity() > max_copy) { /*compare the quantities.*/
				max_copy = booklist[i].getQuantity();
			}
			
		}
		for(int i = 0;i < booklist.length;i++) {
			if(booklist[i].getQuantity() == max_copy) {
				return booklist[i].getTitle();
			}
		}
		return null;
		
		
	}
	
	
	
	private int findIDoffewestMembersIssue() {/*same algorithm with find max number of book.*/
		Issue [][] issuelist = this.Issues.getIssueList();
		int size = 0;
		for(int i = 0;i < 3;i++) {
			size += issuelist[i].length;
		}
		int[] variables = new int[size * 2];
		int index = 0;
		int real_size = 0;
		int min_Count = 100000;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < issuelist[i].length;j++) { /*find the count of members for each issued member*/
				int count = 0;
				
				for(int k = 0; k <3;k++) {
					for(int l = 0;l < issuelist[k].length;l++) {
						if(issuelist[i][j].getMember() == issuelist[k][l].getMember()) {
							count += 1;
						}
					}
				}
				if(count < min_Count) { /*updating minimum count.*/
					min_Count = count;
					variables[index] = issuelist[i][j].getMember();
					variables[index + 1] = min_Count;
					index += 2;
					real_size += 2;
				}
				
		
		
			}
	
		}
		return variables[real_size - 2];
	}
	
	private static double calculatedPrice(double difference) {
		double price = 0;
		double interest = 0.5;
		if(difference > 14) {
			price = (difference - 14) * interest; /*if issue day pas 14 it will be price */
		}
		else {
			price = -1;
		}
		return price;
	}
	
	
	
	public int findMostPrice() {
		Issue[][] issuelist = this.Issues.getIssueList();
		int size = 0;
		int max_Price = 0;
		for(int i = 0;i < 3;i++) {
			size += issuelist[i].length;
		}
		double day_difference = 0;
		double[] pricelist = new double[size]; /*create price list for every issued books.*/
		
		for(int i = 0;i < 3;i++) {
			for(int j = 0; j < issuelist[i].length;j++) {
				
				String[] issuedate = issuelist[i][j].getIssueDate().split("-"); /*separate with - for create day,month,year*/		
				int issueday = Integer.parseInt(issuedate[0]);
				String issuemonth = issuedate[1];
				int issueyear = Integer.parseInt(issuedate[2]);
				Date date1 = new Date(issueday,issuemonth,issueyear); /*create issued date*/
				int day1 = date1.calculateDayOfYear();		
				String[] returningdate = issuelist[i][j].returningDate().split("-");
				int returningday = Integer.parseInt(returningdate[0]);
				String returningmonth = returningdate[1];
				int returningyear = Integer.parseInt(returningdate[2]);
				Date date2 = new Date(returningday,returningmonth,returningyear); /*created returning date.*/
				int day2 = date2.calculateDayOfYear();	/*It is a method showing which day of that date from that diary.*/		
				int difference = day2 - day1;		
				int price = (int) calculatedPrice(difference);
				if(price > max_Price) { /* update max price */
					max_Price = price;
				}
				
			}
		}
		
		
		return max_Price;
	}
	private Book[] controlIssue() { /* control issue list contains that book or not */
		
		
		Book[] booklist = this.mylibrary.getBooks();
		Issue[][] issuelist = Issues.getIssueList();
		int size = 0;
		int max_Price = 0;
		int index = 0;
		for(int i = 0;i < booklist.length;i++) {
			for(int j = 0;j < 3;j++) {
				for(int k = 0;k < issuelist[j].length;k++) {
					if(issuelist[j][k].getBook().equals(booklist[i].getId())) {	/* is book in issue list */				
						index += 1; /* index is required for new list's size. */
					}
				}
			}
			
		}
		
		Book[] issueBook =new Book[index]; /* that list contains issued books. */	
		index = 0;
		for(int i = 0;i < booklist.length;i++) {
			for(int j = 0;j < 3;j++) {
				for(int k = 0;k < issuelist[j].length;k++) {
					if(issuelist[j][k].getBook().equals(booklist[i].getId())) {
						issueBook[index] = booklist[i];
						
						index += 1;
					}
				}
			}
			
		}
		return issueBook;
	}
	
	public String find_fewest_copy() {
		Book[] issuedBooks = this.controlIssue();
		int fewest_copy = issuedBooks[0].getQuantity();
		for(int i = 0;i < issuedBooks.length;i++) {
			if(issuedBooks[i].getQuantity() < fewest_copy) {
				
				fewest_copy = issuedBooks[i].getQuantity(); /* update fewest copy */
			}
		}
		for(int i = 0;i < issuedBooks.length;i++) {
			if(issuedBooks[i].getQuantity() == fewest_copy) {
				return issuedBooks[i].getTitle();
			}
		}
		return null;
		
	}
	
	
	
	
}
		
