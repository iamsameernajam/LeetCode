class Solution {
    static class Node {
        int wordIndex, charPos;
        Node(int w, int c) { wordIndex = w; charPos = c; }
    }

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        List<Node>[] buckets = new List[26];
        for (int i = 0; i < 26; ++i)
            buckets[i] = new ArrayList<>();

        for (int i = 0; i < words.length; ++i)
            buckets[words[i].charAt(0) - 'a'].add(new Node(i, 0));

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            List<Node> curr = buckets[idx];
            buckets[idx] = new ArrayList<>();

            for (Node node : curr) {
                node.charPos++;
                if (node.charPos == words[node.wordIndex].length()) {
                    ans++;
                } else {
                    char next = words[node.wordIndex].charAt(node.charPos);
                    buckets[next - 'a'].add(node);
                }
            }
        }
        return ans;
    }
}
