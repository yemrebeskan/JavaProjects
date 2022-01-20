
public class FinancialStatus extends Infos{
	private int income;
	private int savings;
	public FinancialStatus(String appID, int income, int savings,String letter) {
		super(appID,letter);
		this.income = income;
		this.savings = savings;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSavings() {
		return savings;
	}
	public void setSavings(int savings) {
		this.savings = savings;
	}
	
}
