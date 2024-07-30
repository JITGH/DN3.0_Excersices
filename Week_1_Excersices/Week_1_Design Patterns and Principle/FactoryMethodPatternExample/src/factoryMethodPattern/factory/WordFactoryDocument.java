package factoryMethodPattern.factory;
import factoryMethodPattern.document.Document;
import factoryMethodPattern.document.WordDocument;

public class WordFactoryDocument extends DocumentFactory {

	@Override
	public Document createDocument() {
        return new WordDocument();
    }
		
}
