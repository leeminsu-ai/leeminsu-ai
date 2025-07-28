package api.lang.string;
import java.util.Scanner;
public class Login {

	public static void main(String[] args) {
		StringBuffer id=new StringBuffer("khacademy");
		StringBuffer password=new StringBuffer("master");
		
		Scanner sc=new Scanner(System.in);
		String enter_id=sc.next();
		String enter_password=sc.next();
		
		
		
		
	if(enter_id.equals(id)&&enter_password.equals(enter_password))
	{
		System.out.println("로그인성공");
	}
		
	else
	{
		System.out.println("로그인실패");
	}
	}

}
