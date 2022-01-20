
public class Member {
	private String ID;
	private String name;
	private String email;
	private int ID2;
	
	
	Member(String iD2,String new_Name,String new_email){
		ID = iD2;
		name = new_Name;
		email = new_email;
		
	}
	Member(int new_ID,String new_Name,String new_email){
		ID2 = new_ID;
		name = new_Name;
		email = new_email;
	}

	public String getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	public int getIntID() {
		int copiedID = ID2;
		return copiedID;
	}
}
