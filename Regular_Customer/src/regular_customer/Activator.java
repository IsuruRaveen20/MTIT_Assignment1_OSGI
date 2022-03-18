package regular_customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import publisher_milkshake.MilkShakePublisher;
import publisher_salad.SaladPublisher;


public class Activator implements BundleActivator {

	ServiceReference serviceReferenceMilkShake;
	ServiceReference serviceReferenceSalad;
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		serviceReferenceMilkShake = context.getServiceReference(MilkShakePublisher.class.getName());         
		MilkShakePublisher burgerPublisher = (MilkShakePublisher) context.getService(serviceReferenceMilkShake);
		
		serviceReferenceSalad = context.getServiceReference(SaladPublisher.class.getName());
		SaladPublisher pizzaPublisher = (SaladPublisher) context.getService(serviceReferenceSalad);
		
		System.out.println("Regular Customer has Started.");
		
		System.out.println("Fruit Items & Juice :");
		System.out.println("1. Milk Shake");
		System.out.println("2. Salad\n");
		
		double total = 0;
		double dis = 0;
		ArrayList<String> PurchasedItems = new ArrayList<String>();
		int category, type, sel, count =0;
		
		try {
			System.out.println("Select a Type");
			category = scanner.nextInt();
			
			if(category == 1) {
				System.out.println("\nMilk Shake Types");
				System.out.println("1. Nutella Milk Shake");
				System.out.println("2. Choclate Milk Shake");
				System.out.println("3. Vanila Milk Shake");
				System.out.println("4. Oreo Milk Shake");
				
				System.out.println("\nPress 0 to exit\n");
				
				System.out.println("Select a Milk Shake Type");
				
				type = scanner.nextInt();
				while(type != 0) {
					
					milkShakePublisher.displayMilkShake(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.println("\nSelect Milk Shake Type");
					sel = scanner.nextInt();
					while( sel != -1) {
						total += milkShakePublisher.getPrice(type,sel);
						PurchasedItems.add(milkShakePublisher.getName(type, sel));
						System.out.print("Select Milk Shake Type: ");
						sel = scanner.nextInt();
					}
//					return 0;
					System.out.println("\nSelect a Milk Shake Type : ");
					type = scanner.nextInt();
				}
				
			}else if(category == 2) {
				System.out.println("Salad Types : ");
				System.out.println("1. Dinner Salad");
				System.out.println("2. Taco Salad");
				System.out.println("3. Chiken Salad");
				System.out.println("4. Fruit Salad");
				
				System.out.println("\nPress O to Exit");
				System.out.print("\nSelect a Salad Type: ");
				type = scanner.nextInt();
				while(type != 0){
					
					saladPublisher.displaySalad(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.print("\nSelect Salad Varient: ");
					sel = scanner.nextInt();
					while( sel != -1) {
						total += saladPublisher.getPrice(type, sel);
						PurchasedItems.add(saladPublisher.getName(type, sel));
						System.out.print("Select Salad Size: ");
						sel = scanner.nextInt();
					}
					System.out.print("\nSelect a Salad Type: ");
					type = scanner.nextInt();
				}
			}
			dis = (total * 5) / 100; 
			System.out.println("Purchased Items: " + PurchasedItems );
			System.out.println("Discount Amount: Rs" + dis);
			System.out.println("Total : Rs" + (total - dis));
		}catch(InputMismatchException e) {
			System.out.println("Integer Should be Entered.! " + e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Regular Coustomer Has Stopped.");
		context.ungetService(serviceReferenceMilkShake);
		context.ungetService(serviceReferenceSalad);
	}

}
