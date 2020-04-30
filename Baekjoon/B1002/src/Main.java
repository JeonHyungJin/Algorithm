import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		int[] result = new int[tCase];

		for (int i = 0; i < tCase; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			result[i] = solution(x1, y1, r1, x2, y2, r2);
		}

		for (int a : result) {
			System.out.println(a);
		}
	}

	public static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
		double r = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		if (x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		} else if (r > r1 + r2 || x1 == x2 && y1 == y2 && r1 != r2 || r < Math.abs(r1 - r2)) {
			return 0;
		} else if (r == r1 + r2 || Math.abs(r1-r2) == r) {
			return 1;
		} else {
			return 2;
		}

	}

}
