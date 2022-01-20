
public class ApplicantInfo extends Infos{
	private String applicantName;

	public ApplicantInfo(String appID, String applicantName,String letter) {
		super(appID,letter);
		this.applicantName = applicantName;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
}
