import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		ArrayList<String> multiSet1 = new ArrayList<>();
		ArrayList<String> multiSet2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		for (int i = 0; i < str1.length() - 1; ++i) {
			char first = str1.charAt(i);
			char second = str1.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				multiSet1.add(first + "" + second);
			}
		}

		for (int i = 0; i < str2.length() - 1; ++i) {
			char first = str2.charAt(i);
			char second = str2.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				multiSet2.add(first + "" + second);
			}
		}

		return answer;
	}
}
