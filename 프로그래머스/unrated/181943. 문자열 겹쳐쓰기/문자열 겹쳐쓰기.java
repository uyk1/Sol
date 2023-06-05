import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int start = s;
        int end = s + overwrite_string.length();
        String a = my_string.substring(0, start);
        String b = my_string.substring(end, my_string.length());
        
        return a + overwrite_string + b;
    }
}