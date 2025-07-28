package api.lang.string;
import java.util.Scanner;

public class Test06쿵쿵따 {

	public static void main(String[] args) {
		String a;
		Scanner sc=new Scanner(System.in);
		
		a=sc.next();
		System.out.print(a+"!"+ " 쿵쿵따!");
		
		
		while(true)
		{
			char temp=a.charAt(a.length()-1); //마지막
			String next=sc.next();
			if((next.length()==3)&&(next.charAt(0)==temp))
			{
				System.out.print(next+"!"+ " 쿵쿵따!");
				a=next;
			}
			else {
				System.out.println("Gave over!!");
			}
			
	
			
			
			
			
			
		}
		
		
	}

}
