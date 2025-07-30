package api.util.scanner;

import java.util.Scanner;
public class Test02키보드입력 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("이름:");
		String name=sc.next();
		
		System.out.print("나이:");
		int age=sc.nextInt(); // 
		System.out.print("주소");
		sc.nextLine();
		String addr=sc.nextLine();
		
		sc.close();
		System.out.println("name="+name);
		System.out.println("age="+age);
		System.out.println("addr="+addr);
	}

}
