package oop.modifier1;

public class Test01키보드정보생성 {
	public static void main(String args[])
	{
		Keyboard a=new Keyboard("레오폴드 키보드","무접점",110,350000);
		//private 항목은 접근이 불가능하다
		//a.name="독거미 키보드";
		a.setName("독거미 키보드:");
		
		a.info();
		
				
	}
}
