class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if(high % 2 != 0){
            count++;
            high--;
        }

        if(low%2!=0){
            count++;
            low++;
        }
        count+=(high - low) / 2;
        return count;
    }
}