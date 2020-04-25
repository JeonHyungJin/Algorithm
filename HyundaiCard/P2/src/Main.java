
//P2
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ip_addrs = { "5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0" };
		String[] langs = { "Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript" };
		int[] scores = { 294, 197, 373, 45, 294, 62, 373, 373};

		System.out.println(solution(ip_addrs, langs, scores));

	}

	public static int solution(String[] ip_addrs, String[] langs, int[] scores) {
		int answer = 0;

		List<Student> students = new ArrayList<Student>();
		Map<String, Integer> ipCheck = new HashMap<String, Integer>();

		for (int i = 0; i < ip_addrs.length; i++) {
			int lanInt = 0;
			if (langs[i].startsWith("C")) {
				lanInt = 1;
			} else if (langs[i].equals("Java")) {
				lanInt = 2;
			} else if (langs[i].equals("JavaScript")) {
				lanInt = 3;
			} else {
				lanInt = 4;
			}
			Student student = new Student(ip_addrs[i], lanInt, scores[i]);
			if (ipCheck.get(ip_addrs[i]) == null) {
				ipCheck.put(ip_addrs[i], 1);
			} else {
				ipCheck.replace(ip_addrs[i], ipCheck.get(ip_addrs[i]) + 1);
			}
			students.add(student);
		}

		for (int i = 0; i < students.size(); i++) {
			students.get(i).setIpCount(ipCheck.get(students.get(i).getIp()));
		}

		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getIpCount() >= 4) {
				students.get(i).setTal(true);
			}

			// 3처리
			if (students.get(i).getIpCount() == 3) {
				String checkIp = students.get(i).getIp();
				List<Student> Times3Check = new ArrayList<Student>();
				for (int j = i; j < students.size(); j++) {
					if (students.get(j).getIp().equals(checkIp)) {
						Times3Check.add(students.get(j));
					}
				}
				if (Times3Check.size() == 3) {
					if (Times3Check.get(0).getLanguage() == Times3Check.get(1).getLanguage()
							&& Times3Check.get(1).getLanguage() == Times3Check.get(2).getLanguage()) {
						Times3Check.get(0).setTal(true);
						Times3Check.get(1).setTal(true);
						Times3Check.get(2).setTal(true);
					}
					
					if (Times3Check.get(0).getLanguage() == Times3Check.get(1).getLanguage() &&
							Times3Check.get(0).getScore() == Times3Check.get(1).getScore()) {
						Times3Check.get(0).setTal(true);
						Times3Check.get(1).setTal(true);
					}
					if (Times3Check.get(0).getLanguage() == Times3Check.get(2).getLanguage() &&
							Times3Check.get(0).getScore() == Times3Check.get(2).getScore()) {
						Times3Check.get(0).setTal(true);
						Times3Check.get(2).setTal(true);
					}
					if (Times3Check.get(1).getLanguage() == Times3Check.get(2).getLanguage() &&
							Times3Check.get(1).getScore() == Times3Check.get(2).getScore()) {
						Times3Check.get(1).setTal(true);
						Times3Check.get(2).setTal(true);
					}
					
				}
			}

			if (students.get(i).getIpCount() == 2) {
				String checkIp = students.get(i).getIp();
				List<Student> Times2Check = new ArrayList<Student>();
				for (int j = i; j < students.size(); j++) {
					if (students.get(j).getIp().equals(checkIp)) {
						Times2Check.add(students.get(j));
					}
				}
				if (Times2Check.size() == 2) {
					if (Times2Check.get(0).getLanguage() == Times2Check.get(1).getLanguage()
							&& Times2Check.get(0).getScore() == Times2Check.get(1).getScore()) {
						Times2Check.get(0).setTal(true);
						Times2Check.get(1).setTal(true);
					}
				}
			}

		}

		for (int i = 0; i < students.size(); i++) {
			if (!students.get(i).isTal()) {
				answer++;
			}
		}

		return answer;
	}

	public static class Student {
		private String ip;
		private int ipCount;
		private int language;
		private int score;
		private boolean tal;

		public Student(String ip, int language, int score) {
			super();
			this.ip = ip;
			this.language = language; // 1:C, 2:Java, 3: JS, 4:Py
			this.score = score;
			this.tal = false;
			this.ipCount = 0;
		}

		public int getIpCount() {
			return ipCount;
		}

		public void setIpCount(int ipCount) {
			this.ipCount = ipCount;
		}

		public boolean isTal() {
			return tal;
		}

		public void setTal(boolean tal) {
			this.tal = tal;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public int getLanguage() {
			return language;
		}

		public void setLanguage(int language) {
			this.language = language;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

	}

}
