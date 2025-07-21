package data3;

public class Test02성인판정프로그램 {

	public static void main(String[] args) {
		int birth=20051012;
		int current=20250714;
		int koreaAge_y=(current/10000)-(birth/10000)+1;
		
		int passAge=20;
		
		boolean result=koreaAge_y>=passAge;
		
		System.out.println(result);
	}

}
