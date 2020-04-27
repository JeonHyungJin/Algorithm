import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
				
		for(int i = 0 ; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] solution(String s) {
		//문자열 처리
		s = s.substring(2, s.length() - 2).replace("},{", "-");

		String[] arr = s.split("-");
		//길이에 따른 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		ArrayList<Integer> list = new ArrayList<>();
		//기존에 있는지 여부 판단하여 추가
		for (String temp : arr) {
			String[] val = temp.split(",");

			for (int i = 0; i < val.length; i++) {
				int num = Integer.valueOf(val[i]);

				if (!list.contains(num)) {
					list.add(num);
				}
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
