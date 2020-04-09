import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int GroupCount = sc.nextInt();
		int opened = sc.nextInt();

		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 0; i < opened; i++) {
			l.add(i, 0);
		}
		for (int i = 0; i < GroupCount; i++) {
			int peopleNum = sc.nextInt();
			l.set(l.indexOf(Collections.min(l)), l.get(l.indexOf(Collections.min(l))) + peopleNum);
		}
		System.out.println(Collections.max(l));
	}
}
