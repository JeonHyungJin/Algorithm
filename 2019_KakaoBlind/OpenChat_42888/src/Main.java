import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		String[] result = solution(record);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList();
		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (!split[0].equals("Leave")) {
				map.put(split[1], split[2]);
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (split[0].equals("Enter")) {
				list.add(map.get(split[1]) + "님이 들어왔습니다.");
			} else if (split[0].equals("Leave")) {
				list.add(map.get(split[1]) + "님이 나갔습니다.");
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
