package training.adv.team1.Domin;

import java.sql.SQLException;

import training.adv.team1.Api.TPS;
import training.adv.team1.DAO.BoundDaoImpl;
import training.adv.team1.DAO.SalesRequestDaoImpl;
import training.adv.team1.DAO.TraderRequsetDaoImpl;

public class TPSImpl implements TPS {
	private SalesRequestDaoImpl salesRequestDaoImpl;
	private TraderRequsetDaoImpl traderRequestDaoImpl;
	private BoundDaoImpl boundDaoImpl;

	public TraderRequest isRequestMatched(SalesRequest request) {
		String boundId = request.getBoundId();
		String salesId = request.getSalesId();
		TraderRequest traderRequest = null;
		try {
			traderRequest = this.traderRequestDaoImpl.findById(boundId, salesId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return traderRequest;
	}

	public int matchStatus(SalesRequest request) {
		//改变债券的可修改性
		try {
			this.boundDaoImpl.update(request.getBoundId(),1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		TraderRequest traderRequest = isRequestMatched(request);
		if (traderRequest != null) {
			try {
				traderRequest.setTRStatus(1);
				request.setSRStatus(1);
				if (request.getSecondPrice() != traderRequest.getSecondPrice()) {
					request.setSecondPrice(traderRequest.getSecondPrice());
				}
				this.traderRequestDaoImpl.add(traderRequest);
				this.salesRequestDaoImpl.update(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 将traderRequest&request传给BO
			
			
			return 1;
		}else{
			try {
				this.salesRequestDaoImpl.add(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
	}

	public SalesRequest isRequestMatched(TraderRequest request) {
		String boundId = request.getBoundId();
		String salesId = request.getSalesId();
		SalesRequest salesRequest=null;
		try {
			salesRequest=this.salesRequestDaoImpl.findById(boundId, salesId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesRequest;
	}

	public int matchStatus(TraderRequest request) {
		//改变债券的可修改性
		try {
			this.boundDaoImpl.update(request.getBoundId(),1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		SalesRequest salesRequest=isRequestMatched(request);
		if(salesRequest!=null){
			request.setTRStatus(1);
			salesRequest.setSRStatus(1);
			if(request.getSecondPrice()!=salesRequest.getSecondPrice()){
				salesRequest.setSecondPrice(request.getSecondPrice());
			}
			try {
				this.salesRequestDaoImpl.update(salesRequest);
				this.traderRequestDaoImpl.add(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将salesRequest&request传给BO
			
			return 1;
		}else{
			try {
				this.traderRequestDaoImpl.add(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
}
