import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int i = 0, n = intervals.length;
        while(i < n && intervals[i][1] < newInterval[0]) {
            answer.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        answer.add(newInterval);
        while(i < n) {
            answer.add(intervals[i]);
            i++;
        }
        return answer.toArray(new int[answer.size()][]);
    }
}