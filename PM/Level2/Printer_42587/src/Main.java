import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = { 2, 1, 3, 2 };
		int location = 0;
		System.out.println(solution(priorities, location));
	}

	public static Queue<Print> queue;

	public static int solution(int[] priorities, int location) {
		int[] order = new int[priorities.length];
		queue = new LinkedList<>();
		int answer = 0;

		// queue에 넣기
		for (int i = 0; i < priorities.length; i++) {
			Print print = new Print(priorities[i], i);
			queue.offer(print);
		}

		int j = 0;
		while (!queue.isEmpty()) {
			Print print = queue.poll();
			int priority = print.priority;

			// 큰 수가 있나 찾아보기
			if (check(priority))
				queue.offer(print);
			else {
				order[j] = print.index;
				j++;
			}
		}

		for (int i = 0; i < order.length; i++) {
			if (order[i] == location) {
				answer = i + 1;
				break;
			}

		}
		return answer;
	}

	public static boolean check(int num) {
		boolean flag = false;

		// list를 array로 변환
		Print[] list = queue.toArray(new Print[queue.size()]);

		for (int i = 0; i < list.length; i++) {
			if (list[i].priority > num) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	static class Print {
		int priority;
		int index;

		Print(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}
	}

}
