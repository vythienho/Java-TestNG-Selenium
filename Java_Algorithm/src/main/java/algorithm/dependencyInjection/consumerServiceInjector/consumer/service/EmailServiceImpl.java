package algorithm.dependencyInjection.consumerServiceInjector.consumer.service;

/**
 * __author__ = vyh@vmware.com
 */
public class EmailServiceImpl implements MessageService {

	@Override
	public void sendMessage(String msg, String rec) {
		//logic to send email
		System.out.println("Email sent to "+rec+ " with Message="+msg);
	}

}
