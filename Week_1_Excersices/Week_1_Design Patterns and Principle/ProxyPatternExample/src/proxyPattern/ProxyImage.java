package proxyPattern;

public class ProxyImage implements Image {
	private RealImage realimage;
	private String filename;
	
	public ProxyImage(String filename) {
		super();
		this.filename=filename;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		 if (realimage == null) {
	            realimage = new RealImage(filename);
	        }
	        realimage.display();
	    }
	}


