package training.adv.team1.Service;

public class TPSService {
	private static JMSReceiver jmsReceiver;
	
	public static void main(String args[]){
		jmsReceiver.requestReceive();
		jmsReceiver.resultReceiver();
	}
}
