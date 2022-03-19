package publisher_milkshake;

public interface MilkShakePublisher {
	public void displayMilkShake(int type);
	public double getPrice(int type, int milkShake);
	public String getName(int type, int milkShake);

}
