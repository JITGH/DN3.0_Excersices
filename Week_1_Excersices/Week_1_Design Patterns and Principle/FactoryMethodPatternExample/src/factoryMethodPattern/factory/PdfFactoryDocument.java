package factoryMethodPattern.factory;
import factoryMethodPattern.document.Document;
import factoryMethodPattern.document.PdfDocument;


public class PdfFactoryDocument extends DocumentFactory {

	@Override
	public Document createDocument() {
		// TODO Auto-generated method stub
		 return new PdfDocument();
	}
	
}
