package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리타기선생님버전2 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//1. 인원 수 설정
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		sc.nextLine();//남은 엔터 청소
		
		//2. 저장소 생성 및 항목 설정
		List<String> names = new ArrayList<>();
		List<String> items = new ArrayList<>();
		
		for(int i=0; i < people ; i++) {
			System.out.print("이름 : ");
			names.add(sc.nextLine());
		}

		for(int i=0; i < people ; i++) {
			System.out.print("항목 : ");
			items.add(sc.nextLine());
		}
		
		sc.close();
		
		//3. 결과 표시
		Collections.shuffle(items);
		for(int i=0; i < people; i++) {
			System.out.println(names.get(i) + " → " + items.get(i));
		}
		
	}

}
