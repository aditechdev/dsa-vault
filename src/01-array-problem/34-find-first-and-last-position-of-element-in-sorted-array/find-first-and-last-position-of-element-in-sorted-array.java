class Solution {
    public int[] searchRange(int[] nums, int target) {
        // To get the lower indices
        int first = lowerBond(nums, target);
        
        // validate the lower indices
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }
        
        // last will always be upperBond -1
        int last = upperBond(nums, target)-1;
        return new int[]{first,last};
        
    }

    public int lowerBond(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int answer = nums.length;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] >= target){
                answer = mid;
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
    public int upperBond(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int answer = nums.length;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] > target){
                answer = mid;
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
}