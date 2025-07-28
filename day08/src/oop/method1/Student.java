package oop.method1;

public class Student {
	//멤버 필드
	String name;
	int korean;
	int english;
	int math;
	
	//어짜피 인스턴스를 만들고나면 "초기화"나 "출력"코드가 반복적으로 실행
	//당연히 있어야 하는 코드라면 미리 준비해줄순없을까?
	//->멤버 메소드
	
	//void 이름() {
		//코드
	//}
	//출력 코드를 미리 준비해보자!
	void show() {
		System.out.println("<학생 성적정보:>");
		System.out.println("이름:"+this.name);
		System.out.println("국어:"+this.korean+"점");
		System.out.println("영어:"+this.english+"점");
		System.out.println("수학:"+this.math+"점");
	}
	
	void init(String name, int korean, int English,int math) {
		this.name=name;
		this.korean=korean;
		this.english=english;
		this.math=math; 

	}
}
