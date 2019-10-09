import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String l = sc.nextLine();
			String[] seperated = l.split(" ");
			int[] minmax = new int[10];

			for (int i = 0; i < 10; i++) {
				int sum = 0;
				int num = Integer.parseInt(seperated[i]);

				while (num != 0) {
					sum += num % 10;
					num /= 10;
				}
				minmax[i] = sum;
			}

			int max = minmax[0];
			int min = minmax[0];

			for (int i = 0; i < minmax.length; i++) {
				if (max < minmax[i]) {
					max = minmax[i];
				}

				if (min > minmax[i]) {
					min = minmax[i];
				}
			}

			System.out.println("#" + test_case + " " + max + " " + min);

		}
	}

}
