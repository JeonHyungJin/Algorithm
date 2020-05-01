
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(10));
	}

	public static String solution(int n) {
		String answer = "";
		int rmd;

		while (n > 0) {
			rmd = n % 3;
			n = n / 3;

			if (rmd == 0) {
				n -= 1;
				rmd = 4;
			}

			answer = rmd + answer;
		}

		return answer;
	}

}
