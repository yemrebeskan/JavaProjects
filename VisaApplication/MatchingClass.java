import java.util.ArrayList;


public class MatchingClass {
	public static ArrayList<String> sortedArray(){
		ArrayList<String> myarraylist = FileIO.FileReader("C:/Users/X550V/Desktop/homework2/HW2_ApplicantsInfo.csv");
		int size = myarraylist.size();
		listsorting.sortArray(myarraylist, size);
		return myarraylist;
	}
	//create tourist array
	public static ArrayList<Tourist> createTouristArray() {
		ArrayList<String> myarraylist = sortedArray(); //sorted 
		ArrayList<Tourist> touristlist = new ArrayList<>();
		int index;
		int lastIndex = 0;
		while(true) {
			if(myarraylist.get(lastIndex).split(",")[1].startsWith("11")) {
				lastIndex += 1;
			}
			else {
				break;
			}
			
		}
		ArrayList<Document> doclist = new ArrayList<>();
		String ID = myarraylist.get(0).split(",")[1];
		Tourist newTourist = new Tourist(null, null, null, null, null); //create new Tourist
		for(index = 0;index < lastIndex + 1;index++) {
			
			String[] line = myarraylist.get(index).split(",");
			
			if(line[1].equals(ID)) {
				Infos newInfo = firstElementControl(line);
				if(newInfo.getLetter().equals("P")) {
					Photo newPhoto = (Photo) newInfo; //casting
					newTourist.setAppPhoto(newPhoto);
					
				}
				else if(newInfo.getLetter().equals("S")) {
					Passport newPassport = (Passport) newInfo;
					newTourist.setAppPassport(newPassport);
					
				}
				else if(newInfo.getLetter().equals("A")) {
					ApplicantInfo newAppInfo = (ApplicantInfo) newInfo;
					newTourist.setAppInfo(newAppInfo);
					
				}
				else if(newInfo.getLetter().equals("F")) {
					FinancialStatus newAppStatus = (FinancialStatus) newInfo;
					newTourist.setAppstatus(newAppStatus);
				}
				else if(newInfo.getLetter().equals("D")) {
					Document newDocument = (Document) newInfo;
					doclist.add(newDocument);
					newTourist.setDocumentlist(doclist);
				}
			}
			
			else {
				//New infos is added until the applicant's id changes
				touristlist.add(newTourist);
				doclist = new ArrayList<>();
				newTourist = new Tourist(null, null, null, null, null);
				ID = line[1];
				index -= 1;
				
			}
			
			
		}
		
		return touristlist;
		
		
		
		
	}
	//create worker array
	public static ArrayList<Worker> createWorkerArray() {
		ArrayList<String> myarraylist = sortedArray();
		ArrayList<Worker> workerlist = new ArrayList<>();
		int firstindex = 0;
		for(int i = 0;i < myarraylist.size();i++) {
			if(myarraylist.get(i).split(",")[1].startsWith("11")) {
				firstindex += 1;
			}
		}
		int index;
		int lastIndex = firstindex;
		while(true) {
			if(myarraylist.get(lastIndex).split(",")[1].startsWith("23")) {
				lastIndex += 1;
			}
			else {
		
				break;
			}
		}
		ArrayList<Document> doclist = new ArrayList<>();
		String ID = myarraylist.get(firstindex).split(",")[1];
		Worker newWorker = new Worker(null, null, null, null, null);
		for(index = firstindex;index < lastIndex + 1;index++ ) {
			String[] line = myarraylist.get(index).split(",");
			if(line[1].equals(ID)) {
				Infos newInfo = firstElementControl(line);
				if(newInfo.getLetter().equals("P")) {
					Photo newPhoto = (Photo) newInfo;
					newWorker.setAppPhoto(newPhoto);
				}
				else if(newInfo.getLetter().equals("S")) {
					Passport newPassport = (Passport) newInfo;
					newWorker.setAppPassport(newPassport);
				}
				else if(newInfo.getLetter().equals("A")) {
					ApplicantInfo newAppInfo = (ApplicantInfo) newInfo;
					newWorker.setAppInfo(newAppInfo);
				}
				else if(newInfo.getLetter().equals("F")) {
					FinancialStatus newAppStatus = (FinancialStatus) newInfo;
					newWorker.setAppstatus(newAppStatus);
				}
				else if(newInfo.getLetter().equals("D")) {
					Document newDocument = (Document) newInfo;
					doclist.add(newDocument);
					newWorker.setDocumentlist(doclist);
				}
			}
			else {
				workerlist.add(newWorker);
				ID = line[1];
				doclist = new ArrayList<>();
				newWorker = new Worker(null, null, null, null, null);
				index -= 1;
			}
			
		}
		return workerlist;
		
	}
	
