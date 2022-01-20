
public class Book {
	private String id;
	private String title;
	private String Author;
	private String publisher;
	private int edition;
	private String genre;
	private int quantity;
	
	Book(String new_id,String new_title,String new_Author,String new_publisher,int new_edition,String new_genre,int new_Quantity){
		id = new_id;
		title = new_title;
		Author = new_Author;
		publisher = new_publisher;
		edition = new_edition;
		genre = new_genre;
		quantity = new_Quantity;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return Author;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getEdition() {
		int copyEdition;
		copyEdition = edition;
		return copyEdition;
	}
	public String getGenre() {
		return genre;
	}
	public int getQuantity() {
		int copyQuantity;
		copyQuantity = quantity;
		return copyQuantity;
	}
}
