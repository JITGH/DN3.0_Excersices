package proxyPattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image =new ProxyImage("abc.jpg");
		// Image will be loaded from disk only when display() is called
		image.display();
		// Image will not be loaded again, as it has been cached in the Proxy
		image.display();
	}

}
