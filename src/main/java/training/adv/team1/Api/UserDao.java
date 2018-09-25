package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domain.User;

public interface UserDao {
	
    //改
    public void update(User u)throws SQLException;

    //查
    public List<User> findallById(String temp)throws SQLException;

}
