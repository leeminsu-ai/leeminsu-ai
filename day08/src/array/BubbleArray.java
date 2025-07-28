package array;

public class BubbleArray {

	public static void main(String[] args) {

		int[] a = new int[] { 30, 50, 20, 10, 40 };
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5 - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

				}
			}

		}
		for (int i = 0; i < 5; i++) {
			System.out.println(a[i]);
		}

	}

}