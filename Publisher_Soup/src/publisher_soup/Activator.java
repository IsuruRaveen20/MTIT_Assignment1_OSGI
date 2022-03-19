package publisher_soup;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publisherServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Soup Publisher Started\n");
		
		SoupPublisher pizzaPublisher = new ServicePublisherImpl();
		publisherServiceRegistration = context.registerService(SoupPublisher.class.getName(), pizzaPublisher, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Soup Publisher Stopped");
		publisherServiceRegistration.unregister();
	}

}
