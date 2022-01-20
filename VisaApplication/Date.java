import java.time.LocalDate;
public class Date {
	private int year;
	private int month;
	private int day;
	public Date(int year,int month,int day) {
		this.year = year;
		this.day = day;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int difOfMonths() { //difference of today's date and expiration date
		Date localDate = createNewDate();
		if(this.year == localDate.year) {
			int difference = this.month = localDate.month;
			return difference;
		}
		else if(this.year > localDate.year) {
			int compmonth = this.month + 12 * (this.year - localDate.year);
			return compmonth - localDate.month;
		}
		else {
			int compmonth = localDate.month + 12 * (localDate.year - this.year);
			return this.month - compmonth;
		}
	}
	public Date createNewDate() {
		LocalDate date = java.time.LocalDate.now();
		String[] dateArray = date.toString().split("-");
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);
		Date newDate = new Date(year,month,day);
		return newDate;	
	}
}
