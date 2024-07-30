package strategyPattern;

public class CreditCardPayment implements PaymentStrategy {
	private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

	public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		 System.out.println("Paid " + amount + " using Credit Card.");
	}

}
