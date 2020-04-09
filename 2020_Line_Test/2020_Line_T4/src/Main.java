import java.util.Arrays;
import java.util.HashMap;

//Q4
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] snapshots = new String[][] { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = new String[][] { { "1", "SAVE", "ACCOUNT2", "100" },
				{ "2", "WITHDRAW", "ACCOUNT1", "50" }, { "1", "SAVE", "ACCOUNT2", "100" },
				{ "4", "SAVE", "ACCOUNT3", "500" }, { "3", "WITHDRAW", "ACCOUNT2", "30" } };
		System.out.println(solution(snapshots, transactions));
	}

	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> check = new HashMap<String, Integer>();

		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		for (int i = 0; i < transactions.length; i++) {
			if (check.containsKey(transactions[i][0])) {// 이미 넣은 transaction
			} else {
				check.put(transactions[i][0], 1);
				// 계좌 유무 먼저 판단
				if (map.containsKey(transactions[i][2])) { // 있는 경우
					if (transactions[i][1].equals("SAVE")) {
						Integer temp = map.get(transactions[i][2]);
						map.put(transactions[i][2], temp + Integer.parseInt(transactions[i][3]));
					} else if (transactions[i][1].equals("WITHDRAW")) {
						Integer temp = map.get(transactions[i][2]);
						map.put(transactions[i][2], temp - Integer.parseInt(transactions[i][3]));
					}
				} else { // 없는 경우
					map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
				}
			}
		}

		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);

		answer = new String[mapkey.length][2];

		for (int i = 0; i < mapkey.length; i++) {
			String accountName = mapkey[i].toString();
			answer[i][0] = accountName;
			answer[i][1] = (map.get(accountName)).toString();
		}

		return answer;
	}

}
