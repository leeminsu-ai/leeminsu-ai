package oop.basic1;

public class Test01객체지향프로그래밍 {

	public static void main(String[] args) {
			Message a=new Message(); //객체생성(인스턴스)
			a.sender="초롱초롱 라이언";
			a.content="어지금 가는중";
			a.time="오후 12:29";
			a.remain=0;
			System.out.println(a);
			System.out.println(a.sender);
			System.out.println(a.content);
			System.out.println(a.time);
			System.out.println(a.remain);
			
			Message b=new Message();
			//b(래퍼런스)---->(객체,인스턴스)
			b.sender="초롱초롱 라이언";
			b.content="오늘은일찍와?";
			b.time="오후 12:29";
			b.remain=0;
			System.out.println(b);
			System.out.println(b.sender);
			System.out.println(b.content);
			System.out.println(b.time);
			System.out.println(b.remain);
			
	}

}
