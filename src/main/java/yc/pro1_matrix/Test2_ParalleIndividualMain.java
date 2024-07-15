package yc.pro1_matrix;

import yc.pro1_matrix.individual.ParalleIndividuaMultiplier;
import yc.pro1_matrix.single.SeriaMultiplier;

/**
 * 结果矩阵中 每个元素一个元素的版本：细粒度版本
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class Test2_ParalleIndividualMain {
    public static void main(String[] args) {
//        生成两个举证
        double matrix1[][] = MatrixGenerator.generate(2000,2000);
        double matrix2[][] = MatrixGenerator.generate(2000,2000);
//        结果矩阵
        double result[][] = new double[matrix1.length][matrix2[0].length];

        long start,end;

        start = System.currentTimeMillis();

//        SeriaMultiplier.multiply(matrix1,matrix2,result);//单线程计算   消耗39120秒
        ParalleIndividuaMultiplier.multiply(matrix1,matrix2,result);//结果矩阵中 每个元素一个元素的版本：细粒度版本

        end =System.currentTimeMillis();

        System.out.println("串行计算矩阵需要的时间："+(end-start));
    }
}
