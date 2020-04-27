import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		solution(k, room_number);

	}

	public static long[] solution(long k, long[] room_number) {
		int roomNumberCount = room_number.length;
		long[] answer = new long[roomNumberCount];

		Map<Long, Long> hotelRoom = new HashMap<Long, Long>();

		for (int i = 0; i < roomNumberCount; i++) {
			long wantRoomNumber = room_number[i];
			if (!hotelRoom.containsKey(wantRoomNumber)) {
				answer[i] = wantRoomNumber;
				hotelRoom.put(wantRoomNumber, wantRoomNumber + 1);
			} else {
				ArrayList<Long> list = new ArrayList();
				while (hotelRoom.containsKey(wantRoomNumber)) {
					list.add(wantRoomNumber);
					wantRoomNumber = hotelRoom.get(wantRoomNumber);
				}
				answer[i] = wantRoomNumber;
				list.add(wantRoomNumber);
				for (long l : list) {
					hotelRoom.put(l, wantRoomNumber + 1);
				}
			}

		}

		return answer;
	}
}
