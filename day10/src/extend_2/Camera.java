package extend_2;

public class Camera{
	String name;
	int pixel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	public Camera(String name,int pixel)
	{
		this.setName(name);
		this.setPixel(pixel);
		}
	
	
	void record()
	{
		System.out.println("녹화기능");
	}
	
	
	
	
}
