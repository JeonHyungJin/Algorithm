import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "71";
		System.out.println(solution(numbers));
	}

	public static int solution(String numbers) {
		int[] numbList = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			numbList[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
		}

		Set<Integer> primeList = new HashSet<>();
		for (int i = 1; i <= numbList.length; i++) {
			perm(numbList, 0, i, primeList);
		}

		return primeList.size();
	}

	public static void perm(int[] arr, int depth, int k, Set primeList) {
		if (depth == k) {
			returnNumber(arr, k, primeList);
			return;
		} else {
			for (int i = depth; i < arr.length; i++) {
				swap(arr, i, depth);
				perm(arr, depth + 1, k, primeList);
				swap(arr, i, depth);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void returnNumber(int[] arr, int k, Set primeList) {
		int resultNumber = 0;
		for (int i = 0; i < k; i++) {
			resultNumber += arr[i] * Math.pow(10, k - 1 - i);
		}
		prime(primeList, resultNumber);
	}

	private static void prime(Set primeList, int resultNumber) {
		boolean isPrime = true;
		if (resultNumber <= 1) {
			return;
		}
		for (int j = 2; j <= Math.sqrt(resultNumber); j++) {
			if (resultNumber % j == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			primeList.add(resultNumber);
		}
	}
}
