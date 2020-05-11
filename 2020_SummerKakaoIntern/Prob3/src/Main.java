import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Kakao Summer Intern Prob3

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = { "AAA", "AAA", "AAA" };
		System.out.println(solution(gems));
	}

	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int finalStart = -1, finalEnd = -1;
		int dist = 0; // 최종 거리
		int nowDist = 0; // 지금의 거리

		Map<String, Integer> gemMap = new HashMap<String, Integer>();
		Set<String> gemSet = new HashSet<String>();
		Set<String> nowGemSet;

		for (int i = 0; i < gems.length; i++) {
			gemSet.add(gems[i]);
		}

		if (gemSet.size() == 1) {
			answer[0] = 1;
			answer[1] = 1;
			return answer;
		}

		for (int i = 0; i < gems.length; i++) {
			nowGemSet = new HashSet<String>();
			int start = -1;
			int end = -1;
			nowGemSet.add(gems[i]);
			for (int j = i + 1; j < gems.length; j++) {
				nowGemSet.add(gems[j]);
				if (nowGemSet.size() == gemSet.size()) {
					start = i + 1;
					end = j + 1;
					if (finalStart == -1 && finalEnd == -1) {
						finalStart = start;
						finalEnd = end;
						dist = finalEnd - finalStart;
					} else {
						nowDist = end - start;
						if (dist == nowDist) {
							if (finalStart > start) {
								finalStart = start;
								finalEnd = end;
							}
						} else if (dist > nowDist) {
							finalStart = start;
							finalEnd = end;
							dist = nowDist;
						}
					}
					break;
				}
			}
		}

		answer[0] = finalStart;
		answer[1] = finalEnd;

		return answer;
	}
}
