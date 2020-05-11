import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 2, 4, 8, 2 }, { 2, 2, 2, 2 }, { 0, 4, 2, 4 }, { 2, 2, 2, 4 } };

		System.out.println(solution(board));
	}

	static int solution(int[][] board) {
		// DFS를 이용한 풀이
		for (int i = 1; i < 5; i++) {
			DFS(0, i, board);
		}
		return MAX;
	}

	// 0이 아닌 값들을 기존에 넣어주는 리스트
	static List<Integer> list = new ArrayList<Integer>();
	// 움직임 후 계산된 값들을 넣어주는 리스트
	static List<Integer> plusList = new ArrayList<Integer>();
	static int MAX = Integer.MIN_VALUE;

	public static void DFS(int count, int index, int[][] map) {
		if (count == 5) {
			// 종료 조건은 5번 움직였을 때
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					MAX = Math.max(MAX, map[i][j]);
				}
			}
			return;
		}

		int[][] nextMap = new int[4][4];

		for (int i = 0; i < 4; i++) {
			// 리스트 초기화
			list.clear();
			plusList.clear();
			for (int j = 0; j < 4; j++) {
				if (index > 2) {
					// 위, 아래 방향 처
					if (map[j][i] != 0) {
						list.add(map[j][i]);
					}
				} else {
					if (map[i][j] != 0) {
						list.add(map[i][j]);
					}
				}
			}

			// 오른쪽과 아래 방향은 순서를 바꾸어서 더해준다.
			if (index == 1 || index == 4) {
				Collections.reverse(list);
			}

			for (int j = 0; j < list.size(); j++) {
				// 값이 같은 경우 2배를 해준다.
				if (j != list.size() - 1 && list.get(j).equals(list.get(j + 1))) {
					plusList.add(list.get(j++) * 2);
				} else {
					plusList.add(list.get(j));
				}
			}
			// 더해진 값들을 이용해서 새로운 배열에 값 할당
			for (int j = 0; j < plusList.size(); j++) {
				if (index == 1) {
					nextMap[i][4 - j - 1] = plusList.get(j);
				} else if (index == 4) {
					nextMap[4 - j - 1][i] = plusList.get(j);
				} else if (index == 2) {
					nextMap[i][j] = plusList.get(j);
				} else if (index == 3) {
					nextMap[j][i] = plusList.get(j);
				}
			}
		}
		for (int i = 1; i < 5; i++) {
			DFS(count + 1, i, nextMap);
		}
	}
}
