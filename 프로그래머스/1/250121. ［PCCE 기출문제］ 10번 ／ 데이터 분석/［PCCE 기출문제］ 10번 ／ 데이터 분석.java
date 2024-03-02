import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext - 추출 기준
        // val_ext - 기준치(이보다 작은 데이터)
        List<String> exts = new ArrayList<>(Arrays.asList("code", "date", "maximum", "remain"));
        int n = exts.indexOf(ext);
        int m = exts.indexOf(sort_by);
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            // 기준값과 비교
            if(data[i][n] < val_ext) {
                list.add(data[i]);
            }
        }
        
        // 오름차순 정렬
        list.sort((arr1, arr2) -> Integer.compare(arr1[m], arr2[m]));
        
        return list.toArray(new int[0][]);
    }
}