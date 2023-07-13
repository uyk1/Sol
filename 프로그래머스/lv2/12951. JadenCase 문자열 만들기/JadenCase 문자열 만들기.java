import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || arr[i-1] == ' '){
                if(Character.isLowerCase(arr[i])) answer += Character.toUpperCase(arr[i]);
                else answer += arr[i];
            }
            else if(Character.isUpperCase(arr[i])) answer += Character.toLowerCase(arr[i]);
            else answer += arr[i];
        }
        return answer;
    }
}