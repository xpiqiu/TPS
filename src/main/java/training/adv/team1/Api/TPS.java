package training.adv.team1.Api;

import training.adv.team1.Domin.SalesRequest;
import training.adv.team1.Domin.TraderRequest;

public interface TPS {
	public TraderRequest isRequestMatched(SalesRequest request);
	
	public int matchStatus(SalesRequest request);
	
	public SalesRequest isRequestMatched(TraderRequest request);
	
	public int matchStatus(TraderRequest request);
}
