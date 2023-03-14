import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // String answer = "";
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) nums[i] = Integer.toString(numbers[i]);
        //앞 뒤의 숫자를 순서를 바꾸어 더해 비교
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        //정렬된 배열의 첫 원소가 0이면 답은 0
        if(nums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s: nums) sb.append(s);
        return sb.toString();
    }
}