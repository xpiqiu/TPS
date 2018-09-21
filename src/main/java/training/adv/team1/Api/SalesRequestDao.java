package training.adv.team1.Api;

import java.sql.SQLException;

import training.adv.team1.Domin.SalesRequest;

public interface SalesRequestDao {

	//添加方法
    public void add(SalesRequest s)throws SQLException;
    
    //更新方法
    public void update(SalesRequest s)throws SQLException;
    
    //删除方法
    public void delete(int id)throws SQLException;
    
    //查找方法
    public SalesRequest findById(String boundid,String salesid)throws SQLException;
}
