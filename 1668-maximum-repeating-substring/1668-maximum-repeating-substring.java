class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder repeated = new StringBuilder(word);
        while (sequence.contains(repeated.toString())) {
            count++;
            repeated.append(word);
        }

        return count;
    }
}
