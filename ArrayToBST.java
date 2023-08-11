//GFG Practice

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        ArrayList<Integer> temp = new ArrayList<>();
        helper(nums, temp, 0, nums.length-1);
        int ans[] = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
    
    public void helper(int[] nums, ArrayList<Integer> temp, int start, int end){
        if(start>end){
            return;
        }
        
        int mid = (start+end)/2;
        temp.add(nums[mid]);
        helper(nums, temp, start, mid-1);
        helper(nums, temp, mid+1, end);
    }
}
