package yc.pro1_matrix.row;

import yc.pro1_matrix.individual.IndividualMultiplierTask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class ParalleRowMultiplier {
    public static void multiply(double[][] matrix1 ,double[][] matrix2,double[][] result){

        List<Thread > threads = new ArrayList<>();

        int row1 = matrix1.length;      //第一个矩阵的行
        int col1 = matrix1[0].length;   //第一个矩阵的列

        int row2 = matrix2.length;      //第二个矩阵的行
        int col2 = matrix2[0].length;   //第二个矩阵的列

        for (int i = 0;i<row1;i++){
                //创建线程
                Thread t = new Thread( new RowMultiplierTask(result,matrix1,matrix2,i)   );
                t.start();
                threads.add(t);

                if (threads.size()%10==0){
                    waitForThreads(threads);//调用方法一次只处理10个线程
                }
        }

    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread t:threads){
            try {
                t.join(); //每十个线程启动一次，其他的线程等待
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
