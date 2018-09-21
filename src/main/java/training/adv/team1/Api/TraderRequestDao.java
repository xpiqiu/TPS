package training.adv.team1.Api;

import java.sql.SQLException;
import java.util.List;

import training.adv.team1.Domin.TraderRequest;

public interface TraderRequestDao {

	//��ӷ���
    public void add(TraderRequest t)throws SQLException;
    
    //���·���
    public void update(TraderRequest t)throws SQLException;
    
    //ɾ������
    public void delete(int id)throws SQLException;
    
    //���ҷ���
    public TraderRequest findById(String boundid,String salesid)throws SQLException;
    
    //��������
    public List<TraderRequest> findAll()throws SQLException;
}
