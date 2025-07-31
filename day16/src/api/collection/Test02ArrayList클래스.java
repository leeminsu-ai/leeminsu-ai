package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test02ArrayList클래스 {

	public static void main(String[] args) {
		//생성
		ArrayList<String>b=new ArrayList<String>();
		ArrayList<String>c=new ArrayList<String>();
		List<String>d=new ArrayList<>();
		//데이터 추가
		d.add("자바"); //0
		d.add("파이썬");//1->2
		d.add("C++");//2->3
		d.add(1,"루비"); //1  //  연결리스트(노드삽입)
		
		//개수 확인
		System.out.println("c의개수:"+c.size());
		System.out.println("d의개수:"+d.size()); //데이터의 개수
		
		//데이터 추출 
		System.out.println("0번위치="+d.get(0)); //d[0] 느낌
		
		//데이터검색
		System.out.println("파이썬이 있어요?"+d.contains("파이썬")); //true
		
		//데이터삭제(값 or 위치)
		d.remove(0);
		d.remove("파이썬");
		
		System.out.println("d="+d);
		
		
		
	}

}
