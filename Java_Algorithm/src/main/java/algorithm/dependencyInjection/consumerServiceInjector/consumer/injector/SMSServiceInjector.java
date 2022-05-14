package algorithm.dependencyInjection.consumerServiceInjector.consumer.injector;

/**
 * __author__ = vyh@vmware.com
 */
import algorithm.dependencyInjection.consumerServiceInjector.consumer.Consumer;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.MyDIApplication;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}