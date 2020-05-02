import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;

		PriorityQueue<Disk> queue = new PriorityQueue<>();
		List<Disk> list = new ArrayList<>();

		for (int i = 0; i < jobs.length; i++) {
			queue.add(new Disk(jobs[i][0], jobs[i][1]));
		}
		for (int i = 0; i < jobs.length; i++) {
			list.add(queue.poll());
		}

		int time = 0;
		while (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (time >= list.get(i).start) {
					time += list.get(i).time;
					answer += time - list.get(i).start;
					list.remove(i);
					break;
				}
				if (i == list.size() - 1)
					time++;
			}
		}

		answer /= jobs.length;

		return answer;
	}

	public static class Disk implements Comparable<Disk> {
		public int start;
		public int time;

		public Disk(int start, int time) {
			this.start = start;
			this.time = time;
		}

		@Override
		public int compareTo(Disk o) {
			// TODO Auto-generated method stub
			if (this.time < o.time) {
				return -1;
			} else if (this.time == o.time) {
				if (this.start < o.start) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}