package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.User;

public interface UserDao {
	
    //��
    public void update(User u)throws SQLException;

    //��
    public List<User> findallById(String temp)throws SQLException;

}
