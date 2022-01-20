
public class Photo extends Infos{
	private String resolution;
	private String position;
	public Photo(String i, String resolution, String position,String letter) {
		super(i,letter);
		this.resolution = resolution;
		this.position = position;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
