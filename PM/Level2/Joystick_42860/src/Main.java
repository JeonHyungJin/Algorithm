
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "BBBABAAAAAAAAX";
		System.out.println(solution(name));
	}

	public static int solution(String name) {
		return countGready(name) + countToA(name);
	}

	public static int countGready(String name) {
		int minVal = name.length() - 1;

		for (int i = 0; i < name.length(); i++) {
			char nowChar = name.charAt(i);
			if (nowChar == 'A') {
				int nextIdx = i + 1;
				int countA = 0;
				while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
					countA++;
					nextIdx++;
				}
				int tmp = (i - 1) * 2 + (name.length() - 1 - i - countA);
				if (minVal > tmp)
					minVal = tmp;
			}
		}
		return minVal;
	}

	public static int countToA(String name) {
		int counter = 0;
		for (int i = 0; i < name.length(); i++) {
			char nowChar = name.charAt(i);
			if (nowChar <= 'N') {
				counter = counter + (nowChar - 'A');
			} else {
				counter = counter + ('Z' - nowChar + 1);
			}
		}
		return counter;
	}
}
