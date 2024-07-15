package yc.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方案5：线程池
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test5_pool {

    public static void main(String[] args) {
        /*核心线程池带的大小*/
        int corePoolSize = 3;
        /*线程池的最大线程数量，这个参数决定了线程池创建的线程个数*/
        int maxPoolSize =5;
        /*线程最大空闲时间*/
        long keepAliveTime = 10;
        /*时间单位*/
        TimeUnit unit = TimeUnit.SECONDS; //enum枚举  常量
        /*阻塞队列  容量为2  最多允许放入两个空闲线程  */
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2); //五个正在执行的任务 ，三个等待执行的任务
        /*创建线程工厂*/
        ThreadFactory threadFactory = new NameThreadFactory();
        /*线程拒绝策略*/
        RejectedExecutionHandler handler = new MyIgnorePolicy();

        ThreadPoolExecutor executor = null;

        try{
            /*推荐创建线程池的方法*/
            /*不推荐使用现成APi生成*/
            executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,workQueue,threadFactory,handler);
            /*预期动所有线程  提升效率*/
            executor.prestartAllCoreThreads();
            /*任务数*/
            int count = 10;
            for (int i = 1;i<=count;i++){
                Task task = new Task(String.valueOf(i));
                executor.submit(task);//向线程池中提交10个任务
            }
        }finally {
            assert executor!=null;//断言 可开  -ea -da
            executor.shutdown();//关闭线程池
        }

        System.out.println("因为线程池最大线程数量为5，所以只会创建5个线程对象");
    }

    /**
     * 线程工厂
     */
    static  class NameThreadFactory implements ThreadFactory{
//        线程ID   AtomicInteger原子类   原子整形类
        private final AtomicInteger threadId = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,"线程-"+threadId.getAndIncrement());//i++ => 1+1 赋值
            System.out.println(t.getName()+"已被创建");
            return  t;
        }
    }

    /**
     * 线程拒绝策略
     */
    public  static class MyIgnorePolicy implements  RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r,executor);
        }

        private  void doLog(Runnable runnable,ThreadPoolExecutor e){
            System.err.println("线程池："+e.toString()+runnable.toString()+"被拒绝");
        }
    }


    /**
     * 任务类
     */
    static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println( this.name + "-isRunning!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
