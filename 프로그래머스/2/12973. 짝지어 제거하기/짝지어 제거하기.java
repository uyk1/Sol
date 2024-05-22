import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        // Stack 활용
        for(int i = 0; i < s.length(); i++) {
            if(st.isEmpty()) {
                st.push(arr[i]);
                continue;
            }
            // 비어있지 않으면 검사
            if(st.peek() == arr[i]) {
                st.pop();
            } else {
                st.push(arr[i]);
            }
        }
        
        return st.isEmpty() ? 1 : 0;
    }
}