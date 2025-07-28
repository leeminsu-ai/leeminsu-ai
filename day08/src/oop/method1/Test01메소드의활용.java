package oop.method1;

public class Test01메소드의활용 {
	public static void main(String args[])
	{
		Student s1=new Student();
	
		//student라는클래스내부에 info라는 메소드로준비해놨다.
		
		s1.show();
		s1.init("피카츄",50,60,70);// s1을 주인공으로 해서 info 메소드를 실행해라~
	}
}
