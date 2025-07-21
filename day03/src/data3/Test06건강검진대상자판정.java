	package data3;
	
	public class Test06건강검진대상자판정 {
	
		public static void main(String[] args) {
				int born=1981;
				int current=2025;
				int korea_age=current-born+1;
				
				boolean result=korea_age>=30&&(born % 2 == current % 2); //가독성이좋음
				System.out.println(result);
				if(result)
				{
					System.out.println("건강검진 대상입니다.");
				}
				else
				{
					System.out.println("건강검진 대상이아닙니다.");
				}
		}
	
	}
