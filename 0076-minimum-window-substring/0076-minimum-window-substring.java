import java.util.HashMap;

public class Solution {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                if (map.get(rChar) > 0) {
                    requiredChars--;
                }
                map.put(rChar, map.get(rChar) - 1);
            }
            right++;

            while (requiredChars == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = s.charAt(left);
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0) {
                        requiredChars++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}