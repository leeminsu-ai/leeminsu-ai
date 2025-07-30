package api.util.scanner;
import java.util.Scanner;
public class Test03패턴분석2 {

	public static void main(String[] args) {
		String rainbow="빨강+주황=노랑/초록-파랑-남색=보라";
		Scanner sc=new Scanner(rainbow);
		sc.useDelimiter("[^가-힣]"); //이제부터 단어의 구분을 +라고해라
		while(sc.hasNext()) {
			String color=sc.findInLine("[가-힣]");
			System.out.println("color="+color);
			
		}
	}

}
