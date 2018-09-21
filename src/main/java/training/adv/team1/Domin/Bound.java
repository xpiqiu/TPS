package training.adv.team1.Domin;

import java.sql.Date;

public class Bound {
	private String boundID;
	private double firstPrice;
	private double rate;
	private Date issueDay;
	private Date Maturity;
	private int boundStatus;

	public Bound() {
	};

	public String getBoundID() {
		return boundID;
	}

	public void setBoundID(String boundID) {
		this.boundID = boundID;
	}

	public double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getIssueDay() {
		return issueDay;
	}

	public void setIssueDay(Date issueDay) {
		this.issueDay = issueDay;
	}

	public Date getMaturity() {
		return Maturity;
	}

	public void setMaturity(Date maturity) {
		Maturity = maturity;
	}

	public int getBoundStatus() {
		return boundStatus;
	}

	public void setBoundStatus(int boundStatus) {
		this.boundStatus = boundStatus;
	}

}
