import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;
		System.out.println(solution(budgets, M));
	}

	public static int solution(int[] budgets, int M) {
		int answer = 0;
		long sum = 0;
		int min = 0;
		int max = M;
		int mid = 0, premid = 0;

		Arrays.sort(budgets);
		for (int budget : budgets) {
			sum += budget;
		}

		if (sum < M) {
			return budgets[budgets.length - 1];
		}

		while (true) {
			sum = 0;
			mid = (max + min) / 2;
			if (mid == premid) {
				break;
			}
			for (int i = 0; i < budgets.length; i++) {
				if (mid <= budgets[i]) {
					sum += mid * (budgets.length - i);
					break;
				} else {
					sum += budgets[i];
				}
			}
			if (sum <= M) {
				min = mid;
			} else {
				max = mid;
			}
			premid = mid;
		}
		answer = mid;

		return answer;
	}
}
