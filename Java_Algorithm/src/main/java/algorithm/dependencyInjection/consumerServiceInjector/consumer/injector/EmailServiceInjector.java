package algorithm.dependencyInjection.consumerServiceInjector.consumer.injector;

/**
 * __author__ = vyh@vmware.com
 */
import algorithm.dependencyInjection.consumerServiceInjector.consumer.Consumer;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.MyDIApplication;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}