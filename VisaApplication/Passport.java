
public class Passport extends Infos {
	private String passportNum;
	private Date expirationDate;
	public Passport(String appID, String passportNum, Date expirationDate,String letter) {
		super(appID,letter);
		this.passportNum = passportNum;
		this.expirationDate = expirationDate;
	}
	public String getPassportNum() {
		return passportNum;
	}
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
}
