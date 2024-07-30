package observerPattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        System.out.println("Setting stock price to 100.0");
        stockMarket.setStockPrice(100.0);

        System.out.println("\nSetting stock price to 200.0");
        stockMarket.setStockPrice(200.0);

        stockMarket.deregister(mobileApp);

        System.out.println("\nSetting stock price to 300.0");
        stockMarket.setStockPrice(300.0);
	}

}
