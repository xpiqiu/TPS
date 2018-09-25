package training.adv.team1.DAO;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtil {
	public static QueueSession getQueueSession(){
		String BROKER_URL = "tcp://localhost:61616";
		try {
			QueueConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
			String DESTINATION = "TraderAndSalesRequestQueue";
			QueueConnection connection = factory.createQueueConnection();
			connection.start();
			QueueSession session = connection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			return session;
		} catch (JMSException e) {
			e.printStackTrace();
			return null;
		}
	}
}
