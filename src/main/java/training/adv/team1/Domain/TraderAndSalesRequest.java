package training.adv.team1.Domain;

import java.io.Serializable;

public class TraderAndSalesRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TraderRequest traderRequest;
	private SalesRequest salesRequest;
	private String status;
	
	
	
	public TraderAndSalesRequest() {
		super();
		this.status="processed";
	}

	public TraderAndSalesRequest(TraderRequest traderRequest, SalesRequest salesRequest, String status) {
		super();
		this.traderRequest = traderRequest;
		this.salesRequest = salesRequest;
		this.status = status;
	}

	public TraderRequest getTraderRequest() {
		return traderRequest;
	}
	
	public void setTraderRequest(TraderRequest traderRequest) {
		this.traderRequest = traderRequest;
	}
	
	public SalesRequest getSalesRequest() {
		return salesRequest;
	}
	
	public void setSalesRequest(SalesRequest salesRequest) {
		this.salesRequest = salesRequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
