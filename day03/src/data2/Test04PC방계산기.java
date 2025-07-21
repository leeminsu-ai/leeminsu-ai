package data2;

public class Test04PC방계산기 {

	public static void main(String[] args) {
		int openH=10;
		int openM=30;
		int finH=16;
		int finM=15;
		int hourMoney=1000;
		
		double mMoney=hourMoney/60f;
		double dif=(double)(60*finH+finM)-(double)(60*openH+openM);
		double result=(mMoney*dif);
		System.out.println(result);
		System.out.printf("%.0f",result);
		
		//(+추가)price에서 100원미만의 값을 버림/반올림/올림
		//5766/100*100;
		//price=price/100*100;
	}

}
