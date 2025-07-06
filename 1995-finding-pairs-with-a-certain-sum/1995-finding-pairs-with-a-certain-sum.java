class FindSumPairs {
    int[] n1,n2;
    HashMap<Integer,Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for(int num:nums2) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(n2[index],map.get(n2[index])-1);
        n2[index]+=val;
        map.put(n2[index],map.getOrDefault(n2[index],0)+1);
    }
    
    public int count(int tot) {
        int c = 0;
        for(int num:n1) {
            if(map.containsKey(tot-num)) {
                c+=map.get(tot-num);
            }
        }
        return c;
    }
}

