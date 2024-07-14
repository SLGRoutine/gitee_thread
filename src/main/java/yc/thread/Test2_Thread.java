package yc.thread;

/**
 * 方案一：继承Thread
 *
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test2_Thread extends Thread {
    public static void main(String[] args) {
        System.out.println("这是内部类运行");
        new InnerThread().start();

        System.out.println("这是外部类类运行");
        new MyThread().start();

        System.out.println("这是匿名内部类运行");
    }

    //    内部类
    static class InnerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

//外部类
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
