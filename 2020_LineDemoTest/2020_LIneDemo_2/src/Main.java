import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			l.add(i, sc.nextInt());
		}
		Collections.sort(l);
		int count = sc.nextInt();

		if (count == 1) {
			System.out.println(l.get(0) + " " + l.get(1) + " " + l.get(2));
		} else if (count == 2) {
			System.out.println(l.get(0) + " " + l.get(2) + " " + l.get(1));
		} else if (count == 3) {
			System.out.println(l.get(1) + " " + l.get(0) + " " + l.get(2));
		} else if (count == 4) {
			System.out.println(l.get(1) + " " + l.get(2) + " " + l.get(0));
		} else if (count == 5) {
			System.out.println(l.get(2) + " " + l.get(0) + " " + l.get(1));
		} else {
			System.out.println(l.get(2) + " " + l.get(1) + " " + l.get(0));
		}
	}

}
