package day18과제풀이;

import java.util.Scanner;

public class Test04윈도우탐색기5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WindowExplorer explorer = new WindowExplorer();
		
		while(true) {
			//목록 출력
			explorer.show();
			
			System.out.print("입력 : ");
			String command = sc.nextLine();
			
			if(command.equals("종료")) break;
			
			if(command.equals("../"))
				explorer.moveToParent();
			else if(command.equals("/"))
				explorer.moveToRoot();
			else 
				explorer.move(command);
		}
		
		sc.close();
	}

}
