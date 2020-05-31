package producerconsumer;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

	SynchronousQueue<Task> queue;
	int sleepTime;
	boolean flag;

	public Producer(SynchronousQueue<Task> queue, int sleepTime, boolean flag) {
		this.queue = queue;
		this.sleepTime = sleepTime;
		this.flag = flag;
	}

	@Override
	public void run() {
		while (true) {
			int n = new Random().nextInt();
			byte[] array = new byte[7];
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			try {
				Task task = new Task(generatedString, n);
				TimeUnit.SECONDS.sleep(sleepTime);
				if (flag)
					throw new Exception(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName() + " -- added --" + task);
				queue.put(task);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
