package training.adv.team1.Service;

public class BOService {
	
	public static void main(String args[]){
		JMSReceiver jmsReceiver=new JMSReceiver();
		jmsReceiver.tradeAndRequestReceiver();
	}
}
