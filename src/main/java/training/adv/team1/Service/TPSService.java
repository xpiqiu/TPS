package training.adv.team1.Service;

import training.adv.team1.Domin.SalesRequest;
import training.adv.team1.Domin.TPSImpl;

public class TPSService {
	private SalesRequest request;
	private TPSImpl tps;

	public TPSImpl getTps() {
		return tps;
	}

	public void setTps(TPSImpl tps) {
		this.tps = tps;
	}
	
	public int Match(){
		return this.tps.matchStatus(this.request);
	}
}
