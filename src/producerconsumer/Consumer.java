package producerconsumer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	SynchronousQueue<Task> queue;
	int sleepTime;
	boolean flag;

	public Consumer(SynchronousQueue<Task> queue, int sleepTime, boolean flag) {
		this.queue = queue;
		this.sleepTime = sleepTime;
		this.flag = flag;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(sleepTime);
				if (flag)
					throw new Exception(Thread.currentThread().getName());
				Task task = queue.take();
				System.out.println(Thread.currentThread().getName() + " -- work on task -- " + task.toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Repare the thread \n");
				this.flag = false;
				e.printStackTrace();
			}
		}

	}

}
