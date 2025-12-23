import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isMatch(String s, String p) {
        int i = s.length() - 1;
        int j = p.length() - 1;
        return backtrack(new HashMap<>(), s, p, i, j);
    }

    private boolean backtrack(Map<String, Boolean> cache, String s, String p, int i, int j) {
        String key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // both consumed
        if (i == -1 && j == -1) {
            cache.put(key, true);
            return true;
        }

        // pattern consumed but string not
        if (i != -1 && j == -1) {
            cache.put(key, false);
            return false;
        }

        // string consumed, pattern may contain x*
        if (i == -1 && p.charAt(j) == '*') {
            int k = j;
            while (k != -1 && p.charAt(k) == '*') {
                k -= 2;
            }
            boolean res = (k == -1);
            cache.put(key, res);
            return res;
        }

        // string consumed, pattern char is not *
        if (i == -1 && p.charAt(j) != '*') {
            cache.put(key, false);
            return false;
        }

        // handle *
        if (p.charAt(j) == '*') {
            // zero occurrence
            if (backtrack(cache, s, p, i, j - 2)) {
                cache.put(key, true);
                return true;
            }

            // one or more occurrences
            if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                if (backtrack(cache, s, p, i - 1, j)) {
                    cache.put(key, true);
                    return true;
                }
            }
        }

        // normal character or '.'
        if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
            if (backtrack(cache, s, p, i - 1, j - 1)) {
                cache.put(key, true);
                return true;
            }
        }

        cache.put(key, false);
        return false;
    }
}