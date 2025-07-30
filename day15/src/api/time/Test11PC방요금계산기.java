package api.time;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test11PC방요금계산기{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작시각 : ");
		String in = sc.nextLine();
		System.out.print("종료시각 : ");
		String out = sc.nextLine();//현재시각으로 대체도 가능
		sc.close();
		
		int pricePerHour = 1000;
		
		//변환
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime inTime = LocalDateTime.parse(in, fmt);
		LocalDateTime outTime = LocalDateTime.parse(out, fmt);
		
		Duration duration = Duration.between(inTime, outTime);
		
		//분당 요금 계산
		double pricePerMinute = (double)pricePerHour / 60;
		int price = (int) (duration.toMinutes() * pricePerMinute);
		price = price / 100 * 100;
		
		//이용시간 출력
		//- 숫자에 콤마를 추가하도록 처리(java.text.DecimalFormat)
		//- #은 숫자가 있을 때만 출력하고 없으면 아예 비워두라는 뜻
		//- 0은 숫자가 있을 때는 출력하고 없으면 0을 써두라는 뜻
		//DecimalFormat df = new DecimalFormat("#,##0.00");
		DecimalFormat df = new DecimalFormat("#,##0");
		
		System.out.println("이용시간은 총 "+duration.toHours()+"시간 "+duration.toMinutesPart()+"분 입니다");
		//System.out.println("이용요금은 총 "+price+"원 입니다");
		System.out.println("이용요금은 총 "+df.format(price)+"원 입니다");
		
	}
}


