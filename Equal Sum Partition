class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum =0;
       for(int i =0; i<nums.length;i++){
            sum+=nums[i];
       }


       if(sum % 2 != 0){
           return false;
       }else{
             int dp[][] =new int [nums.length+1][sum/2 +1];

             for(int r[]:dp)
                Arrays.fill(r,-1);
          return subsetSum(nums,nums.length-1,sum/2,dp);
       }
    }

    boolean subsetSum(int[] nums , int index , int sum, int dp[][]){
        if(index == 0){
            if(sum == nums[0]){
                return true;
            }
            return false;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum] == 0 ? true:false;
        }
        boolean take =false;
        if(nums[index] <= sum){
             take = subsetSum(nums,index-1 , sum-nums[index] ,dp);
        }
          boolean notTake = subsetSum(nums,index-1 , sum ,dp);

            boolean  val = take || notTake;

            dp[index][sum] =  val == true ? 0:1;

          return val;
    
    }


  
}
