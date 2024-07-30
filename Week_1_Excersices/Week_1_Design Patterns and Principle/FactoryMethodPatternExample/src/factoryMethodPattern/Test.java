package factoryMethodPattern;
import factoryMethodPattern.factory.*;
import factoryMethodPattern.document.Document;

public class Test {
	public static void main(String args[]) {
		 // Create a factory for each document type
        DocumentFactory wordFactory = new WordFactoryDocument();
        DocumentFactory pdfFactory = new PdfFactoryDocument();
        DocumentFactory excelFactory = new ExcelFactoryDocument();
        
     // Use the factories to create documents
        Document wordDocument = wordFactory.createDocument();
        Document pdfDocument = pdfFactory.createDocument();
        Document excelDocument = excelFactory.createDocument();
        
        // Open and close each document
        wordDocument.open();
        wordDocument.close();

        pdfDocument.open();
        pdfDocument.close();

        excelDocument.open();
        excelDocument.close();
        
	}
}
