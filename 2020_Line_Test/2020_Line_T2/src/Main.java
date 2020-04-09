import java.util.*;

//Q2
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[] { "24553", "24553", "24553", "24553" };
		System.out.println(solution("24551", a));
	}

	public static int solution(String answer_sheet, String[] sheets) {

		int[][] arr = new int[sheets.length][answer_sheet.length()];

		for (int i = 0; i < sheets.length; i++) {
			for (int j = 0; j < answer_sheet.length(); j++) {
				if (sheets[i].charAt(j) == answer_sheet.charAt(j)) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = Character.getNumericValue(sheets[i].charAt(j));
				}
			}
		}

		int max = 0;

		for (int i = 0; i < sheets.length; i++) {
			for (int j = i + 1; j < sheets.length; j++) {
				int flag = -1;
				int count = 0;
				int total = 0;
				int maxCon = 0; // 최대 연속 같은 수
				for (int k = 0; k < answer_sheet.length(); k++) {
					if (arr[i][k] != 0) {
						if (arr[i][k] == arr[j][k]) {
							total++;
							if (flag == 1) {
								count++;
							} else {
								flag = 1;
								count++;
							}
						} else { // 수 다르면
							if (maxCon < count) {
								maxCon = count;
							}
							flag = -1;
							count = 0;
						}
					}
				}

				int val = total + (maxCon * maxCon);
				if (max < val) {
					max = val;
				}
			}
		}
		if (max == 1) {
			return 2;
		}
		return max;
	}
}
