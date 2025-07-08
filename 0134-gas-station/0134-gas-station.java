class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0;
        int res=0,start=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
            res+=gas[i]-cost[i];
            if(res<0){//if it goes negative
                start=i+1;
                res=0;
            }
        }
        return totalGas>=totalCost?start:-1;
    }
}