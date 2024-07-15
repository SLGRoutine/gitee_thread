package yc.thread_lifeCycle;

/**
 * 线程的优先级
 *理论上来说，优先级越高，调度的机会越多，实际上不是，不保证
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class thread_priority {
    public static void main(String[] args) {
        // 创建三个线程，分别设置不同的优先级
        Thread thread1 = new Thread(new WorkerThread(), "Thread 1");
        Thread thread2 = new Thread(new WorkerThread(), "Thread 2");
        Thread thread3 = new Thread(new WorkerThread(), "Thread 3");

        thread1.setPriority(Thread.MIN_PRIORITY); // 设置为最低优先级
        thread2.setPriority(Thread.NORM_PRIORITY); // 设置为普通优先级
        thread3.setPriority(Thread.MAX_PRIORITY); // 设置为最高优先级

        // 启动这三个线程
        thread1.start();
        thread2.start();
        thread3.start();
    }

    // 定义一个简单的工作线程，模拟不同优先级下的任务执行
    static class WorkerThread implements Runnable {
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running - iteration ");

            }
        }
    }

}
