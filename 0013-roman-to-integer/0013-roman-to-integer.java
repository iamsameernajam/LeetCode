class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum=0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            int a=map.get(ch);
            sum+=a;
            if(i>0 && a>map.get(s.charAt(i-1))){
                sum-=map.get(s.charAt(i-1));
                i--;
            }
        }
        return sum;
    }
}