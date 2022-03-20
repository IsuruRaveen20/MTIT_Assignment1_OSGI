package new_customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import publisher_milkshake.MilkShakePublisher;
import publisher_salad.SaladPublisher;
import publisher_soup.SoupPublisher;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReferenceMilkShake;
    ServiceReference serviceReferenceSalad;
    ServiceReference serviceReferenceSoup;
    
    Scanner scanner = new Scanner(System.in);

	@Override
	public void start(BundleContext context) throws Exception {
		
		double total = 0;
	    int category, type = 0;
	    int checker; //use to identify -1 press to exit or not
	    ArrayList<String> PurchasedOrder = new ArrayList<String>(); 
	    
	    //Service Reference for MilkShake service
		serviceReferenceMilkShake = context.getServiceReference(MilkShakePublisher.class.getName());
		MilkShakePublisher milkShakePublisher = (MilkShakePublisher) context.getService(serviceReferenceMilkShake);
        
		//Service Reference for Salad service
		serviceReferenceSalad = context.getServiceReference(SaladPublisher.class.getName());
		SaladPublisher saladPublisher = (SaladPublisher) context.getService(serviceReferenceSalad);
		
		//Service Reference for Soup service
		serviceReferenceSoup = context.getServiceReference(SoupPublisher.class.getName());
		SoupPublisher soupPublisher = (SoupPublisher) context.getService(serviceReferenceSoup);
		
		
		System.out.println("Welcome to PnS Juice Bar!");
		
        System.out.println("New Customer Started\n");
        
        //Display Food Options
        System.out.println("Fruit Items & Juice : ");
        System.out.println("1. Milk Shake");
        System.out.println("2. Salad");
        System.out.println("3. Soup\n");
        
        
        try {
			System.out.print("Select a Type: ");
			category = scanner.nextInt();
			
			//MilkShake Category
			if (category == 1) {
				
				//Display Available Options
				System.out.println("\nMilk Shake Types: ");
				System.out.println("1. Nutella Milk Shake");
				System.out.println("2. Choclate Milk Shake");
				System.out.println("3. Vanila Milk Shake");
				System.out.println("4. Oreo Milk Shake");

				System.out.println("\nPress O to Exit from the System\n");
				System.out.print("Select a type: ");
				
				//Getting input via keyboard
				type = scanner.nextInt();

				while (type != 0) {

					milkShakePublisher.displayMilkShake(type);
					System.out.println("\nType -1 to Leave from the Current Type.");
					System.out.print("\nSelect a Milk Shake Option : ");
					checker = scanner.nextInt();
					while (checker != -1) {
						total += milkShakePublisher.getPrice(type, checker);
						PurchasedOrder.add(milkShakePublisher.getName(type, checker));
						System.out.print("Select Milk Shake Option : ");
						checker = scanner.nextInt();
//						System.out.print(checker);

					}
					System.out.print("\nSelect a Milk Shake Option: ");
					type = scanner.nextInt();
				}

			//Salad Category
			} else if (category == 2) {
				
				//Display Available Options
				System.out.println("\nSalad Type: ");
				System.out.println("1.  Dinner Salad");
				System.out.println("2.  Taco Salad");
				System.out.println("3.  Chicken Salad");
				System.out.println("4.  Fruit Salad");

				System.out.println("\nPress O to Exit from the System");
				System.out.print("\nSelect a Salad type: ");
				
				//Getting input via keyboard
				type = scanner.nextInt();
				while (type != 0) {

					saladPublisher.displaySalad(type);
					System.out.println("\nType -1 to Leave from the Current Type.");
					System.out.print("\nSelect Salad Varient: ");
					checker = scanner.nextInt();
					while (checker != -1) {
						total += saladPublisher.getPrice(type, checker);
						PurchasedOrder.add(saladPublisher.getName(type, checker));
						System.out.print("Select Salad Varient: ");						 
						checker = scanner.nextInt();
					}
					System.out.print("\nSelect a Salad Varient: ");
					type = scanner.nextInt();
				}
			}
			
			//Soup Category
			else if(category == 3) {
				
				//Display Available Options
				System.out.println("Soup Types : ");
				System.out.println("1. Chiken Soup");
				System.out.println("2. Vegitable Soup");
				System.out.println("3. Noodles Soup");
				System.out.println("4. SeaFood Soup");
				
				System.out.println("\nPress O to Exit from the System");
				System.out.print("\nSelect a Soup Type: ");
				
				//Getting input via keyboard
				type = scanner.nextInt();
				while(type != 0){
					
					soupPublisher.displaySoup(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.print("\nSelect Soup Varient: ");
					checker = scanner.nextInt();
					while( checker != -1) {
						total += soupPublisher.getPrice(type, checker);
						PurchasedOrder.add(soupPublisher.getName(type, checker));
						System.out.print("Select Soup Varient: ");
						checker = scanner.nextInt();
					}
					System.out.print("\nSelect a Soup Varient: ");
					type = scanner.nextInt();
				}
			}
			System.out.println("Your Order: " + PurchasedOrder);

			System.out.println("Total : Rs" + total);
		} catch (InputMismatchException e) {
			System.out.println("The value should be Only Integer.! " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("New Customer Stopped.");
		System.out.println("Thank you, Come Again!!");
		context.ungetService(serviceReferenceMilkShake);
		context.ungetService(serviceReferenceSalad);
		context.ungetService(serviceReferenceSoup);
	}

}
