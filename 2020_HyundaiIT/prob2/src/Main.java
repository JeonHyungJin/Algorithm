import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		int[][] bus_stop = { { 1, 2 }, { 3, 3 } };

		int[][] res = solution(N, bus_stop);
	}

	static Deque<int[]> queue = new ArrayDeque<int[]>();

	public static int[][] solution(int N, int[][] bus_stop) {
		// -1로 초기화된 배열
		int[][] map = initialMap(N);

		// 각 버스 정류장 위치는 0으로 값 변경
		for (int[] aStop : bus_stop) {
			map[aStop[0] - 1][aStop[1] - 1] = 0;
			int[] temp = { aStop[0] - 1, aStop[1] - 1 };
			// 큐에 버스 정류장의 위치를 add
			queue.add(temp);
		}

		// 큐를 이용해 값 파악
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			countNearbyPos(map, pos);
		}
		return map;
	}

	public static void countNearbyPos(int[][] map, int[] pos) {
		int x = pos[0];
		int y = pos[1];
		int north = y - 1;
		int south = y + 1;
		int east = x + 1;
		int west = x - 1;

		int nextCount = map[x][y] + 1;

		// 각 방향마다 값을 비교하며 변경
		if (north > -1) {
			if (map[x][north] > nextCount || map[x][north] < 0) {
				map[x][north] = nextCount;
				int[] temp = { x, north };
				queue.add(temp);
			}
		}
		if (south < map.length) {
			if (map[x][south] > nextCount || map[x][south] < 0) {
				map[x][south] = nextCount;
				int[] temp = { x, south };
				queue.add(temp);
			}
		}
		if (east < map.length) {
			if (map[east][y] > nextCount || map[east][y] < 0) {
				map[east][y] = nextCount;
				int[] temp = { east, y };
				queue.add(temp);
			}
		}
		if (west > -1) {
			if (map[west][y] > nextCount || map[west][y] < 0) {
				map[west][y] = nextCount;
				int[] temp = { west, y };
				queue.add(temp);
			}
		}
	}

	// -1로 배열 초기화
	public static int[][] initialMap(int N) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = -1;
			}
		}
		return map;
	}
}
