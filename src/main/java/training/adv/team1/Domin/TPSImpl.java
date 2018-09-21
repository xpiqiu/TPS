package training.adv.team1.Domin;

import training.adv.team1.Api.TPS;

public class TPSImpl implements TPS{

	public boolean isRequestMatched(SalesRequest request) {
		//查询数据库看看有没有和request匹配的
		return false;
	}

	public int matchStatus(SalesRequest request) {
		if(isRequestMatched(request)){
			//如果有，修改完善trade表，删除部分bound表
			return 1;
		}else{
			//如果没有，把新数据加入到表中
			return 0;
		}
	}
	
}
