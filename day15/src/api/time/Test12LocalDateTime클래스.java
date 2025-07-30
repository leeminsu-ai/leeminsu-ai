package api.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Test12LocalDateTime클래스 {

	public static void main(String[] args) {
		//LocalDateTime
		//시간날짜를 모두가지는클래스
		//명령체계는앞에서 본 클래스와 동일
		
		LocalDateTime t1=LocalDateTime.now();
		LocalDateTime t2=LocalDateTime.of(2025,12,23,18,0,0);
		LocalDateTime t3=LocalDateTime.parse("2025-12-23T18:00");
		
		System.out.println("t1="+t1);
		System.out.println("t2="+t2);
		System.out.println("t3="+t3);
		
		Period p=Period.between(t1.toLocalDate(), t2.toLocalDate());
		System.out.println(p.getMonths()+"개월"+p.getDays()+"일 남음");
		Duration d=Duration.between(t1, t2); //period와 달리 시간까지 알수있음
		System.out.println("총"+d.toDays()+"일 남음");
		
		//t1을 이용하여 같은해 1월1일로 날짜로 변경하여 새로운 인스턴스를 생성하세요
		
		LocalDateTime t4=LocalDateTime.of(t1.getYear(), 1,1,t1.getHour(),t1.getMinute(),t1.getSecond(),t1.getNano());
		System.out.println("t4="+t4);
		LocalDateTime t5=t1.withMonth(1).withDayOfMonth(1);
		System.out.println("t5="+t5);
		
		
		
	}

}
