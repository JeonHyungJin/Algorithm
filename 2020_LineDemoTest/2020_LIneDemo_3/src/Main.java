import java.util.*;

public class Main {

	static int[] arr = new int[160];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int start, end;
		int max = 0;
		for (int i = 0; i < N; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			for (int j = start; j < end; j++) {
				arr[j]++;
				if (max < arr[j]) {
					max = arr[j];
				}
			}
		}
		System.out.println(max);

//		int peopleNum = sc.nextInt();
//
//		ArrayList<Integer> l = new ArrayList<>();
//
//		for (int i = 0; i < peopleNum; i++) {
//			int startTime = sc.nextInt();
//			int endTime = sc.nextInt();
//
//			if (i == 0) {
//				l.add(endTime);
//			} else {
//				for (int j = 0; j < l.size(); j++) {
//					if (l.get(j) <= startTime) {
//						l.set(j, endTime);
//						break;
//					} else {
//						l.add(endTime);
//						break;
//					}
//				}
//			}
//		}
//		System.out.println(l.size());
	}
}
