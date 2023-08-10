import java.util.*;
import java.math.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n]; // 비밀지도
        for(int i = 0; i < n; i++) {
            String tmp1 = Integer.toBinaryString(arr1[i]);
            String tmp2 = Integer.toBinaryString(arr2[i]);
            tmp1 = "0".repeat(n - tmp1.length()) + tmp1;
            tmp2 = "0".repeat(n - tmp2.length()) + tmp2;
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                String tmp = (tmp1.charAt(j) - '0') + (tmp2.charAt(j) - '0') > 0 ? "#" : " ";
                sb.append(tmp);
            }
            map[i] = sb.toString();
        }
        
        return map;
    }
}