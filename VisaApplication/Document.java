
public class Document extends Infos{
	private String docType;
	private int duration;
	public Document(String appID, String docType, int duration,String letter) {
		super(appID,letter);
		this.docType = docType;
		this.duration = duration;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
