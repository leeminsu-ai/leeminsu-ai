package test;
import java.util.Scanner;
public class Test07계좌이체프로그램만들기 {

	public static void main(String[] args) {
		String banknum;
		int money=10000000;
		 int password=0;
		 int once=0;
		 Scanner sc=new Scanner(System.in);
		
		try {
			
			String regex="[0-9]{3}-[0-9]{2}-[0-9]{6}";
			 
			 if(money<0) {
					throw new Exception("돈이 음수가 될수가없습니다");
				}
			 
			 System.out.println("비밀번호를입력해주세요");
			 password=sc.nextInt();
			 
				if(password==1234) {
					System.out.println("계속진행");
				}
				else {
					throw new Exception("비밀번호가 일치하지 않습니다");
				}
				
				System.out.println("계좌번호를 입력해주세요");
				banknum=sc.next();
				
				if(banknum.matches(regex)) {
					System.out.println("계속진행");
				}
				else {
					throw new Exception("계좌번호 양식이 틀렸습니다");
				}
				
				System.out.println("이체할 금액을 입력해주세요");
				once=sc.nextInt();
				
				
				
				if(once<=1000000) {
					System.out.println("잠시만기다려주세요.");
					System.out.println("정상적으로 처리되었습니다");
				}
				
				
				
		}
			
		
		catch(Exception e){
			System.out.println("오류발생:"+e.getMessage());
			
		}
		
		
		
		
		
	}

}
