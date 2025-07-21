package data4;

public class Test02문자열 {

	public static void main(String[] args) {
		//문자들이 모여서 만들어진 데이터
		// 데이터의 형태가 int등과 다르게 생김(원시형vs참조형)
		String a="hello";
		System.out.println(a);
		System.out.println(a.length());//참조형에만 있는기능
		System.out.println(a.toUpperCase()); //대소문자 바꿔준다
		
		//대부분의 연산이 불가능
		String b="hello"+"world";
		System.out.println(b);
		
		String c="피자 떡볶이";//띄어쓰기는 그냥두고
		String d="피자\t떡볶이";//탭키는 명시적으로 표시 (\t)<- 이스케이프 문자
		System.out.println(c);
		System.out.println(d);
		
		String e="피자\n떡볶이";
		System.out.println(e);
		
		String f="나는 오늘 \"피자\"를 먹을거야";
		System.out.println(f);
	}

}
