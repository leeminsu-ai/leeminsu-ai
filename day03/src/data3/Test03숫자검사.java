package data3;

public class Test03숫자검사 {

	public static void main(String[] args) {
		int number=71;
		boolean evenNum=number%2==0;
		boolean threeOfmultiple=number%3==0;
		
		
		boolean sevenInclude=number%10==7||number/10==7;
		//두자리수만 가능
		System.out.println(evenNum);
		System.out.println(threeOfmultiple);
		System.out.println(sevenInclude);
		
		//반복문 사용
		//while(number/10!=0)
		//if(number%10==7)
		// sevenInclude==true;
	}
		
}
