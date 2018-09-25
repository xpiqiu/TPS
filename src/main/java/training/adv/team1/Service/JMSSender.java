package training.adv.team1.Service;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import training.adv.team1.DAO.ActiveMQUtil;
import training.adv.team1.Domain.SalesRequest;
import training.adv.team1.Domain.TraderAndSalesRequest;
import training.adv.team1.Domain.TraderRequest;

public class JMSSender {
	public void TRSender(TraderRequest traderRequest) throws Exception {
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			String DESTINATION = "RequestQueue";
			Queue queue = session.createQueue(DESTINATION);
			QueueSender sender = session.createSender(queue);
			sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage object = session.createObjectMessage(traderRequest);
			sender.send(object);
			session.commit();
		} catch (JMSException e) {
			throw (e);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void SRSender(SalesRequest salesRequest) throws Exception {
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			String DESTINATION = "RequestQueue";
			Queue queue = session.createQueue(DESTINATION);
			QueueSender sender = session.createSender(queue);
			sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage object = session.createObjectMessage(salesRequest);
			sender.send(object);
			session.commit();
		} catch (JMSException e) {
			throw (e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void TraderAndSalesSender(TraderAndSalesRequest traderAndSalesRequest) throws Exception {
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			String DESTINATION = "TraderAndSalesRequestQueue";
			Queue queue = session.createQueue(DESTINATION);
			QueueSender sender = session.createSender(queue);
			sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage object = session.createObjectMessage(traderAndSalesRequest);
			sender.send(object);
			session.commit();
		} catch (JMSException e) {
			throw (e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void resultSender(TraderAndSalesRequest traderAndSalesRequest) throws Exception{
		QueueSession session=ActiveMQUtil.getQueueSession();
		try {
			String DESTINATION = "resultRequestQueue";
			Queue queue = session.createQueue(DESTINATION);
			QueueSender sender = session.createSender(queue);
			sender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage object = session.createObjectMessage(traderAndSalesRequest);
			sender.send(object);
			session.commit();
		} catch (JMSException e) {
			throw(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
