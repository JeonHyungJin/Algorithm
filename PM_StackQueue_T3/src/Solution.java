import java.util.*;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int days = 0;

		List<Integer> list = new ArrayList<>();
		List<Integer> answerList = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] == 0)
				days = (100 - progresses[i]) / speeds[i];
			else
				days = (100 - progresses[i]) / speeds[i] + 1;
			list.add(days);
		}

		
		

		return answer;
	}
}
