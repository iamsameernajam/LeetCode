class Solution {
    public int maxDepth(String s) {
        int count=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }        
            else if(s.charAt(i)==')'){
                ans=Math.max(ans,count);
                count--;
            }
        }
        //ans=Math.max(ans,count); (string ends without a closing parenthesis (i.e., unbalanced parentheses), the max depth is still captured.)
        return ans;
    }
}