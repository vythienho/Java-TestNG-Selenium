package algorithm.dependencyInjection.injector;

/**
 * __author__ = vyh@vmware.com
 */
import algorithm.dependencyInjection.consumer.Consumer;
import algorithm.dependencyInjection.consumer.MyDIApplication;
import algorithm.dependencyInjection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}