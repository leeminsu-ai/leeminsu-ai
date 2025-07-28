package keyword2;

public class Calculator {
	//일회용 메소드
	// static 키워드를 붙이면 인스턴스 없이 사용
	//이정보는 인스턴스에 포함이 안됨.
	public static int plus(int left,int right) {
		return left+right;
	}
	
	//(+추가) 생성자를 잠궈버리면 인스턴스 생성이 아예불가
	private Calculator() {
		
	}
}
