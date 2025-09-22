class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max=0;
        for(int i:map.keySet()){
            max=Math.max(max,map.get(i));
        }
        int sum=0;
        for(int i:map.keySet()){
            if(map.get(i)==max){
                sum+=map.get(i);
            }
        }
        return sum;
    }
}