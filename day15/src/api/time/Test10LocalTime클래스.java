package api.time;

import java.time.Duration;
import java.time.LocalTime;

public class Test10LocalTime클래스 {

	public static void main(String[] args) {
		LocalTime a=LocalTime.now();
		LocalTime b=LocalTime.of(18, 0);
		LocalTime c=LocalTime.parse("18:00");
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		
		System.out.println("a의 시간=" + a.getHour());
		System.out.println("퇴근전인가요?"+a.isBefore(b));
		System.out.println("근무시간인가요?"+(a.isAfter(c)&&a.isBefore(b)));
		
		//Duration 클래스를 이용한 시간차이 계산
		Duration d=Duration.between(a, b);
		System.out.println("d="+d);
		
		System.out.println(d.getSeconds());
		System.out.println(d.toDaysPart());
		System.out.println(d.toHoursPart());
		System.out.println(d.toMinutesPart());
		System.out.println(d.toSecondsPart());
	}

}
