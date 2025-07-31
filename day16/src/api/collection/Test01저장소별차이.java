package api.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01저장소별차이 {

	public static void main(String[] args) {
		// ArrayList vs TreeSet

		ArrayList<String> a = new ArrayList<String>(); //순서
		TreeSet<String> b = new TreeSet<String>();//오름차순 정렬
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		a.add("피카츄"); b.add("피카츄");
		a.add("라이츄"); b.add("라이츄");
		a.add("파이리"); b.add("파이리");
		a.add("꼬부기"); b.add("꼬부기");
		a.add("버터풀"); b.add("버터풀");
		a.add("야도란"); b.add("야도란");
		
		System.out.println("a="+a);
		System.out.println("b="+b);

	}

}
