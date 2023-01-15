//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 427 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int total = 2;
        if (n <= 2)
            return n;
        int count=0;//计算蓝中的水果种类
        int result1=-1;
        int result=-1;
        // 计算篮中每种水果出现的次数。 因为提示中说明了水果的种类数是有限的 0 <= fruits[i] < fruits.length
        int[] fruitFrequence  = new int[n];
        for(int fast=0,slow=0;fast<n;fast++){
            fruitFrequence[fruits[fast]] = fruitFrequence[fruits[fast]] + 1; // 入篮
            if( fruitFrequence[fruits[fast]]==1){//等于1说明第一次入篮，count需要加1
                count+=1;
            }
            while (count>2){
                fruitFrequence[fruits[slow]] -= 1;// 因为下边还要使用slow下标，所以先不要移动
                if (fruitFrequence[fruits[slow]] == 0) {
                    count -= 1;
                    slow++;
                }
                // 等于0说明篮中已经没有fruits[left]水果，count减1
            }
            total= Math.max(total,fast-slow+1);
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
