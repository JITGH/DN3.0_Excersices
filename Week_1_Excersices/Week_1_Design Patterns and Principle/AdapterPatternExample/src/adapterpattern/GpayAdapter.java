package adapterpattern;

public class GpayAdapter implements PaymentProcessor{
	private Gpay gpay;
	
	public GpayAdapter(Gpay gpay) {
		super();
		this.gpay = gpay;
	}


	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method 
		 gpay.makePayment(amount);
	}

}
