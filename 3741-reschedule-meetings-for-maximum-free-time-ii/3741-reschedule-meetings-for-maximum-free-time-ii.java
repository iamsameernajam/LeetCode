class Solution {

    class Pair {
        int gap;
        int index;

        Pair(int a, int b) {
            this.gap = a;
            this.index = b;
        }

        @Override
        public String toString() {
            return "(" + gap + ", " + index + ")";
        }
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int t = 0, n = startTime.length, ans = 0, sum = 0, gap=0;
        List<Integer> gaps = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.gap, a.gap));
        
        gap = startTime[0] - 0;
        gaps.add(gap);
        pq.add(new Pair(gap, 0));
        for(int i=1; i<n; i++) {
            gap = startTime[i] - endTime[i-1];
            gaps.add(gap);
            pq.add(new Pair(gap, i));
        }
        gap = eventTime - endTime[n-1];
        gaps.add(gap);
        pq.add(new Pair(gap, n));
        // System.out.println(gaps);

        Pair m1 = null, m2 = null, m3 = null;
        if(!pq.isEmpty()) {
            m1 = pq.poll();
        }

        if(!pq.isEmpty()) {
            m2 = pq.poll();
        }

        if(!pq.isEmpty()) {
            m3 = pq.poll();
        }

        // System.out.println(m1 + " " + m2 + " " + m3);
        for(int i=0; i<n; i++) {
            boolean isIt = false;
            gap = endTime[i] - startTime[i];
            // System.out.println(gap);

            if((m3.gap >= gap) || ((m2.gap >= gap) && (m2.index != i && m2.index != i+1)) || ((m1.gap >= gap) && (m1.index != (i) && m1.index != (i+1)))) {
                isIt = true;
            }

            if(isIt) {
                sum = gaps.get(i) + gaps.get(i+1) + endTime[i] - startTime[i];
            } else {
                sum = gaps.get(i) + gaps.get(i+1);
            }

            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}