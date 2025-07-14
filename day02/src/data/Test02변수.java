package data;

public class Test02변수 {

	public static void main(String[] args) {
		//본격적인 변수 사용
		//형태와 이름 값이 있어야함
		byte a=100;
		//byte b=200; //범위초과
		System.out.println(a);
		
		int num=3000;
		System.out.println(num);
		num=9999;
		System.out.println(num);
		
		long over=2200000000L; //은 꼭표시를해야함
		System.out.println(over);
		
		long oVer=300000000L; //자바는 대소문자를 구분함.
		
		long n=1234567; 
		long m=n+n;
		long o=n*n;
		System.out.println(m);
		System.out.println(o);
		
		//(중요)정수의 계산결과는 언제나 정수이다.
		//특히 나눗셈을 조심.
		
		int apple=10;
		int people=3;
		System.out.println(apple/people); // 한 사람이 받을 사과개수
		System.out.println(apple%people); // 남는 사과개수
		
		
	}

}
