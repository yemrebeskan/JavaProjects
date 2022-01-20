import java.util.ArrayList;

public class Immigrant extends Applicants {

	public Immigrant(Photo appPhoto, Passport appPassport, ApplicantInfo appInfo, FinancialStatus appstatus,
			ArrayList<Document> appDoc) {
		super(appPhoto, appPassport, appInfo, appstatus, appDoc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String outputStatus() {
		try {
			int savings = super.getAppstatus().getSavings();
			String card = super.getDocumentlist().get(0).getDocType();
			if(card.equals("GC")) {
				if(savings > 4000) {
					return null;
				}
				else {
					return "Applicant does not have a stable financial status.";		
				}
			}
			else {
				if(savings > 50000) {	
					return null;
				}
				else {
					return "Applicant does not have a stable financial status.";			
				}
			}
		}catch(NullPointerException e){
			return "Applicant does not have financial status report.";
		}
	}
	/*No income needed. Savings should be at least 4000$ with a green card; 
	savings should be at least 50000$ without a green card. */
	@Override
	public boolean controlFinancialStatus() {
		try {
			int savings = super.getAppstatus().getSavings();
			String card = super.getDocumentlist().get(0).getDocType();
			if(card.equals("GC")) {
				if(savings > 4000) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(savings > 50000) {
					return true;
				}
				else {
					return false;
				}
			}
			
		}
		catch(NullPointerException e) {
			return false;
		}
	}
	/*It is not necessary to have a document, financial status criteria change 
	according to having a green card. If immigrant application has an invitation letter, necessary 
	income and savings are halved.*/
	@Override
	public boolean controldocument() {
		try {
			if(super.getDocumentlist().get(0).getDocType().equals("IL")) {
				super.getAppstatus().setIncome(super.getAppstatus().getIncome()/2);
				super.getAppstatus().setSavings(super.getAppstatus().getSavings()/2);
				return true;
			}
			else {
				return true;
			}
			
		}catch(NullPointerException e) {
			return false;
		}
		
	}
	@Override
	public String outputDoc() {
		try {
			if(super.getDocumentlist().get(0).getDocType().equals("IL")) {
				return null;
			}
			else {
				return null;
			}
			
		}catch(NullPointerException e) {
			return "Applicant does not have a letter of acceptance";
		}
	}
	//It will be permanent
	@Override
	public double control_duration() {
		return 0;
		// TODO Auto-generated method stub
	
	}

	@Override
	public void playInfo() {
		if(isAccepted()) {
			System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
					+ super.getAppInfo().getApplicantName() + ", Visa Type: Immigrant, Status:"
							+ "Accepted, Visa Duration:" + output_duration() );
		}
		else {
			if(super.controlPassport()) {
				if(super.controlphoto()) {
					if(controlFinancialStatus()) {
						if(controldocument()) {
							
						}
						else {
							System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
									+ super.getAppInfo().getApplicantName() + ", Visa Type: Immigrant, Status:"
											+ " Rejected, Reason: " + (outputDoc()));
						}
					}
					else {
						System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
								+ super.getAppInfo().getApplicantName() + ", Visa Type: Immigrant, Status:"
										+ " Rejected, Reason: " + (outputStatus()));;
					}
				}
				else {
					System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
							+ super.getAppInfo().getApplicantName() + ", Visa Type: Immigrant, Status:"
									+ " Rejected, Reason: " + (super.outputPhoto()));
					
				}
			}
			else {
				System.out.println("Applicant ID: " + super.getAppInfo().getAppID() + ", Name:"
						+ super.getAppInfo().getApplicantName() + ", Visa Type: Immigrant, Status:"
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
		return " Permanent";
	}
}
