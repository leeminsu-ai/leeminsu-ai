package data2;

public class Test03bmi검사 {

	public static void main(String[] args) {
		int height = 180;
		int weight = 80;
		float mHeight = height / 100.0f;
		float BMI = (float) weight / (mHeight * mHeight);
		System.out.printf("%.2f\n", BMI);
		System.out.println(mHeight);

		// 소수점 두자리까지 제거
		// float first=bmi*100;
		// int second=(int)first;
		// float third=second;
		// float fourth=third/100;

	}

}
