package adapterpattern;

public class PhonePeAdapter implements PaymentProcessor{
	PhonePe phonepe;
	
	public PhonePeAdapter(PhonePe phonepe) {
		super();
		this.phonepe = phonepe;
	}

	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method stub
		phonepe.pay(amount);
	}

}
