class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            int j = i+1;
            while( j <words.length) {
                if(!isAnagram(words[i], words[j])) {
                    break;
                }
                j++;
            }

            ans.add(words[i]);
            // Ideally we will start next iteration from jth index, but as we have an outer for loop which will increase i, we are keeping i as j-1
            i = j-1; // i+1-1 = i
        }

        return ans;

    }

    boolean isAnagram(String a, String b) {
        char arr1[] = a.toCharArray();
        char arr2[] = b.toCharArray();
        // Given Strings: abba, abab
        //char arrays : [a, b, b, a] [a, b, a, b]
        // Sorted arrays: [a,a,b,b] [a,a,b,b]
        // String Conversion:  aabb, aabb

        Arrays.sort(arr1); Arrays.sort(arr2);
        if(String.valueOf(arr1).equals(String.valueOf(arr2))) {
            return true;
        }
        return false;
    }

}

