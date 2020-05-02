import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(solution(bridge_length, weight, truck_weights));

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> waiting = new LinkedList<>();
		Queue<Truck> bridge = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; ++i) {
			waiting.offer(new Truck(truck_weights[i], 0));
		}

		int time = 0;
		int totalWeight = 0;
		while (!waiting.isEmpty() || !bridge.isEmpty()) {
			time++;
			if (!bridge.isEmpty()) {
				Truck t = bridge.peek();
				if (time - t.entry >= bridge_length) {
					totalWeight -= t.weight;
					bridge.poll();
				}
			}

			if (!waiting.isEmpty()) {
				if (totalWeight + waiting.peek().weight <= weight) {
					Truck t = waiting.poll();
					totalWeight += t.weight;

					bridge.offer(new Truck(t.weight, time));
				}
			}
		}
		return time;
	}

	static class Truck {
		int weight;
		int entry;

		Truck(int weight, int entry) {
			this.weight = weight;
			this.entry = entry;
		}
	}
}
