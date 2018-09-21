package training.adv.team1.Api;

import training.adv.team1.Domin.SalesRequest;

public interface TPS {
	public boolean isRequestMatched(SalesRequest request);
	public int matchStatus(SalesRequest request);
}
