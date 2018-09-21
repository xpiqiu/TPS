package training.adv.team1.Api;

import java.sql.SQLException;

import training.adv.team1.Domin.SalesRequest;

public interface SalesRequestDao {

	//��ӷ���
    public void add(SalesRequest s)throws SQLException;
    
    //���·���
    public void update(SalesRequest s)throws SQLException;
    
    //ɾ������
    public void delete(int id)throws SQLException;
    
    //���ҷ���
    public SalesRequest findById(String boundid,String salesid)throws SQLException;
}
