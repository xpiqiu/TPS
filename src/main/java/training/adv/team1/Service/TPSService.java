package training.adv.team1.Service;

import training.adv.team1.Domin.SalesRequest;
import training.adv.team1.Domin.TPSImpl;
import training.adv.team1.Domin.TraderRequest;

public class TPSService {
	private SalesRequest salesRequest=null;
	private TraderRequest traderRequest=null;
	private TPSImpl tps;

	public void getRequest(SalesRequest salesRequest){
		this.salesRequest=salesRequest;
	}
	
	public void getRequest(TraderRequest traderRequest){
		this.traderRequest=traderRequest;
	}
	public TPSImpl getTps() {
		return tps;
	}

	public void setTps(TPSImpl tps) {
		this.tps = tps;
	}
	
	public int Match(){
		if(this.salesRequest==null){
			return this.tps.matchStatus(salesRequest);
		}else{
			return this.tps.matchStatus(traderRequest);
		}
	}
}
