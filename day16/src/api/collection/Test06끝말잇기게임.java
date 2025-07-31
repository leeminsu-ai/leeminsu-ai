package api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Test06끝말잇기게임 {

	public static void main(String[] args) {
		List<String>keyword=new ArrayList<String>(Arrays.asList("사과","바나나","자동차","기차","학교","모자","고양이","냉장고","컴퓨터","달력"));
		List<String>tell=new ArrayList<String>();
		Random random=new Random();
		String current=keyword.get(random.nextInt(keyword.size()));
		Scanner sc=new Scanner(System.in);
		System.out.println(current);
		
		while(true) {
			
			String temp_2;
				String temp=current.substring(current.length()-1);
				temp_2=sc.nextLine();
				if(temp_2.length()<2) //정규표현식으로 하는게더좋다
				{
					System.out.println("단어 2개이상 입력해야됩니다!");
					System.out.println("게임오버!");
					break;
				}
				
				if(temp_2.contains(" ")) //정규표현식을 한번에묶는게더좋다 
				{
					System.out.println("공백을 입력하면 안됩니다!");
					System.out.println("게임오버!");
					break;
				}
				if(!(temp_2.substring(0, 1).equals(temp))||(tell.contains(temp_2)))  {
					System.out.println("끝말잇기가 실패하셨습니다!");
					System.out.println(tell.size()+"번 ");
					for(int i=0; i<tell.size(); i++) {
						System.out.print(tell.get(i)+" ");
					}
					break;
					}
					tell.add(temp_2);
					current=temp_2;
					
				}
				
		}
		
		
		
		
	}


