package training.adv.team1.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.adv.team1.DAO.BoundDaoImpl;
import training.adv.team1.Domin.Bound;

public class BoundService {
	private BoundDaoImpl boundDaoImpl;

	public BoundDaoImpl getBoundDaoImpl() {
		return boundDaoImpl;
	}

	public void setBoundDaoImpl(BoundDaoImpl boundDaoImpl) {
		this.boundDaoImpl = boundDaoImpl;
	}

	List<Bound> FindAllById(String id) {
		List<Bound> list = new ArrayList<Bound>();
		try {
			list = this.boundDaoImpl.findallById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
