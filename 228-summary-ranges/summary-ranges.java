class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int i=0;
        int n=nums.length;
        while(i<n){
            int start=nums[i];

            while(i+1< n && nums[i]+1==nums[i+1]){
                i++;
            }
            int end=nums[i];
            if(start==end){
                result.add(String.valueOf(start));
            }else{
                result.add(start+"->"+end);
            }
            i++;
        }
        return result;
    }
}