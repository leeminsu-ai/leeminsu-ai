package api.util.mix;
import java.util.Arrays;
import java.util.StringJoiner;
public class Test01문자열합성도구사용해보기 {

	public static void main(String[] args) {
		
		StringJoiner joiner=new StringJoiner(",");
		joiner.add("바나나");
		joiner.add("딸기");
		joiner.add("포도");
		joiner.add("수박");
		joiner.add("키위");
		
		System.out.println("["+joiner.toString()+"]");
 		// System.out.println(Arrays.toString(fruits)); <-가능
		
		
	}

}
