import java.util.*;

// Still doing.................
// Doing......
// Url : https://programmers.co.kr/learn/courses/30/lessons/1830

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String sentence = "HaEaLaLaObWORLDb";
		String sentence = "HaEaLbWORLDb";

		System.out.println(solution(sentence));
	}

	static HashMap<Integer, Integer> lowerCount = new HashMap<>();
	static List<String> wordArr = new ArrayList<>();

	public static String solution(String sentence) {
		String answer = "";

		countLower(sentence);

		for (int i = 0; i < sentence.length() - 1; i++) {
			char nowChar = sentence.charAt(i);
			char nextChar = sentence.charAt(i + 1);

			if (isUpper(nowChar)) { // 지금이 대문자인 경우
				if (isUpper(nextChar)) { // 다음이 대문자 인 경우

				} else { // 다음이 소문자인 경우
					int howMany = lowerCount.get((int) nextChar);
					if (howMany == 1) {
						sentence = sentence.substring(0, i + 1) + sentence.substring(i + 2);
					} else if (howMany == 2) {
						int nextIdx = -1;
						for (int j = i + 2; j < sentence.length(); j++) {
							if (nextChar == sentence.charAt(j)) {
								nextIdx = j;
							}
							if (nextIdx != -1) {
								sentence = sentence.substring(0, i + 1) + sentence.substring(i + 2, nextIdx)
										+ sentence.substring(nextIdx + 1);
								nextIdx = -1;
							}
						}
					} else if (howMany >= 3) {

					}
				}
			} else { // 지금이 소문자인 경우

			}
		}

		return answer;
	}

	public static boolean isUpper(char ch) {
		if (ch >= 65 && ch <= 90) {
			return true;
		}
		return false;
	}

	public static void countLower(String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			char nowChar = sentence.charAt(i);
			if (!isUpper(nowChar)) {
				if (lowerCount.containsKey((int) nowChar)) {
					lowerCount.replace((int) nowChar, lowerCount.get((int) nowChar) + 1);
				} else {
					lowerCount.put((int) nowChar, 1);
				}
			}
		}
	}
}
