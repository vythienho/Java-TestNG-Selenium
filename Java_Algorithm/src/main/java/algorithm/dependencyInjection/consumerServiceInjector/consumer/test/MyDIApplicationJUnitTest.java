package algorithm.dependencyInjection.consumerServiceInjector.consumer.test;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 */
import algorithm.dependencyInjection.consumerServiceInjector.consumer.injector.MessageServiceInjector;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithm.dependencyInjection.consumerServiceInjector.consumer.Consumer;
import algorithm.dependencyInjection.consumerServiceInjector.consumer.MyDIApplication;
//import algorithm.dependencyInjection.injector.EmailServiceInjector;

//import algorithm.dependencyInjection.injector.SMSServiceInjector;


public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {

			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");

					}
				});
			}
		};
	}

	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}

	@After
	public void tear(){
		injector = null;
	}

}