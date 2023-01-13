//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 910 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int count=1;//开始的值
        int loop=1;//循环次数，从第一次开始
        int start=0;//每次循环开始的坐标[start][start]
        int[][] res = new int[n][n];//new一个二维数组 res
        int i, j;
        //通过一个while循环，来控制螺旋的圈数；
        while(loop<=n/2){
            for (j=0;j<n-loop;j++){//左闭右开区间，
                res[start][j]=count++;
            }
            for (i=0;i<n-loop;i++){//左闭右开区间，
                res[i][j]=count++;
            }
            for (;j>=loop;j--) {//左闭右开区间，
                res[i][j] = count++;
            }
            for (;i>=loop;i--){//左闭右开区间，
                res[i][j]=count++;
            }
            loop++;//一圈后， loop加一；开始下一圈的遍历
            start++;// 下一圈的起始位置改变一下；[0][0]->[1][1]
        }
        //如果n=5，7 这类奇数时，需要加一个判断来给最中心的元素赋值
        if (n/2 !=0) {
            res[n/2][n/2]= n*n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
