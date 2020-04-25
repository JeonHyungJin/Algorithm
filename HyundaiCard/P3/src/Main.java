//P3
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] re = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
		String new_id = "cow";
		
		System.out.println(solution(re,new_id));
		
	}

	public static String solution(String[] registered_list, String new_id) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i < registered_list.length; i++) {
        	map.put(registered_list[i], 1);
        }
        
        while(true) {
        	if(!map.containsKey(new_id)) {
        		break;
        	}
        	int num_index = -1;
        	
        	for(int i = 0; i < new_id.length(); i++) {
        		char a = new_id.charAt(i);
        		if(Character.isDigit(a)) {
        			num_index = i;
        			break;
        		}
        	}
        	
        	String S = "", N="";
			int N1;
        	if(num_index != -1) {
        		S = new_id.substring(0,num_index);
        		N = new_id.substring(num_index);
        		N1 = Integer.parseInt(N) + 1;
        	} else {
        		S = new_id;
        		N1 = 1;
        	}
        	
        	new_id = S + N1+"";
        }
        
        return new_id;
    }
	
	/*
	 * 
	 * def solution(registered_list, new_id):
    d = dict()
    for id in registered_list:
        d[id] = 1

    while True:
        if not d.get(new_id):
            break

        num_index = -1
        for i in range(len(new_id)):
            if new_id[i].isdigit():
                num_index = i
                break

        if num_index != -1:
            S = new_id[:num_index]
            N = new_id[num_index:]
            N1 = int(N) + 1
        else:
            S = new_id
            N1 = 1

        new_id = S + str(N1)

    return new_id
	 * */
}
