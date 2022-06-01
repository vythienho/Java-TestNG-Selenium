package smallprojects.producerConsumer;

/**
 * __author__ = vyh@vmware.com
 */
public class Message {
	private int id;
	private double data;

	Message(int id, double data){
		this.id = id;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message{" +
			"id=" + id +
			", data=" + data +
			'}';
	}
}
