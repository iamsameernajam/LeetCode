class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> lakeMap = new HashMap<>();
        ArrayList<Integer> zeroes = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int lake = rains[i];
            
            if(lake == 0) {
                zeroes.add(i);
                ans[i] = 1;
                continue;
            }

            if(lakeMap.containsKey(lake)) {
                int lastFillDay = lakeMap.get(lake);
                // System.out.println("Lake: " + lake + " at index: " + i + " Lastfill: " + lastFill);
                int zeroDay = binarySearch(zeroes, lastFillDay);

                if(zeroDay == -1)
                    return (new int[0]);

                ans[zeroDay] = lake;
                zeroes.remove(Integer.valueOf(zeroDay));
            }

            ans[i]=-1;
            lakeMap.put(lake,i);
        }

        return ans; 
    }

    private int binarySearch(ArrayList<Integer> list, int k) {
        int n = list.size();
        if(n==0 || list.get(n-1)<k)
            return -1;

        int l = 0, r = n-1;

        while(l<r) {
            int mid = l+ (r-l)/2;
            int midDay = list.get(mid);
            // System.out.println(midDay + " " + k);

            if(midDay < k) {
                l = mid+1;
            }
            else if(k < midDay) {
                r = mid;
            }
        
        }

        return list.get(r);
    }
}