package decoratorPattern;

public class SMSNotifierDecorator extends NotifierDecorator{

	public SMSNotifierDecorator(Notifier notifier) {
		super(notifier);
		// TODO Auto-generated constructor stub
	}
	
		@Override
	    public void send(String msg) {
	        super.send(msg);
	        sendSMS(msg);
	    }

		private void sendSMS(String msg) {
			// TODO Auto-generated method stub
			System.out.println("Sending SMS notification: " + msg);
		}

}
