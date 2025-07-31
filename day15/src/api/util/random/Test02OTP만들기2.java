package api.util.random;

import java.text.DecimalFormat;
import java.util.Random;
import java.text.DecimalFormatSymbols;
import java.util.UUID;

public class Test02OTP만들기2 {

	public static void main(String[] args) {
		//OTP 구현하기위한 아이디어
		//1.6자리의 랜덤한 숫자를 생성하고 출력한다.
		//2.시드를 조절해서 일정시간동안 동일한랜덤이 나오도록 구현
		//시드를 일정시간동안같게 만들려면 시간값이 필요
		//3.서로 다른 사람들이 다른시드를 가지고 랜덤을 만들수있도록 구현
		//사람마다 다른OTP번호가 나온다!
		//import java.util.UUID; 클래스를 이용하면 절대로 겹치지않는 랜덤시리얼 생성할수있음.
		
		 Random r=new Random();
		 //r.setSeed(1L);
		 long time =System.currentTimeMillis()/10000;
		 System.out.println("time="+time);
		 r.setSeed(time);
		 int number=r.nextInt(1000000);
		 
		System.out.println("번호="+number);
		//콤마대신 띄어쓰기로 그룹핑 기호를 변경
		DecimalFormatSymbols symbols=new DecimalFormatSymbols();
		symbols.setGroupingSeparator(' ');
		DecimalFormat fmt=new DecimalFormat("000,000");
		//fmt.setGroupingSize(number);
		System.out.println("번호(수정)="+fmt.format(number));
		
		 String user1="ed4fb172-1f5b-42f0-b266-6ab2d63f302c";
		 String user2="1f225663-bee1-4495-bd85-7841bc4a1e91";
		 System.out.println(user1);
		 System.out.println(user2);
	}

}
