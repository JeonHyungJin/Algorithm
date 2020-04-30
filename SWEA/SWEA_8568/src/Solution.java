import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			int size = sc.nextInt();
			sc.nextLine();
			String nums = sc.nextLine();
			int[] arr = new int[size];
			String[] seperated = nums.split(" ");
			for (int i = 0; i < seperated.length; i++) {
				if (Integer.parseInt(seperated[i]) % 3 == 0) {
					arr[i] = 3;
				} else {
					arr[i] = Integer.parseInt(seperated[i]) % 3;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == (i + 1) % 3) {
					continue;
					// do nothing
				} else {
					for (int j = i; j < arr.length; j++) {
						if (arr[j] == (i + 1) % 3 && (arr[i] != (i + 1) % 3)) {

							int temp = arr[j];
							arr[j] = arr[i];
							arr[i] = temp;
							result++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);

		}
	}

}
