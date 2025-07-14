package data;

public class Test07PC방요금계산기 {

	public static void main(String[] args) {
		int hour_pcPrice=1200;
		int minute_pcPrice=hour_pcPrice/60;
		
		int goPcTimeHour=10;
		int goPcTimeminute=15;
		
		int finishPcTimeHour=16;
		int finsishPctimeMinute=5;
		
		int goPcMinuteSum=60*goPcTimeHour+goPcTimeminute;
		int finishPcMinuteSum=60*finishPcTimeHour
		+finsishPctimeMinute;
		int total=finishPcMinuteSum-goPcMinuteSum;
		
		int totalSum=minute_pcPrice*total;
		
		System.out.println(totalSum);
		
		
	}

}
