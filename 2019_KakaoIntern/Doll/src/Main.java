import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int ans = 0;
		int len = board.length;
		Stack<Integer>[] stack = new Stack[len];
		Stack<Integer> basket = new Stack<>();

		for (int i = 0; i < board[0].length; i++) {
			stack[i] = new Stack<>();
			for (int j = board.length - 1; j >= 0; j--) {
				if (board[j][i] != 0)
					stack[i].push(board[j][i]);
			}
		}

		for (int i = 0; i < moves.length; i++) {
			if (!stack[moves[i] - 1].isEmpty()) {
				int t = stack[moves[i] - 1].pop();
				if (!basket.isEmpty()) {
					if (basket.peek() == t) {
						basket.pop();
						ans += 2;
					} else
						basket.push(t);
				} else
					basket.push(t);
			}
		}
		return ans;
	}

}
