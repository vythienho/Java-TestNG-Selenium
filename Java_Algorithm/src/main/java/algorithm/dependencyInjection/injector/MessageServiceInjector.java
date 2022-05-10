package algorithm.dependencyInjection.injector;

/**
 * __author__ = vyh@vmware.com
 */

import algorithm.dependencyInjection.consumer.Consumer;

public interface MessageServiceInjector {

	public Consumer getConsumer();
}
