package producerconsumer;

import java.util.concurrent.SynchronousQueue;

public class StartProcess {

	SynchronousQueue<Task> queue = new SynchronousQueue();

	public static void main(String[] args) {
		new StartProcess().startProducerConsumer();
	}

	private void startProducerConsumer() {

		Producer p1 = new Producer(queue,2, true);
		Producer p2 = new Producer(queue,3, false);

		Consumer c1 = new Consumer(queue,1, false);
		Consumer c2 = new Consumer(queue,3, true);
		Consumer c3 = new Consumer(queue,2, false);

		new Thread(p1).start();
		new Thread(p2).start();

		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();

	}

}
