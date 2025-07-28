package api.lang.string;

public class Test02문자열생성 {
	public static void main(String args[]) {
	//인스턴스 생성
	String a="hello"; //우리가 원래 사용하던 방법
	String b=new String("hello");
	
	char []ch=new char[] {'h','e','l','l','o'};
	String c=new String(ch);
	byte[]by=new byte[] {104,101,108,108,111};
	String d=new String(by);
	
	System.out.println("a="+a.toString());
	System.out.println("b="+b.toString());
	System.out.println("c="+c.toString());
	
	System.out.println("a="+a.hashCode());
	System.out.println("b="+b.hashCode());
	System.out.println("c="+c.hashCode());
	
	System.out.println(a==b); // 정확히 같은인스턴스인지 비교
	System.out.println(a.equals(b));
	
	String e="Hello";
	System.out.println(a.equalsIgnoreCase(e));
	
	}
}
