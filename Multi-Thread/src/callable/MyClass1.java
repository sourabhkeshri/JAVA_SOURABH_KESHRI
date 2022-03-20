package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyMath{
	public static int add(int a, int b) {
		return (a+b);
	}
}


class MyCall implements Callable<Integer>{

	int x,y;
	public MyCall(int x,int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public Integer call() throws Exception {
		MyMath.add(x, y);
		return null;
	}
	
}



public class MyClass1 {

	public static void main(String[] args) {
		int a=10;
		int b = 20;
		
		ExecutorService exe = Executors.newFixedThreadPool(1);
		exe.submit(new MyCall(a,b));
		int result = MyMath.add(a, b);
		System.out.println(result);

	}

}
