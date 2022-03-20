package publisher_salad;

public interface SaladPublisher {
	
	public void displaySalad(int salad);
	public double getPrice(int type, int salad);
	public String getName(int type, int salad);
}
