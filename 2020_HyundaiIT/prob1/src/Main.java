public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 } };

		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = 0;

		// 더 큰 배열을 만들어 0으로 감싼다.
		int[][] newMap = new int[maps.length + 2][maps[0].length + 2];
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				if (i == 0 || i == newMap.length - 1 || j == 0 || j == newMap[0].length - 1) {
					newMap[i][j] = 0;
				} else {
					newMap[i][j] = maps[i - 1][j - 1];
				}
			}
		}

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		int minusCount = 0;
		for (int i = 1; i < newMap.length - 1; i++) {
			for (int j = 1; j < newMap[0].length - 1; j++) {
				if (newMap[i][j] == 1) {
					int newNum = 0;
					// 주변의 0의 갯수를 카운팅
					for (int[] dir : dirs) {
						if (newMap[i + dir[0]][j + dir[1]] == 0) {
							newNum++;
						}
					}
					// 예외 조건 처리, 섬의 부분이 모두 섬으로 감싸진 경우
					// ex) {{1,1,1}{1,1,1}{1,1,1}}
					if (newNum == 0) {
						newMap[i][j] = -1;
						minusCount++;
					} else {
						newMap[i][j] = newNum;
					}
				}
			}
		}

		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				answer += newMap[i][j];
			}
		}

		answer += minusCount;

		return answer;
	}
}
