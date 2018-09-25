package training.adv.team1.Api;

import training.adv.team1.Domain.SalesRequest;
import training.adv.team1.Domain.TraderRequest;

public interface TPS {
	public TraderRequest isRequestMatched(SalesRequest request);
	
	public int matchStatus(SalesRequest request);
	
	public SalesRequest isRequestMatched(TraderRequest request);
	
	public int matchStatus(TraderRequest request);
	
	public void deleteBond(String id);
	
	public void editBondStatus(String id,int status);
}
