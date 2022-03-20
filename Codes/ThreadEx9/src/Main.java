import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample {
	
	private int x;
	
	ReadWriteLock rw_lock = new ReentrantReadWriteLock();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void incr() {
		
		Lock lock = rw_lock.writeLock();
		lock.lock();
		try {
		
			int y = getX();
			y++;
			
			// Just for simulation
			try { Thread.sleep(1); } catch(Exception e) {}
			
			setX(y);
		} finally {
			lock.unlock();
		}
		
	}
	
}

class MyThread extends Thread {
	
	Sample obj;
	
	public MyThread(Sample obj) {
		this.obj = obj;
	}
	
	public void run() {
		obj.incr();
	}
	
}


public class Main {

	public static void main(String[] args) {

		Sample obj = new Sample();
		obj.setX(10);
		
		MyThread t1 = new MyThread(obj);
		MyThread t2 = new MyThread(obj);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println( obj.getX() );
		
	}

}
