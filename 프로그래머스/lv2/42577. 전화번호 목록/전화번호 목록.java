import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String str: phone_book) set.add(str.replace(" ", ""));
        for(String str: set) {
            for(int i = 0; i < str.length(); i++) {
                //해시셋이 현재 스트링의 서브스트링을 가지고 있다면 false
                if(set.contains(str.substring(0, i))) return false;
            }
            // for(String str2: set) {
            //     if(str != str2 && str.length() <= str2.length()) {
            //         if(str.equals(str2.substring(0, str.length()))){
            //             return false;
            //         }
            //     }
            // }
        }
        return true;
    }
}