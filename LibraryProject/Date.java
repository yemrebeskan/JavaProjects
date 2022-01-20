
public class Date {
	private int day;
	private String month;
	private int year;
	
	Date(int new_day,String new_month,int new_year){
		day = new_day;
		month = new_month;
		year = new_year;
	}
	
	
	
	public int calculateDayOfYear() {
		int total_Day = 0;
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i = 0;i < months.length;i++) {
			if(month.equals(months[i])) {
				if(i != 0) {
					for(int j = i - 1;j >= 0;j--) { /*to go to previous months*/
						if(j == 1) { /*for feb*/
							if(year % 4 == 0) {
								total_Day += 29;
							}
							else {
								total_Day += 28;
							}
						}
						else { /*for other months*/
							if(j == 0 || j == 2 || j == 4 || j == 6 || j == 7 || j == 9 || j == 11) {
								total_Day += 31;
							}
							else {
								total_Day += 30;
							}
							
						}
						
					}
					total_Day += day; /*add the day to total day*/
				
				}
				else {
					total_Day = day; /*if month is jan total day should be equal with day*/
				}
			}
		}
		
		return total_Day;
		
	}
}
