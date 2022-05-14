package algorithm.dependencyInjection.consumerServiceInjector.consumer.service;

/**
 * __author__ = vyh@vmware.com
 */
public class SMSServiceImpl implements MessageService {

	@Override
	public void sendMessage(String msg, String rec) {
		//logic to send SMS
		System.out.println("SMS sent to "+rec+ " with Message="+msg);
	}

}
