import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = { "I 7", "I 5", "I -5", "D -1" };

		int[] answer = solution(operations);
		System.out.println(answer[0]);

		System.out.println(answer[1]);
	}

	public static int[] solution(String[] operations) {
		int[] answer = new int[] { 0, 0 };

		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

		for (String oper : operations) {
			String[] splited = oper.split(" ");
			if (splited[0].equals("I")) {
				minQueue.add(Integer.parseInt(splited[1]));
				maxQueue.add(Integer.parseInt(splited[1]));
			}
			if (splited[0].equals("D")) {
				if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
					if (splited[1].equals("1")) {
						int deleted = maxQueue.peek();
						maxQueue.remove(deleted);
						minQueue.remove(deleted);
					} else if (splited[1].equals("-1")) {
						int deleted = minQueue.peek();
						minQueue.remove(deleted);
						maxQueue.remove(deleted);
					}
				}
			}
		}

		if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
			answer[0] = maxQueue.peek();
			answer[1] = minQueue.peek();
		}

		return answer;
	}
}
