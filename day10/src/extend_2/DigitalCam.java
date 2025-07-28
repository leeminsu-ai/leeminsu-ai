package extend_2;

public class DigitalCam extends Camera{

    public DigitalCam(String name, int pixel) {
        super(name, pixel); // 부모 생성자 호출
    }
	void wideRecode()
	{
		System.out.println("광곽 촬영");
	}
	void slowMotion()
	{
		System.out.println("슬로우모션");
	}
}
