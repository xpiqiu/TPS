package training.adv.team1.Domain;

import java.io.Serializable;
import java.util.Date;

public class TraderRequest implements Serializable{
	private String TRId;
	private String boundId;
	private String TradeId;
	private String SalesId;
	private int TRStatus;
	private Date TRTime;
	private double secondPrice;

	public TraderRequest() {
		super();
	}

	public TraderRequest(String tRId, String boundId, String tradeId, String salesId, int tRStatus, Date tRTime,
			double secondPrice) {
		super();
		TRId = tRId;
		this.boundId = boundId;
		TradeId = tradeId;
		SalesId = salesId;
		TRStatus = tRStatus;
		TRTime = tRTime;
		this.secondPrice = secondPrice;
	}

	public String getTRId() {
		return TRId;
	}

	public void setTRId(String tRId) {
		TRId = tRId;
	}

	public String getBoundId() {
		return boundId;
	}

	public void setBoundId(String boundId) {
		this.boundId = boundId;
	}

	public String getTradeId() {
		return TradeId;
	}

	public void setTradeId(String tradeId) {
		TradeId = tradeId;
	}

	public String getSalesId() {
		return SalesId;
	}

	public void setSalesId(String salesId) {
		SalesId = salesId;
	}

	public int getTRStatus() {
		return TRStatus;
	}

	public void setTRStatus(int tRStatus) {
		TRStatus = tRStatus;
	}

	public Date getTRTime() {
		return TRTime;
	}

	public void setTRTime(Date tRTime) {
		TRTime = tRTime;
	}

	public double getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(double secondPrice) {
		this.secondPrice = secondPrice;
	}

}