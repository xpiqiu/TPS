package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.TraderRequest;

public interface TraderRequestDao {

	//添加方法
    public void add(TraderRequest t)throws SQLException;
    
    //更新方法
    public void update(TraderRequest t)throws SQLException;
    
    //删除方法
    public void delete(int id)throws SQLException;
    
    //查找方法
    public TraderRequest findById(String boundid,String salesid)throws SQLException;
    
    //查找所有
    public List<TraderRequest> findAll()throws SQLException;
}
