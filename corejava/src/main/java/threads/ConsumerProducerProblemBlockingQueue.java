package threads;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerProblemBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();
		BlockingProducer producer = new BlockingProducer(sharedQueue);
		BlockingConsumer consumer = new BlockingConsumer(sharedQueue);
		Thread pthread = new Thread(producer);
		Thread cthread = new Thread(consumer);
		pthread.start();
		cthread.start();
		
	}

}

class BlockingProducer implements Runnable
{
	private BlockingQueue<String> sharedQueue;

	public BlockingProducer(BlockingQueue<String> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() 
	{
		while(true){
			String str = new Date().toString();
			System.err.println("Produced:"+str);
			try {
			sharedQueue.put(str);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void produce(String str)
	{
		
	}
	
}



class BlockingConsumer implements Runnable
{
	private BlockingQueue<String> sharedQueue;
	
	public BlockingConsumer(BlockingQueue<String> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		while(true)
		{
			try {
				String string = sharedQueue.take();
                System.out.println("Consumed: " + string);
               // Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
		}
		
	}
	
}
