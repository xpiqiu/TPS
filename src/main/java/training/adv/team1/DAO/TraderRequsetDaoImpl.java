package training.adv.team1.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Api.TraderRequestDao;
import training.adv.team1.Domin.TraderRequest;

public class TraderRequsetDaoImpl implements TraderRequestDao {

	//增
	public void add(TraderRequest t) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into TraderRequest(TRID,BoundID,TradeID,TRStatus,SecondPrice,TRTime,SalesID)values(?,?,?,?,?,?,?)";
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,t.getTRId());
			ps.setString(2, t.getBoundId());
			ps.setString(3, t.getTradeId());
			ps.setInt(4, t.getTRStatus());
			ps.setDouble(5,t.getSecondPrice());
			ps.setDate(6, (Date) t.getTRTime());
			ps.setString(7, t.getSalesId());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally{
			DBUtil.close(null, ps, conn);
		}

	}

	
	//改状态
	public void update(TraderRequest t) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update TraderRequest set TRStatus=? where TRID=?";
		try{
			conn = DBUtil.getConnection();
		    ps.setInt(1 , t.getTRStatus());
			ps.setString(2,t.getTRId());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}finally{
			DBUtil.close(null, ps, conn);
			}  
	}

	//删整行
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from TraderRequest where TRID=?";
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally{
			DBUtil.close(null, ps, conn);
		}

	}

	//查
	public TraderRequest findById(String boundid,String salesid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps =  null;
		String sql = "select * from TraderRequest where  BoundID=? and SalesID=?";
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, boundid);
			ps.setString(2, salesid);
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return null;
	}

	public List<TraderRequest> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
