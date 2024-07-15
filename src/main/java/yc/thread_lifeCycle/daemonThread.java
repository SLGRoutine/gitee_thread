package yc.thread_lifeCycle;

import java.util.Date;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class daemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                Date d = new Date();
                System.out.println("当前时间为"+d);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        thread.setDaemon(true);  //垃圾回收，资源释放，
        // 主线程结束后，守护线程也会自动结束
        thread.start();

        System.out.println("主线程已经结束了");
    }
}
