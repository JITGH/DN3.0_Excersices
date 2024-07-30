package factoryMethodPattern.document;

public class ExcelDocument implements Document {

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("Opening Excel document...");

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Closing Excel document...\n");
	}

}
