package level1;

public class ex {

	public static void main(String[] args) {
		int i = 1;
		int j = i++;
		
		System.out.println("후위연산자");
		System.out.println("i의 값은 "+i); // 2
		System.out.println("j의 값은 "+j); // 1
	
		int x = 1;
		int y = ++x;
		System.out.println("\n전위 연산자");
		System.out.println("x의 값은 "+x); // 2
		System.out.println("y의 값은 "+y); // 2

		String c = "hello";
		String d = "hello";
		System.out.println(c==d); // true

		System.out.println();
		
	}

}
