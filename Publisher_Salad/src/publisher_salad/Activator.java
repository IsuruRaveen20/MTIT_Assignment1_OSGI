package publisher_salad;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	ServiceRegistration publisherServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Salad Publisher has Started.");
		SaladPublisher saladPublisher = new ServicePublisherImpl();
		
		publisherServiceRegistration = context.registerService(SaladPublisher.class.getName(), saladPublisher,null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Salad Publisher has Stopped");
		publisherServiceRegistration.unregister();
	}

}
