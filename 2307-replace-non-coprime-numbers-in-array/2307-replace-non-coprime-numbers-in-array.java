class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            int curr = num;
            while (!stack.isEmpty()) {
                int last = stack.get(stack.size() - 1);
                int gcd = findGcd(last, curr);
                if (gcd == 1) break;
                curr = lcm(last, curr, gcd);
                stack.remove(stack.size() - 1);
            }
            stack.add(curr);
        }
        return stack;
    }

    int findGcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    int lcm(int a, int b, int g) {
        return (int)((long)a * b / g);
    }
}