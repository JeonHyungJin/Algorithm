
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String number = "192411";
		int k = 2;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		int index = 0;
		char max;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';
			for (int j = index; j <= k + i; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					index = j + 1;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}
