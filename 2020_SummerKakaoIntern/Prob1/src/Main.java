//Kakao Summer Intern Prob1

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };

		String hand = "right";

		System.out.println(solution(numbers, hand));
	}

	static int[][] keyPad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -2 } };

	public static String solution(int[] numbers, String hand) {
		String answer = "";

		int nowLeft = -1, nowRight = -2;

		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			if (nowLeft == num) {
				answer += "L";
				nowLeft = num;
			} else if (nowRight == num) {
				answer += "R";
				nowRight = num;
			} else if (num == 1 || num == 4 || num == 7) {
				answer += "L";
				nowLeft = num;
			} else if (num == 3 || num == 6 || num == 9) {
				answer += "R";
				nowRight = num;
			} else if (num == 2 || num == 5 || num == 8 || num == 0) {
				if (leftOrRight(num, nowLeft, nowRight) == -1) {
					answer += "L";
					nowLeft = num;
				} else if (leftOrRight(num, nowLeft, nowRight) == 1) {
					answer += "R";
					nowRight = num;
				} else if (leftOrRight(num, nowLeft, nowRight) == 0) {
					if (hand.equals("right")) {
						answer += "R";
						nowRight = num;
					} else {
						answer += "L";
						nowLeft = num;
					}
				}
			}
		}

		return answer;
	}

	public static int leftOrRight(int target, int left, int right) {
		// Left : -1, smae : 0, Right : 1

		int leftX = 0, leftY = 0, rightX = 0, rightY = 0;
		int leftDist = 0, rightDist = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (keyPad[i][j] == left) {
					leftX = i;
					leftY = j;
				}
				if (keyPad[i][j] == right) {
					rightX = i;
					rightY = j;
				}
			}
		}

		if (target == 2) {
			leftDist = getDist(0, 1, leftX, leftY);
			rightDist = getDist(0, 1, rightX, rightY);
		} else if (target == 5) {
			leftDist = getDist(1, 1, leftX, leftY);
			rightDist = getDist(1, 1, rightX, rightY);
		} else if (target == 8) {
			leftDist = getDist(2, 1, leftX, leftY);
			rightDist = getDist(2, 1, rightX, rightY);
		} else if (target == 0) {
			leftDist = getDist(3, 1, leftX, leftY);
			rightDist = getDist(3, 1, rightX, rightY);
		}
		if (leftDist == rightDist) {
			return 0;
		} else if (leftDist > rightDist) {
			return 1; // right click
		} else {
			return -1;
		}
	}

	public static int getDist(int targetX, int targetY, int fromX, int fromY) {
		int result = 0;

		result = (Math.abs(targetX - fromX)) + (Math.abs(targetY - fromY));
		return result;
	}

}
