import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String testLine = sc.nextLine();
			String[] testLineSplited = testLine.split(" ");
			int N = Integer.parseInt(testLineSplited[0]);
			int B = Integer.parseInt(testLineSplited[1]);

			int[][] arr = new int[N][N];
			int max = 0;

			for (int i = 0; i < B; i++) {
				String safe = sc.nextLine();
				String[] safeSplited = safe.split(" ");
				int a = Integer.parseInt(safeSplited[0]);
				a--;
				int b = Integer.parseInt(safeSplited[1]);
				b--;

				arr[a][b]++;
				try {
					arr[a - 1][b]++;
				} catch (Exception e) {
				}
				try {
					arr[a - 2][b]++;
				} catch (Exception e) {
				}
				try {
					arr[a + 1][b]++;
				} catch (Exception e) {
				}
				try {
					arr[a + 2][b]++;
				} catch (Exception e) {
				}
				try {
					arr[a][b - 1]++;
				} catch (Exception e) {
				}
				try {
					arr[a][b - 2]++;
				} catch (Exception e) {
				}
				try {
					arr[a][b + 1]++;
				} catch (Exception e) {
				}
				try {
					arr[a][b + 2]++;
				} catch (Exception e) {
				}
				
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						if(arr[j][k] > max) {
							max = arr[j][k];
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
