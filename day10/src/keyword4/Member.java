package keyword4;

//회원 클래스
public class Member {
	private final String id;//객체당 하나 가능 ex)a.id="aaa" b.id="bbb" 이런식
	private String pw;
	private String nickname;
	
	// final 항목은 밙드시 생성자에서 초기화가되어야한다
	//final항목은 setter이안된다. 생성자때 this.id=id; 이래야됨
	public Member(String id) 
	{
		this.id=id;
	}
	
}
