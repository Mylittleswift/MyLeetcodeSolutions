/*
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
*/

import java.util.HashMap;

public class Soltuion {
    private HashMap<Integer, Integer> map = new HashMap<>();
 
    public void add(int number) {
        if (map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	    }
    }
 
    public boolean find(int value) {
	    for (int i : map.keySet()) {
	        int target = value - i;
	        if (map.containsKey(target)) {
	            if (i == target && map.get(target) < 2) {
	                continue;
	            }
	        return true;
	        }
	    }
	    return false;
    }
}

