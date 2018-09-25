package training.adv.team1.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import training.adv.team1.DAO.ActiveMQUtil;
import training.adv.team1.Domain.BOImpl;
import training.adv.team1.Domain.SalesRequest;
import training.adv.team1.Domain.TPSImpl;
import training.adv.team1.Domain.TraderAndSalesRequest;
import training.adv.team1.Domain.TraderRequest;

public class JMSReceiver {
	private TPSImpl tpsImpl;
	private BOImpl boImpl;
	public static final String BROKER_URL = "tcp://localhost:61616";
	public static final String REQUEST_TARGET = "RequestQueue";
	public static final String TRADERANDSALESREQUEST_TARGET = "TraderAndSalesRequestQueue";
	public static final String RESULT_TARGET = "ResultRequestQueue";

	public void requestReceive() {
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			Queue queue = session.createQueue(REQUEST_TARGET);
			QueueReceiver receiver=session.createReceiver(queue);
			receiver.setMessageListener(new MessageListener() {
				public void onMessage(Message message) {
					ObjectMessage object=(ObjectMessage)message;
					try {
						if(object.getObject() instanceof TraderRequest){
							TraderRequest traderRequest=(TraderRequest)object.getObject();
							tpsImpl.matchStatus(traderRequest);
						}else if(object.getObject() instanceof SalesRequest){
							SalesRequest salesRequest=(SalesRequest)object.getObject();
							tpsImpl.matchStatus(salesRequest);
						}else{
							System.out.println("wrong");
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			Thread.sleep(1000 * 100); 
            // 提交会话
            session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tradeAndRequestReceiver(){
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			Queue queue = session.createQueue(TRADERANDSALESREQUEST_TARGET);
			QueueReceiver receiver=session.createReceiver(queue);
			receiver.setMessageListener(new MessageListener() {
				public void onMessage(Message message) {
					ObjectMessage object=(ObjectMessage)message;
					try {
						if(object.getObject() instanceof TraderAndSalesRequest){
							//调用
							TraderAndSalesRequest traderAndSalesRequest=(TraderAndSalesRequest)object.getObject();
							boImpl.isIllegal(traderAndSalesRequest);
						}else{
							System.out.println("wrong");
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			Thread.sleep(1000 * 100); 
            // 提交会话
            session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resultReceiver(){
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			Queue queue = session.createQueue(RESULT_TARGET);
			QueueReceiver receiver=session.createReceiver(queue);
			receiver.setMessageListener(new MessageListener() {
				public void onMessage(Message message) {
					ObjectMessage object=(ObjectMessage)message;
					try {
						if(object.getObject() instanceof TraderAndSalesRequest){
							//调用
							TraderAndSalesRequest traderAndSalesRequest=(TraderAndSalesRequest)object.getObject();
							if(traderAndSalesRequest.getStatus().equals("REJECTED")){
								tpsImpl.editBondStatus(traderAndSalesRequest.getTraderRequest().getBoundId(), 0);
							}else if(traderAndSalesRequest.getStatus().equals("ACCEPTED")){
								tpsImpl.deleteBond(traderAndSalesRequest.getTraderRequest().getBoundId());
							}
						}else{
							System.out.println("wrong");
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			Thread.sleep(1000 * 100); 
            // 提交会话
            session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
