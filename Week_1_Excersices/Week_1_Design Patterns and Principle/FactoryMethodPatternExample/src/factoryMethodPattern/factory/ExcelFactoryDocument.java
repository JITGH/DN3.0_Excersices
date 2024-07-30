package factoryMethodPattern.factory;
import factoryMethodPattern.document.Document;
import factoryMethodPattern.document.ExcelDocument;

public class ExcelFactoryDocument extends DocumentFactory{

	@Override
	public Document createDocument() {
		// TODO Auto-generated method stub
		 return new ExcelDocument();
	}

}
