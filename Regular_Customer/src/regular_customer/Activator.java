package regular_customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import publisher_milkshake.MilkShakePublisher;
import publisher_salad.SaladPublisher;
//import publisher_soup.SoupPublisher;
import publisher_soup.SoupPublisher;

public class Activator implements BundleActivator {

	ServiceReference serviceReferenceMilkShake;
	ServiceReference serviceReferenceSalad;
	ServiceReference serviceReferenceSoup;
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		double tot = 0;
		double discount = 0;
		ArrayList<String> PurchasedProducts = new ArrayList<String>();
		int category, type, milkShake, count = 0;
		
		serviceReferenceMilkShake = context.getServiceReference(MilkShakePublisher.class.getName());         
		MilkShakePublisher milkShakePublisher = (MilkShakePublisher) context.getService(serviceReferenceMilkShake);
		
		serviceReferenceSalad = context.getServiceReference(SaladPublisher.class.getName());
		SaladPublisher saladPublisher = (SaladPublisher) context.getService(serviceReferenceSalad);
		
		serviceReferenceSoup = context.getServiceReference(SoupPublisher.class.getName());
		SoupPublisher soupPublisher = (SoupPublisher) context.getService(serviceReferenceSoup);
		
		System.out.println("Welcome to PnS Juice Bar!");
		System.out.println("Regular Customer Started\n");
		
		System.out.println("Fruit Items & Juice :");
		System.out.println("1. Milk Shake");
		System.out.println("2. Salad");
		System.out.println("3. Soup\n");
		
		try {
			System.out.println("Select a Type");
			category = scanner.nextInt();
			
			if(category == 1) {
				System.out.println("\nMilk Shake Types");
				System.out.println("1. Nutella Milk Shake");
				System.out.println("2. Choclate Milk Shake");
				System.out.println("3. Vanila Milk Shake");
				System.out.println("4. Oreo Milk Shake");
				
				System.out.println("\nPress 0 to exit from the System\n");
				
				System.out.println("Select a Milk Shake Type");
				
				type = scanner.nextInt();
				while(type != 0) {
					
					milkShakePublisher.displayMilkShake(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.println("\nSelect Milk Shake Type");
					milkShake = scanner.nextInt();
					
					while( milkShake != -1) {
						tot += milkShakePublisher.getPrice(type,milkShake);
						PurchasedProducts.add(milkShakePublisher.getName(type, milkShake));
						System.out.print("Select Milk Shake Type: ");
						milkShake = scanner.nextInt();
					}
					System.out.println("\nSelect a Milk Shake Type : ");
					type = scanner.nextInt();
				}
				
			}else if(category == 2) {
				System.out.println("Salad Types : ");
				System.out.println("1. Dinner Salad");
				System.out.println("2. Taco Salad");
				System.out.println("3. Chiken Salad");
				System.out.println("4. Fruit Salad");
				
				System.out.println("\nPress O to Exit from the System");
				System.out.print("\nSelect a Salad Type: ");
				type = scanner.nextInt();
				while(type != 0){
					
					saladPublisher.displaySalad(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.print("\nSelect Salad Varient: ");
					milkShake = scanner.nextInt();
					while( milkShake != -1) {
						tot += saladPublisher.getPrice(type, milkShake);
						PurchasedProducts.add(saladPublisher.getName(type, milkShake));
						System.out.print("Select Salad Size: ");
						milkShake = scanner.nextInt();
					}
					System.out.print("\nSelect a Salad Type: ");
					type = scanner.nextInt();
				}
			}
			
			discount = (tot * 5) / 100; 
			System.out.println("Your Purchased Products: " + PurchasedProducts );
			System.out.println("Discount Amount: Rs" + discount);
			System.out.println("Total : Rs" + (tot - discount));
			
		}catch(InputMismatchException e) {
			System.out.println("Please Enter Only Integers! " + e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Regular Customer Stopped.");
		context.ungetService(serviceReferenceMilkShake);
		context.ungetService(serviceReferenceSalad);
		context.ungetService(serviceReferenceSoup);
	}
}
