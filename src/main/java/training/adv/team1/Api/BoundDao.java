package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.Bound;

public interface BoundDao {
    
    //删
    public void update(String id,int status)throws SQLException;
    
    //改
    public void delete(String id)throws SQLException;
    
    //查
    public List<Bound> findallById(String id)throws SQLException;
    

}
