import java.util.*;

class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length(); i++) {
            sb.append(a[i]);
            sb.append(b[i]);
        }
        answer = sb.toString();
        return answer;
    }
}