package api.time;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class Test09급여일계산기 {

	
	
	public static void main(String[] args) {
		int putMoney;
		Scanner sc=new Scanner(System.in);
		System.out.println("급여일 입력");
		putMoney=sc.nextInt();
		
		//공휴일 명단을 작성(직접)
	
	LocalDate today=LocalDate.now();
	DateTimeFormatter fmt=DateTimeFormatter.ofPattern("y년 M월 d일 E");
	
	for(int i=1; i<=12; i++) {
		
	
	LocalDate target=today.plusMonths(i).withDayOfMonth(5);
	if(target.getDayOfWeek()==DayOfWeek.SATURDAY) {
		target=target.minusDays(1L);
	}
	else if(target.getDayOfWeek()==DayOfWeek.SUNDAY) {
		target=target.minusDays(2L);
	}
	
	System.out.println("급여일:"+target.format(fmt));
	}
		
		
		
	}

}
