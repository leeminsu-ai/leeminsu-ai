package data;

public class Test04편의점계산기 {

	public static void main(String[] args) {
			int price=1500;
			int count=5;
			int free=count/2; // 
			int pay=count-free;
			int event=pay*price;
			int noevent=price*count;
			
			
			System.out.println(event);
			System.out.println(noevent);
			
	}

}
