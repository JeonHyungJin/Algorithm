import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		for (int scov : scoville) {
			priorityQueue.add(scov);
		}

		while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
			int first = priorityQueue.poll();
			int second = priorityQueue.poll();
			int newScov = first + (second * 2);
			priorityQueue.add(newScov);
			answer++;
		}

		if (priorityQueue.peek() < K) {
			return -1;
		}

		return answer;
	}

}
