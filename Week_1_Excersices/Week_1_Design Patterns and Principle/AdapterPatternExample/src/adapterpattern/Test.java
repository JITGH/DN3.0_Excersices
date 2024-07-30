package adapterpattern;

public class Test {

	public static void main(String[] args) {
		// Using GPay through the adapter
        Gpay gpay = new Gpay();
        PaymentProcessor GpayAdapter = new GpayAdapter(gpay);
        GpayAdapter.processPayment(100.0);
        
     // Using GPay through the adapter
        PhonePe phonepe = new PhonePe();
        PaymentProcessor PhonePeAdapter = new PhonePeAdapter(phonepe);
        PhonePeAdapter.processPayment(100.0);
		
	}

}
