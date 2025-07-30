package api.time;
import java.util.Scanner;
public class Test01Scanner클래스2 {

	public static void main(String[] args) {
		//Scanner 클래스
		//문자열 패턴 분석 추출기
		//제공되는 문자열에 원하는 데이터 부분만 추출할수있음
		//next()계열의 명령들은 공백(스페이스,탭,개행)을 기준으로 데이터를 읽는다.
		//nextLine()은 \n이 나오기전까지만 읽어서 반환.
		String example= "노는게 제일좋아 친구들 모여라 언제나 즐거워 뽀롱뽀롱 뽀로로";
		Scanner sc=new Scanner(example);
		
		while(sc.hasNextLine()) {
			if(sc.hasNext()==false)break;
			String word=sc.next();
			System.out.println("word="+word);
		}
		sc.close();
		

	}

}
