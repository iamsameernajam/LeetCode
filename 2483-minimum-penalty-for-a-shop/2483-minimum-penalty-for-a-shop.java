class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int prefixn[] = new int[n + 1];
        int suffixy[] = new int[n + 1]; // changed size to handle closing at n
        int min = Integer.MAX_VALUE;

        prefixn[0] = 0;
        suffixy[n] = 0; // no customers after last hour

        // build prefix count of 'N'
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                prefixn[i + 1] = prefixn[i] + 1;
            } else {
                prefixn[i + 1] = prefixn[i];
            }
        }

        // build suffix count of 'Y'
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                suffixy[i] = suffixy[i + 1] + 1;
            } else {
                suffixy[i] = suffixy[i + 1];
            }
        }

        int mini = 0;

        // check all closing times including n
        for (int i = 0; i <= n; i++) {
            int penalty = prefixn[i] + suffixy[i];
            if (penalty < min) {
                min = penalty;
                mini = i;
            }
        }

        return mini;
    }
}