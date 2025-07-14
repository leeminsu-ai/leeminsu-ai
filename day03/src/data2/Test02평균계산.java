package data2;

public class Test02평균계산 {

	public static void main(String[] args) {
		int korean=75;
		int math=60;
		int english=88;
		
		int sumScore=korean+math+english; //총합
		double avg=sumScore/3.0; //평균  변수에다가 float 형변환 가능
		
		System.out.println(sumScore);
		System.out.println(avg);	
	}

}
