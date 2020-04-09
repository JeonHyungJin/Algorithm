import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tableCount = sc.nextInt();
		int[] a = new int[tableCount];

		for (int i = 0; i < tableCount; i++) {
			a[i] = sc.nextInt();
		}

		int j;
		int maxLen = 0;
		int count = 0;

		for (j = 0; j < tableCount; j++) {
			if (a[j] == 1) {
				break;
			}
		}

		for (j = j + 1; j < tableCount; j++) {
			if (a[j] == 0) {
				count++;
			} else {
				int temp = count % 2 == 1 ? count / 2 + 1 : count / 2;
				if (maxLen < temp) {
					maxLen = temp;
					count = 0;
				}
			}
		}

		count = 0;
		for (int i = 0; i < tableCount; i++) {
			if (a[i] == 0) {
				count++;
			} else {
				break;
			}
		}
		if (maxLen < count) {
			maxLen = count;
		}

		count = 0;
		for (int i = tableCount - 1; i >= 0; i--) {
			if (a[i] == 0) {
				count++;
			} else {
				break;
			}
		}
		if (maxLen < count) {
			maxLen = count;
		}

		System.out.println(maxLen);
	}
}
