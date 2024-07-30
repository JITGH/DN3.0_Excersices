package strategyPattern;

public class Test {
	 public static void main(String[] args) {
	        PaymentContext context = new PaymentContext();

	        // Using Credit Card Payment
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/23");
	        context.setPaymentStrategy(creditCardPayment);
	        context.executePayment(100.0);

	        // Using PayPal Payment
	        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
	        context.setPaymentStrategy(payPalPayment);
	        context.executePayment(200.0);
	    }
}
