import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arraySae = sc.nextInt();
		int arrayGa = sc.nextInt();

		int boSae = sc.nextInt();
		int boGa = sc.nextInt();

		if ((boSae == 0 && boGa == 0) || (boSae >= arraySae || boGa >= arrayGa)) {
			System.out.println("fail");
		} else {
			init(arraySae, arrayGa);
			System.out.println(boSae + boGa);
			System.out.println(map[boSae + 1][boGa + 1]);
		}

	}

	private static void init(int n, int m) {
		map = new int[n + 1][m + 1]; // 1칸씩 더 크게 잡음
		int i, j;
		map[0][1] = 1; // (1, 0) 또는 (0, 1)에 1을 넣어준다
		for (i = 1; i <= n; i++)
			for (j = 1; j <= m; j++)
				map[i][j] = map[i - 1][j] + map[i][j - 1]; // 점화식
	}

}
