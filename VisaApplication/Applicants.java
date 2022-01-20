import java.util.ArrayList;

public abstract class Applicants {
	private Photo appPhoto = new Photo(null, null, null,null);
	private Passport appPassport = new Passport(null, null, null,null);
	private ApplicantInfo appInfo = new ApplicantInfo(null,null, null);
	private FinancialStatus appstatus = new FinancialStatus(null, 0, 0,null);
	private Document appDoc = new Document(null, null, 0,null);
	private ArrayList<Document> documentlist= new ArrayList<>(); //one applicant has one or more document.
	public Applicants(Photo appPhoto, Passport appPassport, ApplicantInfo appInfo, FinancialStatus appstatus,
			ArrayList<Document> doclist) {
		super();
		this.appPhoto = appPhoto;
		this.appPassport = appPassport;
		this.appInfo = appInfo;
		this.appstatus = appstatus;
		this.documentlist = doclist;
	}
	public ArrayList<Document> getDocumentlist() {
		return documentlist;
	}
	public void setDocumentlist(ArrayList<Document> documentlist) {
		this.documentlist = documentlist;
	}
	public Photo getAppPhoto() {
		return appPhoto;
	}
	public void setAppPhoto(Photo appPhoto) {
		this.appPhoto = appPhoto;
	}
	public Passport getAppPassport() {
		return appPassport;
	}
	public void setAppPassport(Passport appPassport) {
		this.appPassport = appPassport;
	}
	public ApplicantInfo getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(ApplicantInfo appInfo) {
		this.appInfo = appInfo;
	}
	public FinancialStatus getAppstatus() {
		return appstatus;
	}
	public void setAppstatus(FinancialStatus appstatus) {
		this.appstatus = appstatus;
	}
	public Document getAppDoc() {
		return appDoc;
	}
	public void setAppDoc(Document appDoc) {
		this.appDoc = appDoc;
	}
	
	public boolean controlPassport() {
		try {
			String passport = appPassport.getPassportNum();
			if (controlValidation(passport)) { //control last digits and size
				if (controlExpirationDate()) { //control date
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}		
		}
		catch(NullPointerException e) {
			return false;		
		}	
	}
	//It should have 10 characters, it should start with P, last three characters should be digits
	private boolean controlLastDigits(String passport) {
		try {
			int length = passport.length();
			int number = Integer.parseInt(passport.substring(length - 3, length));
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
		
	}
	public boolean controlValidation(String passport) {
		if(passport.length() == 10) {
			if(passport.startsWith("P") && controlLastDigits(passport)) {	
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
		
	}
	//Expiration date should be at least 6 months later.
	public boolean controlExpirationDate() {
		try {
			Date exp_Date = appPassport.getExpirationDate();
			if(exp_Date.difOfMonths() >= 6) {
				return true;
			}
			else {
				return false;
			}
			//expiration date at least 6 months later
		}
		catch(NullPointerException e) {
			return false;
		}
	}
	
	
	public String outputPassport() { //this method will only be activated if the control part is wrong.
		try {
			String passport = appPassport.getPassportNum();
			if (controlValidation(passport)) {
				if (controlExpirationDate()) {
					return null;
				}
				else {
					return "Passport expiration date is not valid.";
				}
				
			}
			else {
				return "Passport is not valid";
			}
			
			
		}
		catch(NullPointerException e) {
			return "Applicant does not have a passport.";
			
		}
		
		
		
		
		
	}
	//Resolution should be between 600x600 and 1200x1200
	//The photo should be square
	private boolean detectValidationOfPhoto(String resolution) {
		String[] elements = resolution.split("x");
		if(elements[0].equals(elements[1]) && Integer.parseInt(elements[0]) > 600 &&
				Integer.parseInt(elements[1]) < 1200) {
			return true;
		}
		else {
			return false;
		}
	}
	//Accepted Positions are neutral face and natural smile
	private boolean control_Location(String loc) {
		if(loc.equals("Neutral Face") || loc.equals("Neutral Smile")) {
			return true;
		}
		return false;
	}
	public String outputPhoto() { //this method will only be activated if the control part is wrong.
		try {
			String res = appPhoto.getResolution();
			String loc = appPhoto.getPosition();
			if(detectValidationOfPhoto(res)) {
				if(control_Location(loc)) {
					return null;
				}
				else {
					return "Position photo is not valid.";
				}
			}
			else {
				return "Resolution of photo is not valid";
			}
			
		}catch(NullPointerException e){
			return "Applicant does not have a photo.";
		}
	}
	
	public boolean controlphoto() { 
		try {
			String res = appPhoto.getResolution();
			String loc = appPhoto.getPosition();
			if(detectValidationOfPhoto(res)) {
				if(control_Location(loc)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			
		}
		catch(NullPointerException e){ //control null 
			return false;
		}

}
	//abstract methods
	public abstract void updateStatus(); 
	
	public abstract String outputStatus(); //this method will only be activated if the control part is wrong.
		
	
	public abstract boolean controlFinancialStatus();
	
	public abstract String outputDoc(); //this method will only be activated if the control part is wrong.

	public abstract boolean controldocument() ;
	
	public abstract double control_duration();

	public abstract void playInfo();
		
	public abstract boolean isAccepted();
	
	public abstract String output_duration();
	
	
}
