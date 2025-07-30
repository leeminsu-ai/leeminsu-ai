package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Testmessage {
	public static void main(String[] args) {
		//상황별 플랜B를 추가
		//- try~catch 구문을 사용
		//- try에는 플랜A를 작성하고 catch에는 플랜B와 문제상황을 작성
		
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : ");
			int money = sc.nextInt();
			if(money<0) {
				throw new Exception("금액은 음수일 수가없음.");
			}
			System.out.print("인원수 : ");
			int people = sc.nextInt();
			sc.close();
			 
			int price = money / people;
			int remain = money % people;
			
			System.out.println("1인당 금액 : " + price+"원");
			System.out.println("자투리 금액 "+remain+"원은 저희가 내드려요!");
		}
		catch(Exception e) {
			if(e.getMessage()==null) {
				System.out.println("프로그램에서 오류가 발생했습니다");
			}
			else {
				System.out.println("오류발생 "+e.getMessage());
			}
			
		}
		
		
	}
}



