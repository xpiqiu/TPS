package training.adv.team1.Domain;

import java.sql.SQLException;

import training.adv.team1.Api.TPS;
import training.adv.team1.DAO.BondDaoImpl;
import training.adv.team1.DAO.SalesRequestDaoImpl;
import training.adv.team1.DAO.TraderRequsetDaoImpl;
import training.adv.team1.Service.JMSSender;

public class TPSImpl implements TPS {
	private SalesRequestDaoImpl salesRequestDaoImpl;
	private TraderRequsetDaoImpl traderRequestDaoImpl;
	private BondDaoImpl bondDaoImpl;
	private JMSSender jmsSender;
	
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

	public int matchStatus(SalesRequest salesRequest){
		//改变债券的可修改性
		try {
			this.bondDaoImpl.update(salesRequest.getBoundId(),1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		TraderRequest traderRequest = isRequestMatched(salesRequest);
		if (traderRequest != null) {
			try {
				traderRequest.setTRStatus(1);
				salesRequest.setSRStatus(1);
				if (salesRequest.getSecondPrice() != traderRequest.getSecondPrice()) {
					salesRequest.setSecondPrice(traderRequest.getSecondPrice());
				}
				this.traderRequestDaoImpl.add(traderRequest);
				this.salesRequestDaoImpl.update(salesRequest);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 将traderRequest&request传给BO
			TraderAndSalesRequest traderAndSalesRequest=new TraderAndSalesRequest();
			traderAndSalesRequest.setTraderRequest(traderRequest);
			traderAndSalesRequest.setSalesRequest(salesRequest);
			try {
				jmsSender.TraderAndSalesSender(traderAndSalesRequest);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 1;
		}else{
			try {
				this.salesRequestDaoImpl.add(salesRequest);
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

	public int matchStatus(TraderRequest traderRequest) {
		//改变债券的可修改性
		try {
			this.bondDaoImpl.update(traderRequest.getBoundId(),1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		SalesRequest salesRequest=isRequestMatched(traderRequest);
		if(salesRequest!=null){
			traderRequest.setTRStatus(1);
			salesRequest.setSRStatus(1);
			if(traderRequest.getSecondPrice()!=salesRequest.getSecondPrice()){
				salesRequest.setSecondPrice(traderRequest.getSecondPrice());
			}
			try {
				this.salesRequestDaoImpl.update(salesRequest);
				this.traderRequestDaoImpl.add(traderRequest);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将salesRequest&request传给BO
			TraderAndSalesRequest traderAndSalesRequest=new TraderAndSalesRequest();
			traderAndSalesRequest.setTraderRequest(traderRequest);
			traderAndSalesRequest.setSalesRequest(salesRequest);
			try {
				jmsSender.TraderAndSalesSender(traderAndSalesRequest);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 1;
		}else{
			try {
				this.traderRequestDaoImpl.add(traderRequest);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}

	public void deleteBond(String id) {
		try {
			this.bondDaoImpl.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void editBondStatus(String id,int status) {
		try {
			this.bondDaoImpl.update(id,status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
