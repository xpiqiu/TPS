package training.adv.team1.Domin;

import java.util.Date;   

public class SalesRequest {
	private String SRId;
	private String boundId;
	private String SalesId;
	private int SRStatus;
	private double SecondPrice;
	private Date SRTime;

	public SalesRequest() {
		super();
	}

	public SalesRequest(String sRId, String boundId, String salesId, int sRStatus, double secondprice,Date sRtime) {
		super();
		SRId = sRId;
		this.boundId = boundId;
		SalesId = salesId;
		SRStatus = sRStatus;
		SecondPrice = secondprice;
		SRTime = sRtime;
	}

	public double getSecondPrice() {
		return SecondPrice;
	}

	public void setSecondPrice(double secondPrice) {
		SecondPrice = secondPrice;
	}

	public String getSRId() {
		return SRId;
	}

	public void setSRId(String sRId) {
		SRId = sRId;
	}

	public String getBoundId() {
		return boundId;
	}

	public void setBoundId(String boundId) {
		this.boundId = boundId;
	}

	public String getSalesId() {
		return SalesId;
	}

	public void setSalesId(String salesId) {
		SalesId = salesId;
	}

	public int getSRStatus() {
		return SRStatus;
	}

	public void setSRStatus(int sRStatus) {
		SRStatus = sRStatus;
	}

	public Date getSRTime() {
		return SRTime;
	}

	public void setSRTime(Date sRtime) {
		SRTime = sRtime;
	}

}
