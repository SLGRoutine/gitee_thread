package yc.pro1_matrix.single;

/**
 * 串行的，没有使用线程的矩阵惩罚器
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class SeriaMultiplier {
    public static void multiply(double[][] matrix1 ,double[][] matrix2,double[][] result){

        int row1 = matrix1.length;      //第一个矩阵的行
        int col1 = matrix1[0].length;   //第一个矩阵的列

        int row2 = matrix2.length;      //第二个矩阵的行
        int col2 = matrix2[0].length;   //第二个矩阵的列

        for (int i = 0;i<row1;i++){
            for (int j = 0;j<col2;j++){
                result[i][j] = 0;
                for (int k = 0;k<col1;k++){
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }

    }

}
