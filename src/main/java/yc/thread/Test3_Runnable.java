package yc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @descripption 可运行的任务
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test3_Runnable {
    public static void main(String[] args) {

//        外部类
        Runnable run1 = new ShowTimeThread();
        Thread t1 = new Thread(run1);//    创建一个任务，绑定任务
        t1.start();
//        内部类
        Runnable run2 = new ShowTimeThreadInner();
        Thread t2 = new Thread(run2);
        t2.start();
//        匿名内部类
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                Date d = null;
                while (true){
                    d = new Date();
                    System.out.println(Thread.currentThread().getName()+"输出当前时间："+sdf.format(d));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t3.start();
//        Lambda表达式         ->Runnable接口支持Lambda表达式
        Thread t4 = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            Date d = null;
            while (true){
                d = new Date();
                System.out.println(Thread.currentThread().getName()+"输出当前时间："+sdf.format(d));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t4.start();

    }


    /**
     * 内部类
     */
    static class ShowTimeThreadInner implements  Runnable{
        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            Date d = null;
            while (true){
                d = new Date();
                System.out.println(Thread.currentThread().getName()+"输出当前时间："+sdf.format(d));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

/**
 * 从任务角度看  这是一个任务类，要绑定到线程，由线程启用
 * 外部类
 * 打印当前时间
 */
class ShowTimeThread implements  Runnable{
    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date d = null;
        while (true){
            d = new Date();
            System.out.println(Thread.currentThread().getName()+"输出当前时间："+sdf.format(d));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