	public static ArrayList<Educational> createEducationalArray() {
		ArrayList<String> myarraylist = sortedArray();
		ArrayList<Educational> educationallist = new ArrayList<>();
		int firstindex = 0;
		for(int i = 0;i < myarraylist.size();i++) {
			if((myarraylist.get(i).split(",")[1].startsWith("11") || myarraylist.get(i).split(",")[1].startsWith("23"))) {
				firstindex += 1;
			}
		}
		int index;
		int lastIndex = firstindex;
		while(true) {
			if(myarraylist.get(lastIndex).split(",")[1].startsWith("25")) {
				lastIndex += 1;
			}
			else {
		
				break;
			}
		}
		ArrayList<Document> doclist = new ArrayList<>();
		String ID = myarraylist.get(firstindex).split(",")[1];
		Educational newEducational = new Educational(null, null, null, null, null);
		for(index = firstindex;index < lastIndex + 1;index++ ) {
			String[] line = myarraylist.get(index).split(",");
			if(line[1].equals(ID)) {
				Infos newInfo = firstElementControl(line);
				if(newInfo.getLetter().equals("P")) {
					Photo newPhoto = (Photo) newInfo;
					newEducational.setAppPhoto(newPhoto);
				}
				else if(newInfo.getLetter().equals("S")) {
					Passport newPassport = (Passport) newInfo;
					newEducational.setAppPassport(newPassport);
				}
				else if(newInfo.getLetter().equals("A")) {
					ApplicantInfo newAppInfo = (ApplicantInfo) newInfo;
					newEducational.setAppInfo(newAppInfo);
				}
				else if(newInfo.getLetter().equals("F")) {
					FinancialStatus newAppStatus = (FinancialStatus) newInfo;
					newEducational.setAppstatus(newAppStatus);
				}
				else if(newInfo.getLetter().equals("D")) {
					Document newDocument = (Document) newInfo;
					doclist.add(newDocument);
					newEducational.setDocumentlist(doclist);
				}
			}
			else {
				educationallist.add(newEducational);
				ID = line[1];
				doclist = new ArrayList<>();
				newEducational = new Educational(null, null, null, null, null);
				index -= 1;
			}
			
		}
		return educationallist;
		
	}
	
	public static ArrayList<Immigrant> createImmýgrantArray() {
		ArrayList<String> myarraylist = sortedArray();
		ArrayList<Immigrant> immigrantlist = new ArrayList<>();
		int firstindex = 0;
		for(int i = 0;i < myarraylist.size();i++) {
			if(!(myarraylist.get(i).split(",")[1].startsWith("30"))) {
				firstindex += 1;
			}
		}
		int index;
		int lastIndex = myarraylist.size() - 1 ;
		ArrayList<Document> doclist = new ArrayList<>();
		String ID = myarraylist.get(firstindex).split(",")[1];
		Immigrant newImmýgrant = new Immigrant(null, null, null, null, null);
		for(index = firstindex;index < lastIndex + 1;index++ ) {
			String[] line = myarraylist.get(index).split(",");
			if(line[1].equals(ID)) {
				Infos newInfo = firstElementControl(line);
				if(newInfo.getLetter().equals("P")) {
					Photo newPhoto = (Photo) newInfo;
					newImmýgrant.setAppPhoto(newPhoto);
				}
				else if(newInfo.getLetter().equals("S")) {
					Passport newPassport = (Passport) newInfo;
					newImmýgrant.setAppPassport(newPassport);
				}
				else if(newInfo.getLetter().equals("A")) {
					ApplicantInfo newAppInfo = (ApplicantInfo) newInfo;
					newImmýgrant.setAppInfo(newAppInfo);
				}
				else if(newInfo.getLetter().equals("F")) {
					FinancialStatus newAppStatus = (FinancialStatus) newInfo;
					newImmýgrant.setAppstatus(newAppStatus);
				}
				else if(newInfo.getLetter().equals("D")) {
					Document newDocument = (Document) newInfo;
					doclist.add(newDocument);
					newImmýgrant.setDocumentlist(doclist);
				}
			}
			else {
				immigrantlist.add(newImmýgrant);
				ID = line[1];
				doclist = new ArrayList<>();
				newImmýgrant = new Immigrant(null, null, null, null, null);
				index -= 1;
			}
			if(index == lastIndex) {
				immigrantlist.add(newImmýgrant);
			}
			
		}
		return immigrantlist;
	}
	//polymorphism
	private static Infos firstElementControl(String[] line) {
		if(line[0].equals("P")) {
			String letter = line[0];
			String appID = line[1];
			String resolution = line[2];
			String position = line[3];
			//create photo
			Infos photo = new Photo(appID,resolution,position,letter);
			return photo;
		}
		else if(line[0].equals("S")) {
			String letter = line[0];
			String appID = line[1];
			String passport = line[2];
			String[] datearray = line[3].split("-");
			Date date = new Date(Integer.parseInt(datearray[0]),Integer.parseInt(datearray[1]),Integer.parseInt(datearray[2]));
			Infos Passport = new Passport(appID,passport,date,letter);
			return Passport;
		}
		else if(line[0].equals("A")) {
			String letter = line[0];
			String appID = line[1];
			String appName = line[2];
			Infos appInfo = new ApplicantInfo(appID,appName,letter);
			return appInfo;
		}
		else if(line[0].equals("F")) {
			String letter = line[0];
			String appID = line[1];
			int income = Integer.parseInt(line[2]);
			int savings = Integer.parseInt(line[3]);
			Infos financialStatus = new FinancialStatus(appID,income,savings,letter);
			return financialStatus;
		}
		else if(line[0].equals("D")) {
			String letter = line[0];
			String appID = line[1];
			String docType = line[2];
			int durationMonths = 0;
			if(line.length == 4) {
				durationMonths = Integer.parseInt(line[3]);
			}
			Infos document = new Document(appID,docType,durationMonths,letter);
			return document;
		}
		return null;
		
	}
}
