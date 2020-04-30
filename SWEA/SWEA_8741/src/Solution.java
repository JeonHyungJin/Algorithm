import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String line = sc.nextLine();
			String[] splited = line.split(" ");
			
			line = splited[0].substring(0, 1) + splited[1].substring(0, 1) + splited[2].substring(0, 1);
			line = line.toUpperCase();
			System.out.println("#" + test_case + " " + line);
					
		}
	}
}
