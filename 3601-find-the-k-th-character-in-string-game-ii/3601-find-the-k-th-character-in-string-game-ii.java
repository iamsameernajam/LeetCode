class Solution {
    //to cal next char for given char
    char next(char c){
        int next = (c-'a'+1)%26;
        return (char) (next+'a');
    }

    //cal max possible x such that 2^x < num
    int getLowerPower2(long num){
        long p = 1;
        int x = 0;
        while(p*2 < num){
            p *= 2;;
            x++;
        }
        return x;
    }
    char solve(long k,int[] op){
        //base case k == 1 means first char 'a'
        if(k == 1)     return 'a';

        //get the lower power of 2 such that 2^l < k
        int l = getLowerPower2(k);

        long p = ((long) 1<<l);
        //if the operation at index l is 0 next the char is taken same from last string
        if(op[l]==0)
            return solve(k-p,op);
        //else next char is taken from prev string
        return next(solve(k-p,op));
    }
    public char kthCharacter(long k, int[] operations) {
        return solve(k,operations);
    }
}