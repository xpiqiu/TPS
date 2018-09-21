package training.adv.team1.DAO;

import training.adv.team1.Api.*;
import training.adv.team1.Domin.Bound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoundDaoImpl implements BoundDao{

	//改状态
	
	 public void update(Bound b) throws SQLException {
	 Connection conn = null;
	 PreparedStatement ps = null;
	 String sql = "update Bound set BoundStatus=? where BoundID=?";
	 try{
		 conn = DBUtil.getConnection();
		 ps.setInt(1 , b.getBoundStatus());
		 ps.setString(2, b.getBoundID());
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
		String sql = "delete from Bound where BoundID=?";
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

	//模糊查询

	public List<Bound> findallById(String temp) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Bound b = null;
		 List<Bound> bounds = new ArrayList<Bound>();
		 String sql = "select * from Bound where BoundID like '%'"+temp+"'%'";
		 try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				b = new Bound();
				b.setBoundID(rs.getString(1));
				b.setFirstPrice(rs.getDouble(2));
				b.setRate(rs.getDouble(3));
				b.setIssueDay(rs.getDate(4));
				b.setMaturity(rs.getDate(5));
				b.setBoundStatus(rs.getInt(6));
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
