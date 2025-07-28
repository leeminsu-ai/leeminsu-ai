package keyword1;

public class Calculator {	
		//멤버 필드: 계산에 필요한 데이터를 저장할 변수
	
	private int left;//연산자 왼쪽에 들어갈 값
	private int right;// 연산자 오른쪽에 들어갈 값
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
		
	public int getPlus() {
	
		return this.left+this.right;
	}
	
		
	
	
	

}
