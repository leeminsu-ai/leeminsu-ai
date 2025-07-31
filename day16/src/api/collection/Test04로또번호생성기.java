package api.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Test04로또번호생성기 {

	public static void main(String[] args) {
		Random random=new Random();
		int lottoNum_count;
		ArrayList<Integer>lottoNum=new ArrayList<Integer>();
		int maxNum=0;
		
		while(maxNum<6) {  // lottoNum.size()로 푸는게 더 이상적
			lottoNum_count=random.nextInt(45)+1;
			if(lottoNum.contains(lottoNum_count)){
				continue;
			}
			lottoNum.add(lottoNum_count);
			maxNum++;
		}
		
		TreeSet<Integer>b=new TreeSet<Integer>();
		
		for(int j=0; j<6; j++) {
			System.out.println("로또"+(j+1)+"번째"+lottoNum.get(j)+"입니다");
		}
		
	}

}
