package training.adv.team1.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import training.adv.team1.Api.SalesRequestDao;
import training.adv.team1.Domin.SalesRequest;

public class SalesRequestDaoImpl implements SalesRequestDao {

	public void add(SalesRequest s) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into SalesRequest(SRID,BoundID,SalesID,SRStatus,SecondPrice,SRTime)values(?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getSRId());
			ps.setString(2, s.getBoundId());
			ps.setString(3, s.getSalesId());
			ps.setInt(4, s.getSRStatus());
			ps.setDouble(5, s.getSecondPrice());
			ps.setDate(6, (Date) s.getSRTime());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	public void update(SalesRequest s) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update SalesRequest set SRStatus=? where SRID=?";
		try {
			conn = DBUtil.getConnection();
			ps.setInt(1, s.getSRStatus());
			ps.setString(2, s.getSRId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from SalesRequest where SRID=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtil.close(null, ps, conn);
		}

	}

	public SalesRequest findById(String boundid, String salesid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "select * from SalesRequest where  BoundID=? and SalesID=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, boundid);
			ps.setString(2, salesid);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtil.close(null, ps, conn);
		}
		return null;
	}
}
