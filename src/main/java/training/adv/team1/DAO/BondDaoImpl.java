package training.adv.team1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.adv.team1.Api.BondDao;
import training.adv.team1.Domain.Bond;

public class BondDaoImpl implements BondDao {

	 public void update(String id,int boundstatus) throws SQLException {
	 Connection conn = null;
	 PreparedStatement ps = null;
	 String sql = "update Bound set BoundStatus=? where BoundID=?";
	 try{
		 conn = DBUtil.getConnection();
		 ps=conn.prepareStatement(sql);
		 ps.setInt(1, boundstatus);
		 ps.setString(2,id);
		 ps.executeUpdate();
	 }catch(SQLException e){
		 e.printStackTrace();
		 throw new SQLException("更新数据失败");
	 }finally{
		 DBUtil.close(null, ps, conn);
		 }        
	 }

	public void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from Bound where BoundID='"+id+"'";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtil.close(null, ps, conn);
		}
		
	}

	public List<Bond> findAllById(String temp) throws SQLException {
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Bond b = null;
		 List<Bond> bounds = new ArrayList<Bond>();
		 String sql = "select * from Bound where BoundID like '%'"+temp+"'%'";
		 try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				b = new Bond();
				/*b.setBoundID(rs.getString(1));
				b.setFirstPrice(rs.getDouble(2));
				b.setRate(rs.getDouble(3));
				b.setIssueDay(rs.getDate(4));
				b.setMaturity(rs.getDate(5));
				b.setBoundStatus(rs.getInt(6));*/
				bounds.add(b);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("查询数据失败");
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return bounds;
	}

}
