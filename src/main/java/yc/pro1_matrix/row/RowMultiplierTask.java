package yc.pro1_matrix.row;

/**
 * 基于结果矩阵行的任务类：结果矩阵一行一个任务
 * 总共2000个线程
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class RowMultiplierTask implements Runnable{
    private final double [][] result;       //final 确保线程数据的安全性
    private final double [][] matrix1;
    private final double [][] matrix2;
    private final int row;
    /**
     *
     * @param result        结果矩阵
     * @param matrix1       矩阵A
     * @param matrix2       矩阵B
     * @param  row          结果矩阵的第几行
     */
    public RowMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int row) {
        this.result =result;
        this.matrix1 =matrix1;
        this.matrix2 =matrix2;
        this.row = row;
    }

    @Override
    public void run() {
        for (int j = 0;j<matrix2[0].length;j++){
            result[row][j] = 0;
            for (int k = 0;k<matrix1[row].length;k++){
                result[row][j] += matrix1[row][k]*matrix2[k][j];
            }
        }
    }
}
