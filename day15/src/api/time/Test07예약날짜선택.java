package api.time;
import java.util.Scanner;
public class Test07예약날짜선택 {

	public static void main(String[] args) {
		//사용자에게 날짜를 문자열로 입력받아 예약 확정 메세지를 출력
		try {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("예약 희망날짜:");
		String date=sc.nextLine();
		
		//문제가있는상황들을 catch로 throw한다.
		
		
		
		sc.close();
		
		System.out.println("[+date+] 예약이 확정되었습니다");
		}
		catch(Exception e) {
			System.err.println("예약 과정에서 문제가발생");
			if(e.getMessage()!=null) {
				System.err.println("->"+e.getMessage());
			}
		}
		
	}

}
