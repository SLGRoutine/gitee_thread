package yc.thread_lifeCycle;

/**
 * 区分yield join sleep
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test12_yield_sleep {
    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();


        Thread t1 = new Thread(task1,"a");
        Thread t2 = new Thread(task2,"b");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

    }
}
class MyTask implements Runnable{
    @Override
    public void run() {
        if ("a".equals(Thread.currentThread().getName())){
            /**
             * 从概率上来说，因为b的优先级高于a,a让权给b后，b大概率会优先于a结束
             */
            Thread.yield();    //yield只会将执行权放给优先级高的线程
            /**
             * 区分：yield和sleep
             * yield()没有异常          sleep()方法存在异常
             * yield()方法实际上是让线程从运行状态-->进入-->就绪状态  ，也就是说yield()执行完后，线程有可能立刻又被系统调度执行进入运行中状态
             * 而sleep()方法是强制让线程一段时间内无法执行，
             */

               /* try {
                    Thread.sleep(1000);         //sleep不管优先级，只要调sleep，则当前进程睡，其他进程接过执行权
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
        }
        for (int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
