package decoratorPattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notifier notifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Sending notifications via Email, SMS, and Slack:");
        slackNotifier.send("Hello, this is a test message!");

        System.out.println("\nSending notifications via Email and SMS:");
        smsNotifier.send("Another test message!");

        System.out.println("\nSending notification via Email only:");
        notifier.send("Final test message!");
	}

}
