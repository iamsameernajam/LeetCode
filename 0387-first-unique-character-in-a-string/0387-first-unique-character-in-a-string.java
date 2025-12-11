class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = 1; 
            if (freq.containsKey(c)) {
                count = freq.get(c) + 1; 
            }
            freq.put(c, count); 
        }
        
      
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i; 
            }
        }
        
        return -1; 
    }
}
