//Kakao Summer Intern Prob4

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int answer = 0;
		int minMoney = 10000000;
		int len = board.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] == 0) {
					System.out.println(dfs(i, j, board, board.length - 1, 100, 1, 100));
				}
			}
		}

		return answer;
	}

	public static int dfs(int x, int y, int[][] board, int target, int money, int direct, int added) {
		// direct -> : 1, <- : 3, ^ : 2, under : 4
		if (x < 0 || y < 0 || x >= board.length || y >= board.length || board[x][y] != 0) {

			return money - added;
		}
		if ((x == target && y == target)) {
			return money;
		}
		board[x][y] = 1;
		if (direct == 1) {
			money = dfs(x + 1, y, board, target, money + 100, direct, 100);
			money = dfs(x, y + 1, board, target, money + 500, 2, 500);
			money = dfs(x, y - 1, board, target, money + 500, 4, 500);
		} else if (direct == 2) {
			money = dfs(x + 1, y, board, target, money + 500, 1, 500);
			money = dfs(x - 1, y, board, target, money + 500, 3, 500);
			money = dfs(x, y + 1, board, target, money + 100, direct, 100);
		} else if (direct == 3) {
			money = dfs(x - 1, y, board, target, money + 100, direct, 100);
			money = dfs(x, y + 1, board, target, money + 500, 2, 500);
			money = dfs(x, y - 1, board, target, money + 500, 4, 500);
		} else if (direct == 4) {
			money = dfs(x + 1, y, board, target, money + 500, 1, 500);
			money = dfs(x - 1, y, board, target, money + 500, 3, 500);
			money = dfs(x, y - 1, board, target, money + 100, direct, 100);
		}

		return money;

	}

//	public static int solution(int[][] board) {
//		int answer = 0;
//		int minMoney = 10000000;
//
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				if (board[i][j] == 0) {
//					int money = dfs(i, j, board, board.length, board.length, board.length - 1, 100, 1);
//					System.out.println(money);
//				}
//			}
//		}
//
//		return answer;
//	}
//
//	public static int dfs(int x, int y, int[][] board, int m, int n, int target, int money, int postDir) {
//
//		if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 0) {
//			return money;
//		}
//		if ((x == target && y == target)) {
//			System.out.println("[" + x + " , " + y + "]");
//			System.out.println(money);
//			return money;
//		}
//		System.out.println("[" + x + " , " + y + "]");
//
//		board[x][y] = -1;
//		int incre = 0;
//		for (int i = 0; i < 4; i++) {
//			int[] dir = dirs[i];
//			if (postDir == 1) {
//				if (i == 2) {
//					incre = 100;
//				} else {
//					incre = 500;
//				}
//			} else if (postDir == 2) {
//				if (i == 3) {
//					incre = 100;
//				} else {
//					incre = 500;
//				}
//			} else if (postDir == 3) {
//				if (i == 0) {
//					incre = 100;
//				} else {
//					incre = 500;
//				}
//			} else if (postDir == 4) {
//				if (i == 2) {
//					incre = 100;
//				} else {
//					incre = 500;
//				}
//			}
//			if (i == 0) {
//				postDir = 3;
//			} else if (i == 1) {
//				postDir = 1;
//			} else if (i == 2) {
//				postDir = 4;
//			} else {
//				postDir = 2;
//			}
//
//			money = dfs(x + dir[0], y + dir[1], board, m, n, target, money + incre, postDir);
//		}
//		return money;
//	}
}
