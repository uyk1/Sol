import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int i: arr) {
            int tmp = i % divisor;
            if(tmp != 0 || list.contains(i)) continue;
            list.add(i);
        }
        if(list.size() == 0) return new int[] {-1};
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}