package data3;

public class Test04논리연산 {

	public static void main(String[] args) {
		//청소년인지 판정후 출력
		// 청소년은 14세부터 19세 까지를말한다
		
		int age=17;
		boolean result=age>=14&&age<=19;
		
		System.out.println(result);
		
		boolean free=age>=65||age<8;
		System.out.println(free);
	}

}
