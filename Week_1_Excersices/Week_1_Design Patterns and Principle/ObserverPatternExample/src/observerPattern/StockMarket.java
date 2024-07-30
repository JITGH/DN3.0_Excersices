package observerPattern;
import java.util.ArrayList;
import java.util.List;
public class StockMarket implements Stock {
	private List<Observer> observers;
	private double stockPrice;
	
	public StockMarket() {
		this.observers=new ArrayList<>();
	}

	@Override
	public void register(Observer observer) {
		// TODO Auto-generated method stub
		 observers.add(observer);
	}

	@Override
	public void deregister(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
            observer.update(stockPrice);
        }
	}
	
	public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

}
