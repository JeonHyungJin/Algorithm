//SkillCheck2 Prob2

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };

		System.out.println(solution(arr1, arr2));
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				for (int k = 0; k < arr2[0].length; k++) {
					answer[i][k] += arr1[i][j] * arr2[j][k];
				}
			}
		}

		return answer;
	}
}
