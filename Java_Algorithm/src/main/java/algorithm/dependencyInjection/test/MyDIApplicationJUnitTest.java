package algorithm.dependencyInjection.test;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithm.dependencyInjection.consumer.Consumer;
import algorithm.dependencyInjection.consumer.MyDIApplication;
import algorithm.dependencyInjection.service.MessageService;
//import algorithm.dependencyInjection.injector.EmailServiceInjector;
import algorithm.dependencyInjection.injector.MessageServiceInjector;
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