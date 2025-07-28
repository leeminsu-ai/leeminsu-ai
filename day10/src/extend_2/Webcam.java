package extend_2;

public class Webcam extends Camera{

    public Webcam(String name, int pixel) {
        super(name, pixel); // 부모 생성자 호출
    }
	void decorate() {
		System.out.println("화면꾸미기");
	}
}
