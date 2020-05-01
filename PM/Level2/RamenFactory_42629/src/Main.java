import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		System.out.println(solution(stock, dates, supplies, k));
		
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		//우선 순위 큐 오름차순으로 정렬
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		//현재의 날짜와 공급날짜를 비교하기 위해서 비교시 index를 증가해주는 역할
		int dayCheck = 0;
		for (int i = 0; i < k; i++) {
			//오늘이 수입이 가능한 날짜인지 체크
			if (dayCheck < dates.length && i == dates[dayCheck]) {
				priorityQueue.add(supplies[dayCheck++]);
			}
			//재고 없는 경우 우선순위 큐에서 가장 큰 값 가져옴
			if (stock == 0) {
				stock += priorityQueue.poll();
				answer++;
			}
			//하루 한개씩 소진
			stock -= 1;
		}
		return answer;
	}

}
