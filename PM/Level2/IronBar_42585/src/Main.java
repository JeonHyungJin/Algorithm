import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));

	}

	public static int solution(String arrangement) {
		int answer = 0;
		int arrLen = arrangement.length();

		Stack<Integer> stickStack = new Stack<Integer>(); // "(" : 0, ")" : 1

		for (int i = 0; i < arrLen; i++) {
			int now = arrangement.charAt(i) == '(' ? 0 : 1;
			if (now == 0) {
				stickStack.add(now);
			} else {
				stickStack.pop();
				if (arrangement.charAt(i - 1) == '(') {
					answer += stickStack.size();
				} else {
					answer++;
				}
			}
		}
		return answer;
	}
}
