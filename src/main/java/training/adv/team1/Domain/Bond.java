package training.adv.team1.Domain;

import java.sql.Date;

public class Bond {
	private String bondID;
	private double firstPrice;
	private double coupon;
	private Date issueDate;
	private Date maturityDate;
	private int status;
	
	public Bond() {
		
	}

	
	public Bond(String bondID, double firstPrice, double coupon, Date issueDate, Date maturityDate, int status) {
		super();
		this.bondID = bondID;
		this.firstPrice = firstPrice;
		this.coupon = coupon;
		this.issueDate = issueDate;
		this.maturityDate = maturityDate;
		this.status = status;
	}


	public String getBondID() {
		return bondID;
	}

	public void setBondID(String bondID) {
		this.bondID = bondID;
	}

	public double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public double getCoupon() {
		return coupon;
	}

	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	};
	

}
