//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)]
//寻找target在数组里的左右边界，有如下三种情况：nums = [5,7,7,8,8,10]
//        情况一：target 在数组范围的右边或者左边;              target=11
//        情况二：target 在数组范围中，且数组中不存在target;     target=9
//        情况三：target 在数组范围中，且数组中存在target;       target=8
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //情况1：
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        //情况2；
        else if (searchLeftBorder(nums, target)==0 && searchRightBorder(nums, target) == 0) {
            return new int[]{-1, -1};
        }
        else {
            return new int[]{searchLeftBorder(nums, target), searchRightBorder(nums, target)};
        }
    }

    //找右边界
    public int searchRightBorder(int[] nums, int target) {
        int l1 = 0;
        int r1 = nums.length - 1;
        int index=0;
        while (l1 <= r1) {
            int mid = l1 + ((r1 - l1) / 2);
            if (target < nums[mid]) {
                r1 = mid - 1;
            }
            //因为要找的是右边界，所以我们只需要当target >= nums[mid]的时候
            //就记录下 mid 的位置； 接着向右二分查找；
            //直到查不到了就说明上次mid的位置就是右边界；
            else  {
                index = mid;
                l1 = mid + 1;
            }
        }
        return index;
    }

    public int searchLeftBorder(int[] nums, int target) {
        int l1 = 0;
        int r1 = nums.length - 1;
        int index=0;
        while (l1 <= r1) {
            int mid = l1 + ((r1 - l1) / 2);
            if (nums[mid] < target) {
                l1 = mid + 1;
            }//左边界跟右边边界同理；
            else{
                index = mid;
                r1 = mid - 1;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
