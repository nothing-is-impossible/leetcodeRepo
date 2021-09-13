package com.study.offer;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回左上角 (row1,col1)、右下角(row2,col2)的子矩阵的元素总和。
 *
 */
public class Offer013 {

    private int[][] matrix;

    /**
     * 笨比解法
     * 输入:
     *      ["NumMatrix","sumRegion","sumRegion","sumRegion"]
     *      [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
     * 输出:
     *      [null, 8, 11, 12]
     *
     * 解释:
     *      NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
     *      numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
     *      numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
     *      numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
     * @param matrix 二维数组
     */
    public Offer013(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j<= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
class OptimizeClass {
    /**
     * 笨比解法
     * 输入:
     *      ["NumMatrix","sumRegion","sumRegion","sumRegion"]
     *      [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
     * 输出:
     *      [null, 8, 11, 12]
     *
     * 解释:
     *      NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
     *      numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
     *      numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
     *      numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
     * @param matrix 二维数组
     */
    private int[][] sum;
    public OptimizeClass(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0 ;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                sum[i][j] = i == 0 ? rowSum : sum[i-1][j] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1-1];
        }
        if (col1 == 0) {
            return sum[row2][col2] - sum[row1-1][col2];
        }
        return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
    }

    public static void main(String[] args) {
        OptimizeClass optimizeClass = new OptimizeClass(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
    }

}
