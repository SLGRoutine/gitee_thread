package yc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 方案四：线程执行返回结果
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test4_callable_FutureTask {
    public static void main(String[] args) {
//        方式一：内部类
        FutureTask<Integer> task1 = new FutureTask<>(new Callable<Integer>() {
//            功能        实现累加返回结果
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int  i = 0;i<=5;i++){
                    Thread.sleep(1000);
                    result++;
//                    if (i==5){
//                        throw  new RuntimeException("error");
//                    }
                }
                return result;
            }
        });
//        将任务与线程绑定
        Thread t1 = new Thread(task1);
        t1.start();

//        方式二：lameda写法
        FutureTask<Integer> task2 = new FutureTask<>(()->{
                int result = 0;
                for (int  i = 0;i<=5;i++){
                    Thread.sleep(1000);
                    result++;
//                    if (i==5){
//                        throw  new RuntimeException("error");
//                    }
                }
                return result;
        });
//        将任务与线程绑定
        Thread t2 = new Thread(task2);
        t2.start();

        //有返回值
        try {
            System.out.println("累加和为"+task1.get());
            System.out.println("累加和为"+task2.get());
            System.out.println("请理解说明是阻塞。。。");//只有拿到返回结果，才会继续执行线程
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
