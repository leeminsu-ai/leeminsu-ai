package api.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test05사다리타기 {

	public static void main(String[] args) {
		ArrayList<String>name=new ArrayList<String>();
		ArrayList<String>choose=new ArrayList<String>();
		ArrayList<String>result=new ArrayList<String>();
		Random random=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("몇명할건지 설정해주세요!");
		int peopleNum=sc.nextInt();
		sc.nextLine();
		String write;
		String result1;
		System.out.println(peopleNum+"명의 이름을 설정해주세요!");
		while(name.size()<peopleNum) {
			 write=sc.next();
			if(!name.contains(write)) {
				name.add(write);
			}
		
		}	
		System.out.println(peopleNum+"명의 벌칙을 정해주세요!");
		while(choose.size()<peopleNum) {
			write=sc.next();
			if(!choose.contains(write)) {
				choose.add(write);
			}
		}
		
		for(int i=0; i<peopleNum; i++) {
			
			int index = random.nextInt(choose.size());
			result1= choose.get(index);
			result.add(name.get(i)+"->"+result1);
			choose.remove(result1);
			System.out.println(result.get(i));
		}
		
		
		
	}

}
