
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ababcdcdababcdcd";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
		if (s.length() == 1)
			return 1;
		int answer = 1001;
		for (int i = 1; i <= s.length() / 2; i++) {
			String now, next = "", result = "";
			int hit = 1;
			for (int j = 0; j <= s.length() / i; j++) {
				int start = j * i;
				int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
				now = next;
				next = s.substring(start, end);

				if (now.equals(next)) {
					hit++;
				} else {
					result += (processHit(hit) + now);
					hit = 1;
				}
			}
			result += (processHit(hit) + next);
			answer = Math.min(answer, result.length());
		}

		return answer;
	}

	private static String processHit(int hit) {
		return hit > 1 ? String.valueOf(hit) : "";
	}
}
