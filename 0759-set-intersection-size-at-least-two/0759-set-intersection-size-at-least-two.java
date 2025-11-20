class Solution {
        public int intersectionSizeTwo(int[][] inter) {
        int n = inter.length;
        Arrays.sort(inter,(a,b)->a[1]-b[1]); // sort by intervals that end first
        List<Integer> res = new ArrayList<>();
        res.add(inter[0][1] - 1);
        res.add(inter[0][1]);
        for (int i=1;i<n;i++) {
            int start=inter[i][0],end=inter[i][1],size=res.size(),last=res.get(size-1),secondLast=res.get(size-2);
            if (start > last) { // iterval does not intersect, be greedy and add points at the end of the interval
                res.add(end - 1);
                res.add(end);
            } else if (start == last) res.add(end); // Interval intersects in one point, we only need to add te second
            else if (start > secondLast) res.add(end); // interval intersects in both points, no need to add
        }
        return res.size();
    }
}