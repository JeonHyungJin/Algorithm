import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		System.out.println(solution(progresses, speeds));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> works = new ArrayList<Integer>();
		List<Integer> speedsArr = new ArrayList<Integer>();
		List<Integer> answerArr = new ArrayList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			works.add(progresses[i]);
			speedsArr.add(speeds[i]);
		}

		while (!works.isEmpty()) {
			if (works.get(0) >= 100) {
				answerArr.add(countDone(works, speedsArr));
			} else {
				for (int i = 0; i < works.size(); i++) {
					works.set(i, works.get(i) + speedsArr.get(i));
				}
			}
		}
		
		int[] answer = new int[answerArr.size()];
		for(int i = 0; i < answerArr.size(); i++) {
			answer[i] = answerArr.get(i);
		}
		
		return answer;
	}

	public static int countDone(List<Integer> works, List<Integer> speedsArr) {
		int result = 0;

		while (!works.isEmpty() && works.get(0) >= 100) {
			works.remove(0);
			speedsArr.remove(0);
			result++;
		}

		return result;
	}

}
