
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution(n, computers));
	}

	static boolean[][] visited;

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			if (!visited[i][i]) {
				dfs(i, n, computers);
				answer++;
			}
		}

		return answer;
	}

	public static void dfs(int start, int n, int[][] computers) {
		for (int i = 0; i < n; i++) {
			if (computers[start][i] == 1 && !visited[start][i]) {
				visited[start][i] = visited[i][start] = true;
				dfs(i, n, computers);
			}
		}
	}
}
