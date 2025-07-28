package keyword4;

public class Test01불변처리 {

	public static void main(String[] args) {
		int number=10;
		number=20;
		number=30;
		System.out.println("number="+number);
		
		final int minutePerHour=60;
		// minutePerHour=70;  final을 쓰면 수정을못함(덮어쓰기X)
		
	}

}
