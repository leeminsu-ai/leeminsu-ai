package extend_2;

public class MainCamera {

	public static void main(String[] args) {
		DigitalCam a=new DigitalCam("디지털캠",10);
		Actioncam b=new Actioncam("액션캠",20);
		Webcam c=new Webcam("웹캠",30);
	       a.wideRecode();
	       System.out.println(a.getName());
	}

}
