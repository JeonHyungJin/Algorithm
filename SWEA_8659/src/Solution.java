import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		long[][] table = new long[91][2];
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();
		
		table[1][0] = 2;
		table[1][1] = 1;
		
		for(int i = 2; i <= 90; i++) {
			table[i][1] = table[i-1][0];
			table[i][0] = table[i-1][0] + table[i-1][1];
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			sc.nextLine();
			
			System.out.println("#" + test_case + " " + table[num][0] + " " + table[num][1]);
		}
	}

}
