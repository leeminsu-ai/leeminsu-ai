package api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test07포커시뮬레이션 {

	public static void main(String[] args) {
		ArrayList<String>shape=new ArrayList<String>(Arrays.asList("다이아","하트","클로버","스페이드"));
		ArrayList<String>letter=new ArrayList<String>(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
		ArrayList<String>shapeLetter=new ArrayList<String>();
		int cardMax=52;
		int people=4;
		int divide=6;
		int count_1=0;
		for(int i=0; i<shape.size(); i++) {
			for(int j=0; j<letter.size(); j++) {
				String shape_letter=shape.get(i)+letter.get(j);
				shapeLetter.add(shape_letter);
			}
			
		}
		Collections.shuffle(shapeLetter);
		
		for(int i=0; i<people; i++) {
			System.out.println((i+1)+"번 참가자:");
			
			for(int j=0; j<divide; j++) {
				System.out.print(shapeLetter.get(count_1)+" ");
				count_1++;
			}
			System.out.println();
		}
		
		
		
		
		
		
	}

}
