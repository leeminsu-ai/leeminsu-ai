package extend_2;

public class Actioncam extends Camera {

    public Actioncam(String name, int pixel) {
        super(name, pixel); // 부모 생성자 호출
    }
	void slowMotion(){
		System.out.println("슬로우모션");
	}
void reduce() {
	System.out.println("보정");
}
}