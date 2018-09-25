package training.adv.team1.Domain;

import java.util.Date;

import training.adv.team1.Api.BO;

public class BOImpl implements BO{

	public boolean isIllegal(TraderAndSalesRequest traderAndSalesRequest) {
		Date traderDate=traderAndSalesRequest.getTraderRequest().getTRTime();
		Date salesDate=traderAndSalesRequest.getSalesRequest().getSRTime();
		//相距时间大于等于两天视为无效
		if(Math.abs((int)(salesDate.getTime()-traderDate.getTime())/3600/24/100)>=2){
			return false;
		}
		return true;
	}
}
