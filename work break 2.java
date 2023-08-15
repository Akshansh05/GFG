class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>  ans = new ArrayList<>();
            helper(s,s.length(),"",ans,wordDict);
        return ans;
    }

     void helper(String s , int n ,String result , List<String> ans,List<String> wordDict){
        
        for(int i =1; i<=n;i++){

            String prefix = s.substring(0,i);

            if(wordDict.contains(prefix)){
                   if(i==n){ 
                    result += prefix;
                    ans.add(result);
                    return;
                }
           
             helper(s.substring(i ,n),n-i,result+prefix+ " ",ans ,wordDict) ;
             }
        }
    }
}
