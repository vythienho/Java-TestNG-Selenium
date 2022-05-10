package algorithm.dependencyInjection.test;

/**
 * __author__ = vyh@vmware.com
 *
 * https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 * Dependency Injection solves legacy problem with hardcoded dependencies as in the tutorial.
 * Solves the issue by injecting dependencies as needed.
 *
 * 1. Service components should be designed with base class or interface. It’s better to prefer
 * interfaces or abstract classes that would define contract for the services.
 * 2. Consumer classes should be written in terms of service interface.
 * 3. Injector classes that will initialize the services and then the consumer classes.
 */

import algorithm.dependencyInjection.consumer.Consumer;
import algorithm.dependencyInjection.injector.EmailServiceInjector;
import algorithm.dependencyInjection.injector.MessageServiceInjector;
import algorithm.dependencyInjection.injector.SMSServiceInjector;

public class MyMessageDITest {
	public static void main(String[] args) {
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;

		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);

		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}
}
