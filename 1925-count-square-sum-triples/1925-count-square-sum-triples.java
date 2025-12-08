class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int i = n; i > 0; i--) {
            int left = 1;
            int right = n - 1;

            while (right > left) {
                if (right * right + left * left > i * i) {
                    right--;
                } else {
                    left++;
                }

                if (i * i == right * right + left * left) {
                    count += 2;
                }
            }
        }

        return count;
    }
}