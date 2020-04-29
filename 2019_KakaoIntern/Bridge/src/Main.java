public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		System.out.println(solution(a, 3));
	}

	public static int solution(int[] stones, int k) {
		int answer = 0;
		int N = stones.length;
		int max = 0;
		int min = 200000000;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, stones[i]);
			min = Math.min(min, stones[i]);
		}
		int mid;
		while (max >= min) {
			mid = (max + min) / 2;
			if (isPossible(mid, N, k, stones.clone())) {
				answer = Math.max(answer, mid);
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return answer;
	}

	public static boolean isPossible(int mid, int N, int k, int[] stones) {
		for (int i = 0; i < N; i++) {
			stones[i] -= mid;
		}
		int check = 0;
		for (int i = 0; i < N; i++) {
			if (stones[i] < 0) {
				check++;
				if (check >= k) {
					return false;
				}
			} else {
				check = 0;
			}
		}
		return true;
	}
}
