package callable;


class MyMath{
	public static int add(int a, int b) {
		return (a+b);
	}
}




public class MyClass1 {

	public static void main(String[] args) {
		int a=10;
		int b = 20;
		
		int result = MyMath.add(a, b);
		System.out.println(result);

	}

}
