class Solution {
    public boolean isSubsequence(String s, String t) {
        int tp=0;
        int sp=0;
        while(sp<s.length()&&tp<t.length()){
            if(s.charAt(sp)==t.charAt(tp)){
                sp++;
            }
            tp++;
        }
        return sp==s.length();
    }
}