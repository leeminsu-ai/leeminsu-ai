package api.lang.string;

public class Test05문자열검사 {

	public static void main(String[] args) {
		String url="https://www.naver.com";
		System.out.println("url이 홈페이지 주소에요?");
		System.out.println(url.startsWith("https://"));
		
		System.out.println("기업용 홈페이지 주소에요?");
		System.out.println(url.endsWith("com"));
		
		System.out.println("네이버와 관련된 홈페이지인가요?");
		System.out.println(url.contains("naver"));
		
		System.out.println("naver가 포함된 위치가 어디임");
		System.out.println(url.indexOf("naver"));
		System.out.println(url.lastIndexOf("naver"));
		
		System.out.println(url.length());
		// 마지막글자만 뽑아서 출력
		//추출 char가나옴
		char last=url.charAt(url.length()-1);
		System.out.println("마지막 글자:"+last);
		
		char first=url.charAt(url.length()-url.length());
		System.out.println("첫번쨰 글자:"+first);
		
		boolean lower= 'a'<=first&&first<='z';
		
		
	}

}
