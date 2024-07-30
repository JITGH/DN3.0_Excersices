package factoryMethodPattern.document;

public class PdfDocument implements Document {

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("Opening Pdf document...");

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Closing Pdf document...\n");
	}

}
