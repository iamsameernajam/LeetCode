class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] target = String.valueOf(N).toCharArray();
        Arrays.sort(target);
        for (int i = 0; i < 30; i++) {
            char[] candidate = String.valueOf(1 << i).toCharArray();
            Arrays.sort(candidate);
            if (Arrays.equals(target, candidate)) return true;
        }
        return false;
    }
}
