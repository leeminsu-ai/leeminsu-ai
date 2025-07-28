package api.lang.string;
import java.util.Scanner;
public class Test08욕설필터링프로그램 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		String operator="운영자";
		String[] bad= {"십장생","수박씨","조카","주옥","개나리","신발끈","시베리아","십자수","시방","빙수"};
		
		if(line.contains(operator)) {
			line=line.replace(operator,"###");
			
		}
		for(int i=0; i<bad.length; i++) {
			
			
		
		if(line.contains(bad[i]))
		{
			String star="*".repeat(bad[i].length());
			line=line.replace(bad[i], star);
		
			
		}
		}
		System.out.println(line);
		
	}

}
