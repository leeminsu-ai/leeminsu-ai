package keyword3;

public class Once_method {
		//static는 this랑 못씀
	public static int multiple(int x,int y)
	{
		return x*y;
	}
	
	public static int square(int x)
	{
		return x*x;
	}
	
	public static double triangle(double x,double y)
	{
		return (x* y)/2;
	}
	public static double circle(double x)
	{
		return x*x*3.14;
	}
	public static double bmi(int x,double y)
	{
		return x/(y*y);
	}
	
	public static int subway(int x,int y) //현재년도=x 출생년도=y
	{
		if(x-y<=7)
		{
			return 550;
		}
		else if(x-y<=13)
		{
			return 900;
		}
		else if(x-y<=65)
		{
			return 1550;
		}
		else {
			return 0;
		}
	}
}
