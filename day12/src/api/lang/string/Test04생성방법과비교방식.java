package api.lang.string;

public class Test04생성방법과비교방식 {

	public static void main(String[] args) {
		//비교연산을 사용하면 안되는 이유	
		String a="hello";
		String b="hello"; //만들어놓고 공유
		String c=new String("hello"); //신규생성
		String d=new String("hello");//신규생성
		
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(c==d);
		System.out.println(d==a);
		
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(c.equals(d));
		System.out.println(d.equals(a));
		
	}

}
