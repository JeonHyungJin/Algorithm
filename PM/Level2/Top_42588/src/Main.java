public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] heights = new int[] { 6, 9, 5, 7, 4 };
		System.out.println(solution(heights));

	}

	public static int[] solution(int[] heights) {
		int heightNum = heights.length;
		int[] answer = new int[heightNum];

		for (int i = heightNum - 1; i >= 0; i--) {
			int nowHeight = heights[i];
			for (int j = i - 1; j >= 0; j--) {
				int tempHeight = heights[j];
				if(tempHeight > nowHeight) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}

}
