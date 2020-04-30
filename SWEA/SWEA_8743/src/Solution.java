import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			int R = sc.nextInt();
			sc.nextLine();
			int B = sc.nextInt();
			sc.nextLine();	
			
			// 1 <= i, 2i <= R
			// R = R - 2i, B = B + i
			// R = R + i, B = B - 2i 둘 중 하나 수행
			while( R > 0 || B > 0) {
				
			}
		}
	}

}
