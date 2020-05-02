
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		long answer = 0;
		for (int i = 0; i < w; i++)
			answer += (Long.valueOf(h) * i) / Long.valueOf(w);

		return answer * 2;
	}
}
