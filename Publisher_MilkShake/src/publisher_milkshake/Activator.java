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
		System.out.println("Milk Shake Publisher has Started.");
        MilkShakePublisher milkShakePublisher = new ServicePublisherImpl();
        this.publisherServiceRegistration = context.registerService(MilkShakePublisher.class.getName(), milkShakePublisher, (Dictionary)null);
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Milk Shake has Stopped");
		this.publisherServiceRegistration.unregister();
	}

}
