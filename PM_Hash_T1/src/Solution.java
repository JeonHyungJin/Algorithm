import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

	public String solution(String[] participant, String[] completion) {

		Map<String, Integer> hM = new HashMap<String, Integer>();

		String answer = "";

		for (String s : participant) {
			if (!hM.containsKey(s)) {
				hM.put(s, 1);
			} else {
				hM.put(s, hM.get(s) + 1);
			}
		}

		for (String s : completion) {
			if (hM.containsKey(s)) {
				hM.put(s, hM.get(s) - 1);

				if (hM.get(s) == 0) {
					hM.remove(s);
				}
			}
		}

		Iterator<String> keys = hM.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			for (int i = hM.get(key); i > 0; i--) {
				answer = answer + key;
			}
		}
		return answer;
	}

}
