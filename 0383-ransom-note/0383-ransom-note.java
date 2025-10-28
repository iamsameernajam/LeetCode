class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int arr[] = new int[26];

        
        for (int i = 0; i<ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            arr[r - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char r = magazine.charAt(i);
            arr[r - 'a']--;
        }

        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
