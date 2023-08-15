class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        Arrays.fill(dp,false);

        dp[0] = true;
       
       for(int i =0; i<=s.length();i++){
           for(int j=0; j<i;j++){

               if(dp[j] && wordDict.contains(s.substring(j,i))){
                   dp[i]= true;
                   break;
               }
           }
       }
      return dp[s.length()];
    }
}
