package array;

public class 삽입정렬 {

	public static void main(String[] args) {
		//삽입정렬
		//삽입될 위치를 찾아 데이터를 넣어주는 방식
		
		//4회차정렬
		
		int []a=new int[]{30,50,20,10,40};
		for(int i=1; i<5; i++)
		{
			int key=a[i];
			int j=i-1;
			while(j>=0&&a[j]>key)
			{
				
			 a[j+1]=a[j];
					
					
					
				
				
					j--;
			}
			a[j+1]=key;
		}
		for(int i=0; i<5; i++)
		{
			System.out.println(a[i]);
		}
		
		
	}

}
