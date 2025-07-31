	package api.collection;
	
	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class Test03기억력테스트게임 {
	
		public static void main(String[] args) {
			ArrayList<String>e=new ArrayList<String>();
			Scanner sc=new Scanner(System.in);
			int count=0;
			
			while(true)
			{
				
				String a=sc.next();
				a.replace(" ", "");
				if(e.contains(a)) {
					System.out.println("게임에 패배하셨습니다!");
					break;
				}
				e.add(a);
				System.out.print("편의점에가면 ");
				for(int i=0; i<=count; i++) {
				
				System.out.print(e.get(i)+"도있고 ");
				
				}
				count++;
				
			}
		}
	
	}
