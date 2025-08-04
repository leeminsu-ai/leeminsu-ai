package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test01TreeSet클래스 {

	public static void main(String[] args) {
		Set<Integer>set=new TreeSet<>();
		System.out.println("set="+set);
		set.add(5);
		set.add(3);
		set.add(1);
		set.add(4);
		set.add(7);
		set.add(6);
		set.add(8);
		
		//데이터검색
		System.out.println("7이있습니까?"+set.contains(7));
		 //데이터삭제(구조상 순서로 지울수 없음)
		set.remove(6);
		
		for(int number:set) {
			System.out.println(number);
		}
	}

}
