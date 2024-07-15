package yc.pro1_matrix.individual;

/**
 * 计算result矩阵下表为[i][j]的值
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class IndividualMultiplierTask implements Runnable {
    private final double [][] result;       //final 确保线程数据的安全性
    private final double [][] matrix1;
    private final double [][] matrix2;
    private final int row;
    private final int col;
    /**
     *
     * @param result        结果矩阵
     * @param matrix1       矩阵A
     * @param matrix2       矩阵B
     * @param i             结果矩阵第i行
     * @param j             结果矩阵第j列
     */
    public IndividualMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int i, int j) {
        this.result =result;
        this.matrix1 =matrix1;
        this.matrix2 =matrix2;
        this.row = i;
        this.col = j;
    }

    @Override
    public void run() {
        result[row][col] = 0;
                for (int k = 0;k<matrix1[row].length;k++){
                    result[row][col] += matrix1[row][k]*matrix2[k][col];
                }
    }
}
