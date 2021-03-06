package deadlock;

class Writer1 extends Thread{
	Object book;
	Object pen;
	
	public Writer1(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}
	
	
	public void run() {
		synchronized(book){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(pen) {
				System.out.println("Writer1 is writting..");
			}
		}
	}
}

class Writer2 extends Thread{
	Object book;
	Object pen;
	
	public Writer2(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}
	
	
	public void run() {
		synchronized(pen){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(book) {
				System.out.println("Writer2 is writting..");
			}
		}
	}
}



public class DeadLockDemo {

	public static void main(String[] args) {
		
		Object book = new Object();
		Object pen = new Object();

		new Writer1(book,pen).start();
		new Writer2(book,pen).start();
		
		System.out.println("Main is done");
		/*solution is to set the same order of objects lock*/
		
	}

}
