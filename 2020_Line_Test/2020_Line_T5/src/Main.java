import java.util.*;

//Q5
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] dataSource = new String[][] { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = new String[] { "t1", "t2", "t3" };
		String[] a = solution(dataSource, tags);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};
		ArrayList<String> ans = new ArrayList<>();

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < dataSource.length; i++) {
			for (int j = 1; j < dataSource[i].length; j++) {
				if (map.containsKey(dataSource[i][j])) {
					List<String> tempList = map.get(dataSource[i][j]);
					tempList.add(dataSource[i][0]);
					map.replace(dataSource[i][j], tempList);
				} else {
					List<String> tempList = new ArrayList<String>();
					tempList.add(dataSource[i][0]);
					map.put(dataSource[i][j], tempList);
				}
			}
		}

		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		HashMap<String, Integer> counter2 = new HashMap<String, Integer>();

		for (int i = 0; i < tags.length; i++) {
			List<String> tempList = map.get(tags[i]);
			for (int j = 0; j < tempList.size(); j++) {
				if (counter.containsKey(tempList.get(j))) {
					int tempCount = counter.get(tempList.get(j));
					tempCount++;
					counter.replace(tempList.get(j), tempCount);
				} else {
					counter.put(tempList.get(j), 1);
				}
			}
		}
		
		Iterator it = sortByValue(counter).iterator();
		int itCount = 0;
		while (it.hasNext()) {
			String temp = (String) it.next();
			ans.add(temp);
			itCount++;
			if (itCount == 10) {
				break;
			}
		}
		
		int size = 0;
		answer = new String[ans.size()];
		for (String temp : ans) {
			answer[size++] = temp;
		}

		return answer;
	}

	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;

	}

}
