package api.lang.string;

public class Test07문자열편집 {
	public static void main(String args[]) {
 //문자열편집
	//대소문자 변환, 마스킹 처리 ,치환,분할,공백제거
	//주의할점은 문자열이 불변이라는 사실
	//편집명령을 실행하면 기존 문자열이 변하는게아니고 신규 문자열이 생성됨
	String a="Hello1234";
	a.toUpperCase();
	String b=a.toUpperCase();
	System.out.println("a="+a);
	System.out.println("b="+b);
	
	String c="                    아이고 배부르고 졸리당         ";
	System.out.println("여백제거 결과="+c.trim());
	String d=   "아이고  배부르고 졸리다     ";
	System.out.println("여백제거 이전="+d.trim());
	System.out.println("여백제거 이후=" +d.strip());
	
	//문자열 치환
	String e="저는 자바가 재미없어요";
	System.out.println("before"+e);
	System.out.println("after="+e.replace("없어요", "있어요"));
	
}
}