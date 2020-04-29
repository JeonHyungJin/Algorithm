import java.util.*;

public class Main {

	public static void main(String[] args) {
		String[] user_id = { "frodo", "abcd123", "crodo" };
		String[] banned_id = { "*rodo" };
		Solution solution = new Solution();
		System.out.println(solution.solution(user_id, banned_id));
	}

	public static class Solution {

		Set<Integer> set;

		public int solution(String[] user_id, String[] banned_id) {
			set = new HashSet<>();

			go(0, user_id, banned_id, 0);

			return set.size();
		}

		public void go(int index, String[] user_id, String[] banned_id, int bit) {

			if (index == banned_id.length) {
				set.add(bit);
				return;
			}

			String reg = banned_id[index].replace("*", "[\\w\\d]");
			for (int i = 0; i < user_id.length; ++i) {
				if ((((bit >> i) & 1) == 1) || !user_id[i].matches(reg))
					continue;
				go(index + 1, user_id, banned_id, (bit | 1 << i));
			}

		}

	}

}