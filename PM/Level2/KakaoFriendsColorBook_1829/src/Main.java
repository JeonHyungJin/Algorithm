
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
//				{ 0, 0, 0, 3 } };
		int[][] test = new int[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				test[i][j] = 1;
			}
		}
		int[][] picture = { { 0, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 0 } };

		int[] res = solution(test.length, test[0].length, test);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0) {
					int areaNum = picture[i][j];
					int area = dfs(i, j, picture, 0, areaNum, m, n);
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
					numberOfArea++;
				}
			}
		}

		// result value
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	public static int dfs(int x, int y, int[][] picture, int area, int areaNum, int m, int n) {

		if (x < 0 || x >= m || y < 0 || y >= n || picture[x][y] != areaNum) {
			return area;
		}

		picture[x][y] = 0;
		area++;
		for (int[] dir : dirs) {
			area = dfs(x + dir[0], y + dir[1], picture, area, areaNum, m, n);
		}
		return area;
	}

}
