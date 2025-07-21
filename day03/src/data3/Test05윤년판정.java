package data3;

public class Test05윤년판정 {

	public static void main(String[] args) {
			//윤년이라는것은 실제날짜와 달력상의 날짜 차이를 보정하기위한 특수장치
		
		  //4년마다 1일씩 추가하는걸로 계획을 세움
		 //100의배수일 경우에는 윤년에서 제외
		//400의배수일 경우 윤년
		
		int year=2400;
		boolean result=(year%4==0&&year%100!=0)||year%400==0;
		System.out.println(result);
		
	}		

}
