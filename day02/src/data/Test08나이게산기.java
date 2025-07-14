package data;

public class Test08나이게산기 {

	public static void main(String[] args) {
		int bornYear=2000;
		int bornMonth=10;
		
		int nowYear=2025;
		int nowMonth=7;
		
		int korea_age=nowYear-bornYear+1;
		int age=((nowYear*12+nowMonth)-(bornYear*12+bornMonth))/12;
		System.out.println(korea_age);
		System.out.println(age);
		
		
	}

}
