package threads;

import java.util.Date;
import java.util.Vector;

public class ConsumerProducerProblem {

	public static void main(String[] args) {
		Vector<String> sharedQueue = new Vector<String>();
		int size =5;
		Producer producer = new Producer(sharedQueue, size);
		Consumer consumer = new Consumer(sharedQueue);
		Thread pthread = new Thread(producer);
		Thread cthread = new Thread(consumer);
		pthread.start();
		cthread.start();
		
	}

}

class Producer implements Runnable
{
	private Vector<String> sharedQueue;
	private int size;

	public Producer(Vector<String> sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.size = size;
	}

	public void run() 
	{
		while(true){
			produce(new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void produce(String str)
	{
		if(sharedQueue.size() == size)
		{
			synchronized (sharedQueue) {
				System.err.println("Queue is full.");
				try {
					sharedQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedQueue) {
			System.err.println("Produced:"+str);
			sharedQueue.add(str);
			sharedQueue.notifyAll();
		}
	}
	
}



class Consumer implements Runnable
{
	private Vector<String> sharedQueue;
	
	public Consumer(Vector<String> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		while(true)
		{
			try {
                System.out.println("Consumed: " + consume());
               // Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
		}
		
	}
	
	public String consume() 
	{
		while(sharedQueue.isEmpty())
		{
			synchronized (sharedQueue) {
				System.err.println("Queue is empty");
				try {
					sharedQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			String str = sharedQueue.remove(0);
			return str;
		}
	}

	
	
}
