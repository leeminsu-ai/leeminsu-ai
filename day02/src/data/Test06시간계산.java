package data;

public class Test06시간계산 {

	public static void main(String[] args) {
		//(ex)1시간 40분+2시간 30분=?
		
		int h1=1;
		int m1=40;
		int h2=2;
		int m2=30;
		
		int t1=h1*60+m1;
		int t2=h2*60+m2;
		int total=t1+t2; // 250
		//System.out.println(total);
		int hour=total/60;
		int minute=total%60;
		
		System.out.println(hour);
		System.out.println(minute);
		
		
	}

}
