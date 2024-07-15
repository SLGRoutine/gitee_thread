package yc.thread;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test6_interrupt {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() +"线程数是否被中断："+Thread.interrupted());//false

//        设置主线程       中断信号
        Thread.currentThread().interrupt();

//        Thread.currentThread().stop();//已被弃用，太黄太暴力了(会导致线程被强制停止)，会导致数据的丢失


//        System.out.println(Thread.currentThread().getName() +"线程数是否被中断："+Thread.interrupted()); //true
//        System.out.println(Thread.currentThread().getName() +"线程数是否被中断："+Thread.interrupted());//false

        /**
         * 区别两者的区别：相同点:都是检测线程是否中断
         * interrupt()          设置线程为中断状态
         * interrupted()        在检测完之后会清除线程的中断状态
         * isInterrupted()      在检测完之后不会清除线程的中断状态（它比较单纯，说只判断就只做判断）
         */
        System.out.println(Thread.currentThread().getName() +"线程数是否被中断："+Thread.currentThread().isInterrupted()); //
        System.out.println(Thread.currentThread().getName() +"线程数是否被中断："+Thread.currentThread().isInterrupted());//
    }
}
