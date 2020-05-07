import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

		System.out.println(solution(N, stages));
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int peopleNum = stages.length;
		int[] roundPeople = new int[N];
		fail[] failArr = new fail[N];

		for (int i = 0; i < peopleNum; i++) {
			if (stages[i] != N + 1) {
				roundPeople[stages[i] - 1]++;
			}
		}

		for (int i = 0; i < N; i++) {
			if (peopleNum != 0) {
				fail thisRound = new fail(i, (double) roundPeople[i] / peopleNum);
				peopleNum -= roundPeople[i];
				failArr[i] = thisRound;
			} else {
				failArr[i] = new fail(i, 0);
			}
		}

		Arrays.sort(failArr, new Comparator<fail>() {
			public int compare(fail o1, fail o2) {
				if (o1.failRate != o2.failRate) {
					return -Double.compare(o1.failRate, o2.failRate);
				}
				return o1.roundNum - o2.roundNum;
			}
		});

		for (int i = 0; i < answer.length; i++) {
			answer[i] = failArr[i].roundNum + 1;
		}

		return answer;
	}

	static class fail {
		public int roundNum;
		public double failRate;

		public fail(int roundNum, double failRate) {
			this.roundNum = roundNum;
			this.failRate = failRate;
		}
	}
}
