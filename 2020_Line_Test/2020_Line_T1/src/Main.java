import java.util.*;

//Q1
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("line [plus]"));
	}

	public static int solution(String inputString) {

		int count = 0;
		Stack mStack = new Stack<>();
		for (int loopCount = 0; loopCount < inputString.length(); loopCount++) {
			char ch = inputString.charAt(loopCount);
			switch (ch) {
			case '(':
			case '{':
			case '[':
			case '<':
				mStack.push(ch);
				break;
			case ')':
				if (mStack.isEmpty() || !mStack.contains('(')) {
					return -1;
				} else if (mStack.contains('(')) {
					for (int i = mStack.size() - 1; i >= 0; i--) {
						char tempChar = (char) mStack.get(i);
						if (tempChar == '(') {
							mStack.remove(i);
							count++;
						}
					}
				}
				break;
			case '}':
				if (mStack.isEmpty() || !mStack.contains('{')) {
					return -1;
				} else if (mStack.contains('{')) {
					for (int i = mStack.size() - 1; i >= 0; i--) {
						char tempChar = (char) mStack.get(i);
						if (tempChar == '{') {
							mStack.remove(i);
							count++;
						}
					}
				}
				break;
			case ']':
				if (mStack.isEmpty() || !mStack.contains('[')) {
					return -1;
				} else if (mStack.contains('[')) {
					for (int i = mStack.size() - 1; i >= 0; i--) {
						char tempChar = (char) mStack.get(i);
						if (tempChar == '[') {
							mStack.remove(i);
							count++;
						}
					}
				}
				break;
			case '>':
				if (mStack.isEmpty() || !mStack.contains('<')) {
					return -1;
				} else if (mStack.contains('<')) {
					for (int i = mStack.size() - 1; i >= 0; i--) {
						char tempChar = (char) mStack.get(i);
						if (tempChar == '<') {
							mStack.remove(i);
							count++;
						}
					}
				}
				break;
			}
		}
		if (!mStack.isEmpty()) {
			return -1;
		} else {
			return count;
		}

	}

}
