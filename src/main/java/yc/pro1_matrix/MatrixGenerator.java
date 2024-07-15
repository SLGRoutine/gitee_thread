package yc.pro1_matrix;

import java.util.Random;

/**
 * 矩阵元素生成器
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class MatrixGenerator {
    public static double[][] generate(int rows,int cols){
        double [][] ret = new double[rows][cols];
        Random r = new Random();

        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                ret[i][j] =  r.nextDouble() *10;
            }
        }

        return ret;
    }

}
