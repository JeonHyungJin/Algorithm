import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p = "(()())()";
		System.out.println(solution(p));

	}

	public static String solution(String p) {
		String answer = "";
		// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
		if (p.equals(""))
			return "";

		int len = p.length();

		int index = -1;
		int left = 0;
		int right = 0;

		// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야
		// 하며, v는 빈 문자열이 될 수 있습니다.
		for (int i = 0; i < len; i++) {
			if (p.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				index = i;
				break;
			}
		}

		String u = p.substring(0, index + 1);
		String v = p.substring(index + 1);

		Stack<Integer> bracketStack = new Stack<Integer>();
		boolean isCorrect = true;

		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				bracketStack.push(1);
			} else {
				if (bracketStack.size() == 0) {
					isCorrect = false;
					break;
				} else {
					bracketStack.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		if (isCorrect) {
			sb.append(u + solution(v));
		} else {
			sb.append("(");

			sb.append(solution(v));

			sb.append(")");

			for (int i = 1; i < index; i++) {
				if (u.charAt(i) == '(') {
					sb.append(")");
				} else {
					sb.append("(");
				}
			}
		}

		return sb.toString();
	}
}
