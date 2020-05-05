
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(solution(n));
	}

	public static int[] solution(int n) {
		if (n == 1) {
			return new int[] { 0 };
		}
		int lengthOfArr = (int) Math.pow(2, n) - 1;
		int[] answer = new int[lengthOfArr];
		String ansStr = "0";
		for (int i = 1; i < n; i++) {
			ansStr = ansStr + "0" + reverseStr(ansStr);
		}
		for (int i = 0; i < ansStr.length(); i++) {
			answer[i] = Integer.parseInt(ansStr.substring(i, i + 1));
		}
		return answer;
	}

	public static String reverseStr(String number) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < number.length(); i++) {
			String Str = number.substring(i, i + 1);
			sb.insert(0, ((Str.equals("0")) ? "1" : "0"));
		}

		return sb.toString();
	}
}
