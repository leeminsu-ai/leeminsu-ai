package api.lang.string;

public class Test01전화번호검사 {

	public static void main(String[] args) {
		//사용자가 입력한 휴대전화번호가 올바른 양식인지 검사하여 출력
		String input="010-1212-3445";
		System.out.println("올바른 전화번호양식입니다");
		System.out.println("잘못된 전화번호 양식입니다");
		
		String regex="^010-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
		
		boolean match=input.matches(regex);
		
		if(match) {
			System.out.println("올바른 전화번호 양식입니다");
		}
			else {
				System.out.println("잘못된 전화번호 양식입니다");
			}
		}
	

	}


