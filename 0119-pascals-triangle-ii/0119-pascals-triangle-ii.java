import java.util.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // first element is always 1

        for (int i = 1; i <= rowIndex; i++) {
            // compute next value using previous value
            long val = (long) row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add((int) val);
        }

        return row;
    }
}
