
public class Library {
	private  Book[] books;
	private  int length;
	
	Library(Book[] newList,int length_Of_List){		//Constructor
		books = newList;
		length = length_Of_List;
		
	}
	
	
	public  Book[] getBooks() {
		Book[] copiedList = new Book[this.length];	//Copy of the "Book[]" array is created and returned to prevent privacy leak.
		for(int i = 0; i < length;i++) {					 
			copiedList[i] = this.books[i];
		}
		return copiedList;
	}
}
