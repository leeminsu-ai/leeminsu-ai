package test;

public class Test06객체지향에서의예외처리 {

	public static void main(String[] args) {
		try {
			int result=Calculator.div(1, 5);
			System.out.println("result="+result);
			
		}
		catch(Exception e) {
			System.err.println("오류발생");
		}
	}

}
