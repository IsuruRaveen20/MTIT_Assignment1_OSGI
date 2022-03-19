package new_customer;

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
		MilkShakePublisher milkShakePublisher = (MilkShakePublisher) context.getService(serviceReferenceMilkShake);
        
		serviceReferenceSalad = context.getServiceReference(SaladPublisher.class.getName());
		SaladPublisher saladPublisher = (SaladPublisher) context.getService(serviceReferenceSalad);
    
        System.out.println("New Customer Started.");
        System.out.println("Fruit Items & Juice : ");
        System.out.println("1. Milk Shake");
        System.out.println("2. Salad\n");
        
        double total = 0;
        int category, type, sel;
        ArrayList<String> PurchasedItems = new ArrayList<String>(); //should be changed purchase item
        
        try {
			System.out.print("Select a Type: ");
			category = scanner.nextInt();

			if (category == 1) {
				System.out.println("\nMilk Shake Types: ");
				System.out.println("1. Nutella Milk Shake");
				System.out.println("2. Choclate Milk Shake");
				System.out.println("3. Vanila Milk Shake");
				System.out.println("4. Oreo Milk Shake");

				System.out.println("\nPress O to Exit from the System\n");
				System.out.print("Select a type: ");
				type = scanner.nextInt();

				while (type != 0) {

					milkShakePublisher.displayMilkShake(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.print("\nSelect a Milk Shake Option : ");
					sel = scanner.nextInt();
					while (sel != -1) {
						total += milkShakePublisher.getPrice(type, sel);
						PurchasedItems.add(milkShakePublisher.getName(type, sel));
						System.out.print("Select Milk Shake Option : ");
						sel = scanner.nextInt();

					}
					System.out.print("\nSelect a Milk Shake Option: ");
					type = scanner.nextInt();
				}

			} else if (category == 2) {
				System.out.println("\nSalad Type: ");
				System.out.println("1.  Dinner Salad");
				System.out.println("2.  Taco Salad");
				System.out.println("3.  Chickern Salad");
				System.out.println("4.  Fruit Salad");

				System.out.println("\nPress O to Exit");
				System.out.print("\nSelect a Salad type: ");
				type = scanner.nextInt();
				while (type != 0) {

					saladPublisher.displaySalad(type);
					System.out.println("\nType -1 to exit from the Current Type.");
					System.out.print("\nSelect Salad Size: ");
					sel = scanner.nextInt();
					while (sel != -1) {
						total += saladPublisher.getPrice(type, sel);
						PurchasedItems.add(saladPublisher.getName(type, sel));
						System.out.print("Select Salad Size: ");						 //check size
						sel = scanner.nextInt();
					}
					System.out.print("\nSelect a Salad Type: ");
					type = scanner.nextInt();
				}
			}
			System.out.println("Purchased Items: " + PurchasedItems);

			System.out.println("Total : Rs" + total);
		} catch (InputMismatchException e) {
			System.out.println("The value should be Integer.! " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("New Coustomer Has Stopped.");
		context.ungetService(serviceReferenceMilkShake);
		context.ungetService(serviceReferenceSalad);
	}

}
