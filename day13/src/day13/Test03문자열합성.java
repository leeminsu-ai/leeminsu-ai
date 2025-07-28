package day13;

public class Test03문자열합성 {

	public static void main(String[] args) {
		//문자열 합성의 문제점과 해결방안
		//문자열은 기본적으로 불변이다.
		//불변이기 떄문에 얻는장점도많다(ex:안정성,속도,메모리효율)
		//단점은 무조건 변경되면 새로 만들어야 한다는점.
		StringBuffer result=new StringBuffer();
		long begin=System.currentTimeMillis();
		for(int i=0; i<10; i++)
		{
		result.append("*");
		}
		long end=System.currentTimeMillis();
		
		System.out.println(end-begin);
		
		//System.out.println(result);

	}

}
