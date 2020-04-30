import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		
		for(int i = 0; i < tCase; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n+1][2];
			
			if(n == 0) {
				System.out.println("1 0");
				continue;
			}
			if(n == 1) {
				System.out.println("0 1");
				continue;
			}
			
			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;

			for(int j = 2;j <= n; j++) {
				arr[j][0] = arr[j-1][0] + arr[j-2][0];
				arr[j][1] = arr[j-1][1] + arr[j-2][1];
			}
			System.out.println(arr[n][0] + " " + arr[n][1]);
			
		}
		
	
	}
	
}
