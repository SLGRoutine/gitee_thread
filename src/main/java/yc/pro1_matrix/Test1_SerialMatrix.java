package yc.pro1_matrix;

import yc.pro1_matrix.single.SeriaMultiplier;

import java.security.SecureRandom;

/**
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class Test1_SerialMatrix {
    public static void main(String[] args) {
//        生成两个举证
        double matrix1[][] = MatrixGenerator.generate(2000,2000);
        double matrix2[][] = MatrixGenerator.generate(2000,2000);
//        结果矩阵
        double result[][] = new double[matrix1.length][matrix2[0].length];

        long start,end;

        start = System.currentTimeMillis();

        SeriaMultiplier.multiply(matrix1,matrix2,result);

        end =System.currentTimeMillis();

        System.out.println("串行计算矩阵需要的时间："+(end-start));
    }
}
