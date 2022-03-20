package publisher_milkshake;

import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration publisherServiceRegistration;
	
	public Activator() {
    }
	
	public void start(BundleContext context) throws Exception {
		System.out.println("\nMilk Shake Publisher Started\n");
		
        MilkShakePublisher milkShakePublisher = new ServicePublisherImpl();
        publisherServiceRegistration = context.registerService(MilkShakePublisher.class.getName(), milkShakePublisher,null);
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Milk Shake Publisher Stopped");
		publisherServiceRegistration.unregister();
	}

}
