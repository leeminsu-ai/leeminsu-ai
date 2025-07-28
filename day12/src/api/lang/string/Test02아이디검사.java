package api.lang.string;

public class Test02아이디검사 {

	public static void main(String[] args) {
		String id="l_eeminsu";
		String regex="^[a-z]\\w{4,19}$";
		boolean match=id.matches(regex);
		if(match) {
			System.out.println("사용가능한 아이디입니다");
		}
		else {
			System.out.println("불가능한 아이디입니다. 5~20글자로 표현해주세요");
		}
		
		
				
	}

}
