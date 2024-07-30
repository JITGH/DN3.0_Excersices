package decoratorPattern;

public abstract class NotifierDecorator implements Notifier {
	protected Notifier notifier;
	
	public NotifierDecorator(Notifier notifier) {
		super();
		this.notifier = notifier;
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
			notifier.send(msg);
	}

}
