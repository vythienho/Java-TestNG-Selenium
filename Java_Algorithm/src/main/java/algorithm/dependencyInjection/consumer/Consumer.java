package algorithm.dependencyInjection.consumer;

/**
 * __author__ = vyh@vmware.com
 */
public interface Consumer {

	void processMessages(String msg, String rec);
}
