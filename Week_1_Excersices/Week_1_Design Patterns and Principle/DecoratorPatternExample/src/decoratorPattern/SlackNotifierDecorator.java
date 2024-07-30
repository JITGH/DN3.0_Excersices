package decoratorPattern;

public class SlackNotifierDecorator extends NotifierDecorator{

	public SlackNotifierDecorator(Notifier notifier) {
		super(notifier);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String msg) {
		super.send(msg);
		SlackSend(msg);
	}

	private void SlackSend(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Sending Slack notification: " + msg);
	}
	
}
