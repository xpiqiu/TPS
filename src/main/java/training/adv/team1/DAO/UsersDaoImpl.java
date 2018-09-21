package training.adv.team1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.adv.team1.Api.UserDao;
import training.adv.team1.Domin.User;

import java.sql.Connection;

public class UsersDaoImpl implements UserDao{

	public void update(User u) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;;
		String sql = "update User set StatusMark=? where UserID=?";
		try{
			conn = DBUtil.getConnection();
			ps.setInt(1,u.getSatusMark());
			ps.setString(2, u.getId());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}finally{
			DBUtil.close(null, ps, conn);
			}  
		
	}

	public List<User> findallById(String temp) throws SQLException {
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 User u = null;
		 List<User> users = new ArrayList<User>();
		 String sql = "select * from User where UserID like '%'"+temp+"'%'";
		 try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				u = new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setUserType(rs.getInt(4));
				u.setSatusMark(rs.getInt(5));
				users.add(u);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("查询数据失败");
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return users;
	}
}
