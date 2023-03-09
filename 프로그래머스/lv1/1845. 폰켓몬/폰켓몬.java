import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i: nums) {
            if(!list.contains(i)) list.add(i);
        }
        int cnt = N/2;
        int types = list.size();
        if(types >= cnt) answer = cnt;
        else answer = types;
        
        return answer;
    }
}