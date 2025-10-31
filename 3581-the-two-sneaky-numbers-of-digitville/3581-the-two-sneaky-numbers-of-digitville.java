import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            if (!seen.add(num)) {
                result.add(num);
            }
        }
        
        Collections.sort(result);
        return new int[]{result.get(0), result.get(1)};
    }
}
