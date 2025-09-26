class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
           char cs = s.charAt(i);
           char ct = t.charAt(i);
           if(mapS.containsKey(cs) && mapS.get(cs) != ct) return false;
           if(mapT.containsKey(ct) && mapT.get(ct) != cs) return false;
           mapS.put(cs, ct);
           mapT.put(ct, cs);
        }
        return true;
    }
}