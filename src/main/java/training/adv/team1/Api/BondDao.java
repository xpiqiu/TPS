package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domain.Bond;

public interface BondDao {
    
    //删
    public void update(String id,int status)throws SQLException;
    
    //改
    public void delete(String id)throws SQLException;
    
    //查
    public List<Bond> findAllById(String id)throws SQLException;
    

}
