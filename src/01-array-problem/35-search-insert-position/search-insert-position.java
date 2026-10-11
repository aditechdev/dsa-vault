class Solution {
    public int searchInsert(int[] nums, int target) {
        // Sorted array
        // return index if target is found
        // If it is not present return the index where it could be inserted
       if(nums == null || nums.length == 0){
        return 0;
       }
        int left = 0;
        int right = nums.length-1;

        while(left <= right){

            int mid = left + (right -left)/2;
            

            if(nums[mid] == target){
                return mid;
            }

            

            if(nums[mid] < target){
             left = mid+1;

            }else{
                right = mid -1;
            }
            


        }

        return left;
        
    }
}