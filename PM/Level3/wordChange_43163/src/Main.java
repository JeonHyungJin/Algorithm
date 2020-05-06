import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(solution(begin, target, words));
	}

	static int[][] dfsArr;
	static boolean[] isVisited;
	static int[] parent;

	public static int solution(String begin, String target, String[] words) {
		int idx = -1;

		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i])) {
				idx = i;
			}
		}

		if (idx == -1) {
			return 0;
		}

		if (idx != words.length - 1) {
			String temp = words[words.length - 1];
			words[idx] = temp;
			words[words.length - 1] = target;
		}

		makeGraph(begin, words);
		isVisited = new boolean[dfsArr.length];

		bfs2(0);
		LinkedList<Integer> result = shortestPath(dfsArr.length - 1, parent);

		return result.size();
	}

	public static void bfs2(int start) {
		int[] distance = new int[dfsArr.length];
		parent = new int[dfsArr.length]; // BFS 스패닝 트리에서 i의 부모의 번호
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);

		LinkedList<Integer> q = new LinkedList<>();
		distance[start] = 0;
		parent[start] = start;
		q.add(start);

		while (!q.isEmpty()) {
			int here = q.poll();

			for (int i = 0; i < dfsArr[here].length; i++) {
				if (dfsArr[here][i] != 0 && distance[i] == -1) {
					q.add(i);
					distance[i] = distance[here] + 1;
					parent[i] = here;
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}

	public static LinkedList<Integer> shortestPath(int v, int[] parent) {
		LinkedList<Integer> path = new LinkedList<>();

		while (parent[v] != v) {
			v = parent[v];
			path.add(v);
		}
		Collections.reverse(path);
		return path;
	}

	public static void makeGraph(String begin, String[] words) {
		dfsArr = new int[words.length + 1][words.length + 1];
		String[] wordsWithBegin = new String[words.length + 1];
		wordsWithBegin[0] = begin;
		System.arraycopy(words, 0, wordsWithBegin, 1, words.length);

		for (int i = 0; i < wordsWithBegin.length; i++) {
			for (int j = i + 1; j < wordsWithBegin.length; j++) {
				if (isNext(wordsWithBegin[i], wordsWithBegin[j]) == 1) {
					dfsArr[i][j] = 1;
					dfsArr[j][i] = 1;
				}
			}
		}
	}

	public static int isNext(String begin, String next) {
		int difCount = 0;
		for (int i = 0; i < next.length(); i++) {
			if (begin.charAt(i) != next.charAt(i)) {
				difCount++;
				if (difCount >= 2) {
					return 0;
				}
			}
		}
		return difCount;
	}

}
