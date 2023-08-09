class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int i =0;
        int j=0;
        int sum =0;
        int count=0;

        while(j <arr.length){
            sum += arr[j];//get sum of all till k
            if(j-i+1 < k){
                j++;  //till k increment j
            }else if(j-i+1 == k){ //if window size is equl to k perform stuff 
                int avg = sum/k;
                if(avg >=threshold)
                    count++;
                 sum = sum - arr[i]; // remove a[i] 
                 //add arr[j] and remove arr[i] but arr[j] is added  at line 11 at next step  so not required.           
                 i++;  //slide the window 
                 j++;    //slide the window 
            }
        }
        return count;
        
    }
}
