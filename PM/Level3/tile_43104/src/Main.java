
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		System.out.println(solution(n));
	}

	public static long solution(int n) {
		long answer = 0;

		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = dp[2] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		long x = dp[n];
		long y = dp[n] + dp[n - 1];

		answer = 2 * x + 2 * y;
		return answer;
	}

}
