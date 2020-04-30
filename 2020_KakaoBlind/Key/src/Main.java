public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		int lockLen = lock.length;
		int[][] lock3Times = new int[lockLen * 3][lockLen * 3];

		for (int i = lockLen; i < 2 * lockLen; i++) {
			for (int j = lockLen; j < 2 * lockLen; j++) {
				lock3Times[i][j] = lock[i - lockLen][j - lockLen];
			}
		}

		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < lockLen * 2; i++) {
				for (int j = 0; j < lockLen * 2; j++) {
					int[][] res = appendArr(key, lock3Times, i, j);
					if (isMatch(res, lockLen)) {
						answer = true;
						break;
					}
				}
			}
			key = rotate(key);
		}

		return answer;
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] appendArr(int[][] key, int[][] lock, int gaStart, int saStart) {
		int[][] temp = new int[lock.length][lock.length];
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				temp[i][j] = lock[i][j];
			}
		}
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				temp[gaStart + i][saStart + j] = lock[gaStart + i][saStart + j] + key[i][j];
			}
		}
		return temp;
	}

	public static boolean isMatch(int[][] lockAndKey, int lockLen) {
		for (int i = lockLen; i < lockLen * 2; i++) {
			for (int j = lockLen; j < lockLen * 2; j++) {
				int tempVal = lockAndKey[i][j];
				if (tempVal != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[][] rotate(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotate = new int[m][n];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = arr[n - 1 - j][i];
			}
		}

		return rotate;
	}

}
