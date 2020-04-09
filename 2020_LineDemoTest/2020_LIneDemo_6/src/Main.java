import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	int n, align, maxRow;
	int[] cols = new int[105];
	int[] numbers = new int[105];

	private void input() {
		String alignString;
		n = sc.nextInt();
		alignString = sc.next();
		if (alignString.equals("TOP")) {
			align = 0;
		} else if (alignString.equals("MIDDLE")) {
			align = 1;
		} else {
			align = 2;
		}
		int max = -1;
		for (int i = 0; i < n; i++) {
			cols[i] = sc.nextInt();
			numbers[i] = sc.nextInt();
			if (max < cols[i]) {
				max = cols[i];
			}
		}
		maxRow = max * 2 - 1;
	}

	int[][] numberPad = new int[][] { { 0, 3, 3, 3, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 2, 0 }, { 0, 1, 0, 1, 0 },
			{ 3, 3, 0, 1, 1 }, { 0, 2, 0, 1, 0 }, { 2, 2, 0, 3, 0 }, { 0, 1, 1, 1, 1 }, { 0, 3, 0, 3, 0 },
			{ 0, 3, 0, 1, 1 } };

	private void printShape(int type, int col) {
		for (int i = 0; i < col; i++) {
			if (i == 0) {
				if (type == 1 || type == 4) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}
			} else if (i == col - 1) {
				if (type == 2 || type == 4) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}
			} else {
				if (type != 0 || type == 4) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}
			}
		}
	}

	int getAreaType(int row, int curRow) {
		int gap = maxRow - row, margin;

		if (align == 0) {
			margin = 0;
		} else if (align == 1) {
			margin = gap / 2;
		} else {
			margin = gap;
		}

		int top = 0 + margin;
		int middle = row / 2 + margin;
		int bottom = row - 1 + margin;

		if (curRow == top) {
			return 0;
		} else if (top < curRow && curRow < middle) {
			return 1;
		} else if (curRow == middle) {
			return 2;
		} else if (middle < curRow && curRow < bottom) {
			return 3;
		} else if (curRow == bottom) {
			return 4;
		} else {
			return -1;
		}
	}

	private void printNumber(int number, int row, int col, int curRow) {
		int areaType = getAreaType(row, curRow);
		int shapeType = areaType < 0 ? 4 : numberPad[number][areaType];
		printShape(shapeType, col);
	}

	private void print() {
		for (int row = 0; row < maxRow; row++) {
			for (int i = 0; i < n; i++) {
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
