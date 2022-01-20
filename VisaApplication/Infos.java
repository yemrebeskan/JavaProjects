
public class Infos {
	private String AppID;
	private String letter;

	public Infos(String appID,String letter) {
		super();
		this.letter = letter;
		AppID = appID;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getAppID() {
		return AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}
	
	
	
}
