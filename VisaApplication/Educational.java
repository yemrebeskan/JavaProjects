import java.util.ArrayList;

public class Educational extends Applicants {

	public Educational(Photo appPhoto, Passport appPassport, ApplicantInfo appInfo, FinancialStatus appstatus,
			ArrayList<Document> appDoc) {
		super(appPhoto, appPassport, appInfo, appstatus, appDoc);
		// TODO Auto-generated constructor stub
	}
	/*Income should be at least 1000$. Savings are related with the income, and 
	it is as follows:
	Income: 1000$-2000$ -> savings: 6000$
	Income: 2000$-3000$ -> savings: 3000$
	Income: Above 3000$ -> savings: Not necessary */
	@Override
	public boolean controlFinancialStatus() {
		try {
			int income = super.getAppstatus().getIncome();
			int savings = super.getAppstatus().getSavings();
			if(income <= 2000 && income >= 1000) {
				if(savings >= 6000) {
					return true;
				}
				else {
				}
			}
			else if(income >= 2000 && income <= 3000) {
				if(savings >= 6000) {
					return true;
				}
				else {
				}
			}
			else if(income > 3000) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(NullPointerException e) {
			return false;
		}
		return false;
	}
	//if control status is false,then this output will printed
	@Override
	public String outputStatus() {
		try {
			int income = super.getAppstatus().getIncome();
			int savings = super.getAppstatus().getSavings();
			if(income <= 2000 && income >= 1000) {
				if(savings >= 6000) {
					return null;
				}
				else {
					return "Applicant does not have a stable financial status.";
				}
			}
			else if(income >= 2000 && income <= 3000) {
				if(savings >= 6000) {
					return null;
				}
				else {
					return "Applicant does not have a stable financial status.";
				}
			}
			else if(income > 3000) {
				return null;
			}
			else {
				System.out.println("Applicant does not have a stable financial status.");
				return null;
			}
		}
		catch(NullPointerException e) {
			System.out.println("Applicant does not have financial status report.");
			return null;
		}
		
	}
	/* It is necessary to have a letter of acceptance. If educational application has 
	an invitation letter, necessary income and savings are halved */
	@Override
	public boolean controldocument() {
		try {
			ArrayList<Document> doclist = super.getDocumentlist();
			for(int i = 0;i < doclist.size();i++) {
				if(doclist.size() == 1) {
					if(doclist.get(i).equals("LA")) {
						return true;
					}
					else {
						return false;
					}
				}
				else if(doclist.size() > 1) {
					if(doclist.get(0).equals("LA") || doclist.get(1).equals("IL")) {
						if(doclist.get(0).equals("IL") || doclist.get(1).equals("IL")) {
							super.getAppstatus().setIncome(super.getAppstatus().getIncome() / 2);
							super.getAppstatus().setSavings(super.getAppstatus().getSavings() / 2);
							return true;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}catch(NullPointerException e) {	
			return false;
		}
		return false;
	}
	//if control doc is false,then this output will printed
	@Override
	public String outputDoc() {
		try {
			ArrayList<Document> doclist = super.getDocumentlist();
			for(int i = 0;i < doclist.size();i++) {
				if(doclist.size() == 1) {
					if(doclist.get(i).equals("LA")) {
					}
					else {
						return "Applicant does not have a letter of acceptance";
					}
				}
				else if(doclist.size() > 1) {
					if(doclist.get(0).equals("LA") || doclist.get(1).equals("IL")) {
						if(doclist.get(0).equals("IL") || doclist.get(1).equals("IL")) {
							super.getAppstatus().setIncome(super.getAppstatus().getIncome() / 2);
							super.getAppstatus().setSavings(super.getAppstatus().getSavings() / 2);
						}
					}
					else {
						return "Applicant does not have a letter of acceptance";
					}
				}
				else {
					return "Applicant does not have a letter of acceptance";
				}
			}
		}catch(NullPointerException e) {	
			return "Applicant does not have a letter of acceptance";
		}
		return null;
	}
	//control visa duration
	/* The duration can be 1 years, 2 years, and 4 years. It will be according to 
	duration in the letter of acceptance and the passport expiration date. The visa duration 
	should be higher than the duration in the letter of acceptance if applicant has a suitable 
	passport expiration date*/
	@Override
	public double control_duration() {
		if(isAccepted()) {
			double durationLetter = super.getAppDoc().getDuration();
			int duration;
			Date exp_Date = super.getAppPassport().getExpirationDate();
			int exp_month = exp_Date.difOfMonths();
			if(exp_month < durationLetter) {
				if(exp_month < 12) {
					return 0;
				}
				else if(exp_month <= 36 && exp_month >= 24) {
					duration = 2;
					return duration;
				}
				else if(exp_month >= 12 && exp_month < 24){
					duration = 1;
					return duration;
				}
				else {
					duration = 4;
					return duration;
				}
			}
			else if(exp_month >= durationLetter) {
				double year = durationLetter / 12;
				double floor_year = Math.floor(year);
				if(floor_year < 4 && floor_year >= 2) {
					duration = 2;
					return duration;
				}
				else if(floor_year < 2 && floor_year >= 1) {
					duration = 1;
					return duration;
				}
				else if(floor_year < 1) {
					return 0;
				}
				else {
					return 4;
				}
			}
			
		}
		return 0;
	}
	
	@Override
	public void playInfo() {
		if(isAccepted()) {
			if(control_duration() <= 0) {
				System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
						+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
								+ " Rejected, Reason: " + (output_duration()));
			}
			else {
				System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
						+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
								+ "Accepted, Visa Duration:" + output_duration() );
			}
			
		}
		else {
			if(super.controlPassport()) {
				if(super.controlphoto()) {
					if(controlFinancialStatus()) {
						if(controldocument()) {
							
						}
						else {
							System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
									+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
											+ " Rejected, Reason: " + (outputDoc()));
						}
					}
					else {
						System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
								+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
										+ " Rejected, Reason: " + (outputStatus()));;
					}
				}
				else {
					System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
							+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
									+ " Rejected, Reason: " + (super.outputPhoto()));
					
				}
			}
			else {
				System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
						+ super.getAppInfo().getApplicantName() + ", Visa Type: Worker, Status:"
								+ " Rejected, Reason: " + (super.outputPassport()));
				
			}
		}
	}
	public boolean isAccepted() {
		if(controldocument() && controlFinancialStatus() && super.controlPassport() && super.controlphoto()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	//if control doc has used more than one, the status of educational updated more than one.
	//this situation should be controlled.
	@Override
	public void updateStatus() {
		try {
			if(super.getAppDoc().getDocType().equals("IL")) {
				super.getAppstatus().setIncome(super.getAppstatus().getIncome() * 2);
				super.getAppstatus().setSavings(super.getAppstatus().getSavings() * 2);
			}
		}catch(NullPointerException e) {	
		}
		
	}

	@Override
	public String output_duration() {
		if(control_duration() > 0) {
			double duration = control_duration();
			int intValue = (int) (duration);
			if(intValue == 6) {
				return String.valueOf(intValue) + " months";
			}
			else {
				return String.valueOf(intValue) + " years";
			}
		}
		else {
			return "Passport expiration date is not valid";
		}
		}
	

}
