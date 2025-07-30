package api.time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Test08LocalDate클래스 {

	public static void main(String[] args) {
		//java.time 패키지
		//Calendar와 Date의 불편사항들을 종합적으로 개선
		
		
		//문제점들
		//1. 월을 1~12가 아니고 0~11로 관리한다.
		//2. Calendar의 set은 너무 옛날방식이라 용도파악이 어렵다.
		//3. 윤년을 파악할 수 있지만 과정이 너무 복잡하다.
		//4.(중요)날짜가 가변이다.
		//5.시간 변경은 비교적 쉬우나 차이를 구하기 어렵다.
		//6.(중요) 날짜랑 시간이 반드시 같이 보관된다.
		//Date는 똑같은 이름이 있어서 import가 불편해
		
		
		//등장하는 클래스들
		//LocalDate -> 날짜(연/월/일)만 저장하는 클래스
		// LocalTime-시간(시/분/초)만 저장하는클래스
		//LocalDateTime- 날짜와 시간이 같이 저장하는 클래스
		//-> 레스트랑 예약같은경우에는 따로따로씀 단계적으로해야되니까
		//LocalDateTime=Calendar
		//ZoneDateTime-시간대를 설정할수있는클래스
		//Period 기간(연/월/일) 계산용
		//Duration - 시간(시/분/초) 계산용
		//DateTimeFormatter - 날짜 입출력 형식 설정용 클래스
		
		LocalDate a=LocalDate.now();
		LocalDate b=LocalDate.of(2025, 12, 23);
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("a="+a.format(fmt));
		System.out.println("b="+b.format(fmt)); //주인공이 날짜 그래서 a.format(fmt) <= fmt는 형식
		//SimpleDateFormat sdf=new SimpleDateFormat은 그 반대다. (이전버전)
		
		//윤년인가?
		System.out.println("윤년인가?"+a.isLeapYear()); //LocalDate는 이렇게 간편하게가능
		//켈린더는 불편하게해야됨
		
		//불변인가?
		LocalDate future=a.plusDays(100L);
		System.out.println("a="+a);
		System.out.println("future="+future);
		
		//정보추출
		System.out.println("a의연도="+a.getYear());
		System.out.println("a의 월="+a.getMonthValue());
		System.out.println("a의 일="+a.getDayOfMonth());
		
	//a와 b의 기간을 구하기(b-a)
		//기간 구하는 클래스인 Period를 이용해서 처리
		Period p =Period.between(a, b);
		System.out.println("p="+p);
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
		
		//기간을 생성해서 날짜에 더하기
		Period year3=Period.of(3, 2, 0);
		LocalDate c=b.plus(year3);
		System.out.println("c="+c);
		
	}

}
