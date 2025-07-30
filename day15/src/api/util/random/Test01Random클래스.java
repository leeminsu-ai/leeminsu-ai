package api.util.random;
import java.util.Random;

public class Test01Random클래스 {

	public static void main(String[] args) {
			//Random클래스
		//랜덤숫자를 생성하는 클래스
		//시드를 통제한다면 결과값을 일정하게 만들수있음.
		
		Random r1=new Random();
		Random r2=new Random(1L);
		
		int lotto1=r1.nextInt(45)+1;
		int lotto2=r2.nextInt(45)+1;
		
		System.out.println("lotto1="+lotto1);
		System.out.println("lotto2="+lotto2);
		
		//다양한 값들을 추첨할 수있음.
	System.out.println("논리="+r1.nextBoolean());
	System.out.println("정수="+r1.nextInt());
	System.out.println("정수="+r1.nextLong());
	System.out.println("실수="+r1.nextFloat());
	System.out.println("실수="+r1.nextDouble());
	System.out.println("가우스분포="+r1.nextGaussian()); //정규분포를 따라는 난수
	
	}

}
