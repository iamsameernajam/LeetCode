import java.util.*;

class Solution {
    static class ClassInfo implements Comparable<ClassInfo> {
        int pass;
        int total;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        // Compute the "gain" of adding one student
        private double gain() {
            return (double) (pass + 1) / (total + 1) - (double) pass / total;
        }

        // Natural ordering = ascending by gain
        @Override
        public int compareTo(ClassInfo other) {
            return Double.compare(this.gain(), other.gain());
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap using reverseOrder()
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Load classes into the heap
        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            ClassInfo top = pq.poll();
            top.pass++;
            top.total++;
            pq.offer(top);
        }

        // Compute final average
        double sum = 0;
        while (!pq.isEmpty()) {
            ClassInfo c = pq.poll();
            sum += (double) c.pass / c.total;
        }

        return sum / classes.length;
    }
}
