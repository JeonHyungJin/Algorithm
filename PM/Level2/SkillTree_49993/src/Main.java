
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(solution(skill, skill_trees));

	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			boolean flag = true;
			String nowTree = skill_trees[i];
			String front = "";
			for (int j = 0; j < skill.length(); j++) {
				char sk = skill.charAt(j);
				int index = nowTree.indexOf(sk);

				if (front.contains(String.valueOf(sk))) {
					flag = false;
					break;
				}
				if (index == -1) {
					front = nowTree;
				} else {
					front = nowTree.substring(0, index);
				}
			}
			if (flag) {
				answer++;
			}
		}

		return answer;
	}

}
