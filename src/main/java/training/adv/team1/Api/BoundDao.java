package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.Bound;

public interface BoundDao {
    
    //¸Ä
    public void update(Bound b)throws SQLException;
    
    //É¾
    public void delete(int id)throws SQLException;
    
    //²é
    public List<Bound> findallById(String id)throws SQLException;
    

}
