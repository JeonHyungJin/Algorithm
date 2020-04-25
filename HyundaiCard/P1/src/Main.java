
//P1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String[] pur = { "2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};

		int[] a = solution(pur);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public static int[] solution(String[] purchase) throws ParseException {

		Calendar start_cal = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Map<Date, Integer> dateMap = new HashMap<Date, Integer>();

		Date start_day = formatter.parse("20190101");
		start_cal.setTime(start_day);
		for (int i = 0; i < 365; i++) {
			Calendar tempCal = start_cal;
			dateMap.put(tempCal.getTime(), 0);
			tempCal.add(Calendar.DATE, 1);
		}

		for (int i = 0; i < purchase.length; i++) {
			String[] splited = purchase[i].split(" ");
			String full_date = splited[0];
			String money = splited[1];

			String[] t = full_date.split("/");
			String year = t[0];
			String month = t[1];
			String day = t[2];

			for (int j = 0; j < 30; j++) {
				Date new_day = formatter.parse(year + month + day);
				Calendar new_cal = Calendar.getInstance();
				new_cal.setTime(new_day);
				Calendar tempCal1 = new_cal;
				tempCal1.add(Calendar.DATE, j);
				dateMap.replace(tempCal1.getTime(), dateMap.get(tempCal1.getTime()) + Integer.parseInt(money));
			}
		}

		List<Integer> l1 = new ArrayList<Integer>();
		dateMap.forEach((key, value) -> {
			l1.add(value);
		});

		HashMap<String, Integer> finalArr = checkRank(l1);
		
		int[] answer = new int[finalArr.size()];
		answer[0] = finalArr.get("bronze");
		answer[1] = finalArr.get("silver");
		answer[2] = finalArr.get("gold");
		answer[3] = finalArr.get("platinum");
		answer[4] = finalArr.get("diamond");
		
		return answer;
	}
	
	public static HashMap<String, Integer> checkRank(List<Integer> values) {
		HashMap<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("bronze", 0);
		m1.put("silver", 0);
		m1.put("gold", 0);
		m1.put("platinum", 0);
		m1.put("diamond", 0);

		for (int i = 0; i < values.size(); i++) {
			if (0 <= values.get(i) && values.get(i) < 10000) {
				m1.replace("bronze", m1.get("bronze") + 1);
			} else if (10000 <= values.get(i) && values.get(i) < 20000) {
				m1.replace("silver", m1.get("silver") + 1);
			} else if (20000 <= values.get(i) && values.get(i) < 50000) {
				m1.replace("gold", m1.get("gold") + 1);
			} else if (50000 <= values.get(i) && values.get(i) < 100000) {
				m1.replace("platinum", m1.get("platinum") + 1);
			} else if (values.get(i) >= 100000) {
				m1.replace("diamond", m1.get("diamond") + 1);
			}
		}
		return m1;
	}

}
