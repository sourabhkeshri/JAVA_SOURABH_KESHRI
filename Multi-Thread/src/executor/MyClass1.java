package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class MyTask implements Runnable{

	@Override
	public void run() {
		IntStream.of(1,2,3,4,5).forEach(e->System.out.println(e));
		
	}
	
}



public class MyClass1 {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(5);
		
		exe.execute(new MyTask());
		exe.execute(new MyTask());
	}
	

}
