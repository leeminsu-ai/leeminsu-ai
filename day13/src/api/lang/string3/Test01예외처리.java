package api.lang.string3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test01예외처리 {

	public static void main(String[] args) {
		//에러-프로그램이 실행될수 없는 상황과 이유(코드로 해결불가)
		//예외-프로그램 실행중에 발생하는 돌발상황(코드로 해결 가능)
		//(Ex) 1/n 게산기-사용자에게 금액과 인원수를 입력받아 1인당 금액과 자투리를 출력
		
	// 상황별 플랜B를 추가
	//try~catch 구문을 사용
	//try에는 플랜 A를 작성하고  catch에는 플랜 B와 문제상황을 작성
		
		
	
		
		try {
			Scanner sc=new Scanner(System.in);
			int sum=sc.nextInt();
			int num=sc.nextInt();
			int sum_result=sum/num;
			int num_result=sum%num;
			System.out.println(sum_result);
			System.out.print(num_result);
		}
		catch(InputMismatchException e){
			System.out.println("잘못 입력하셨습니다");
		}
		catch(ArithmeticException e){
			System.out.println("인원수는 0일수가없습니다");
		}
		//catch(RuntimeException e) <--- 상위개념
		//System.out.println("입력오류가발생했습니다
		
	}

}
