package data2;

public class Test01실수 {

	public static void main(String[] args) {
		// 실수
		// 소수점이 있는 수
		// 둘이 차이는 표현할수있는리수 차이이며 더 긴값이 들어오면 버침처리 합니다.
		// 실수의 계산은 정확하지않습니다.
		float a = 1.2342342432321321F;
		double b = 1.2343131232132131;
		System.out.println(a);
		System.out.println(b);
		
		//(중요) 정수와 실수를 계산하면? 무조건 실수
		System.out.println(10/3);
		System.out.println(10/3.0);//결과가 double;
		System.out.println(10/3f); // 결과가 float
		System.out.println(10/3d);
	}

}
