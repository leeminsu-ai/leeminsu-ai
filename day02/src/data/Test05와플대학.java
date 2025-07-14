package data;

public class Test05와플대학 {

	public static void main(String[] args) {
		int creamWaffle=2500;//크림와플가격	
		int nuttelaWaffle=3500;//누텔라와플가격
		int stamp=10;
		
		int creamWaffleCount=20;//크림와플개수
		int nuttelaWaffleCount=15;//누텔라와플개수
		
		int totalWaffleCount=creamWaffleCount+nuttelaWaffleCount;//개수총합
		int sumWaffle=creamWaffle*creamWaffleCount
				+nuttelaWaffle*nuttelaWaffleCount;//가격총합
		
		int discount=totalWaffleCount/stamp; //할인횟수
		int salePrice=1800; // 할인가격
		int totalPrice=sumWaffle-(salePrice*discount);//총합
		
		System.out.println(totalPrice);
}
}
