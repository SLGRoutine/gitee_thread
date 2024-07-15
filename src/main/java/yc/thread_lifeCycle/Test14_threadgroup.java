package yc.thread_lifeCycle;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test14_threadgroup {

    public static void main(String[] args) {
        TestThread task1 =new TestThread();
        TestThread task2 =new TestThread();

        ThreadGroup threadGroup = new ThreadGroup("新建线程组1");

        Thread t0 = new Thread(threadGroup,task1);
        Thread t1 = new Thread(threadGroup,task2);

        t0.start();
        t1.start();
//        通过线程组来管理线程
        System.out.println("活动的线程数为"+threadGroup.activeCount());
        System.out.println("线程组的名字为"+threadGroup.getName());
        //线程组中断，则这个组的所有线程都会被中断
        threadGroup.interrupt();//发出中断辛信号
    }
}

class TestThread implements  Runnable{
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("线程名："+Thread.currentThread().getName());
                Thread.sleep(3000);//因为sleep也是线程的一个生命周期，所以只要线程被中断，sleep函数就会抛出异常
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
