package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.User;

public interface UserDao {
	
    //¸Ä
    public void update(User u)throws SQLException;

    //²é
    public List<User> findallById(String temp)throws SQLException;

}
