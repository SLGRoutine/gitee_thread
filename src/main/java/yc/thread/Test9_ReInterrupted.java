package yc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test9_ReInterrupted extends Thread{
    public static void main(String[] args) throws InterruptedException {
        //当前main线程
        String threadName = Thread.currentThread().getName();
//        创建线程
        Test9_ReInterrupted test9ReInterrupted  = new Test9_ReInterrupted();
        System.out.println(printFormatDate()+threadName+"线程启动");
//        启动线程
        test9ReInterrupted.start();

        Thread.sleep(3000);
        System.out.println(printFormatDate()+threadName+"发出中断信号");
//        对新线程设置中断信号
        test9ReInterrupted.interrupt();

        //线程休眠三秒
//        Thread.sleep(3000);
        System.out.println(printFormatDate()+threadName+"运行结束！");

    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int i = 0;
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(printFormatDate()+threadName+"线程正在执行第"+(++i)+"次");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(printFormatDate()+threadName+"线程正在执行，收到终端信号，进入catch块执行");
                //检查是否中断
                System.out.println(printFormatDate()+threadName+"的状态为"+Thread.currentThread().isInterrupted());
                //TODO :如果不需要 则不用调用  如果调用 interrupt()的话，当前线程会被中断，循环结束
//                Thread.currentThread().interrupt();//TODO 只有线程中断状态不为true，循环才会继续
            }
        }

        System.out.println(printFormatDate()+threadName+"线程是否被中断"+this.isInterrupted());
        System.out.println(printFormatDate()+threadName+"线程退出");
    }

    private static String printFormatDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日：hh时mm分ss秒");
        return  sdf.format(new Date())+" ";
    }


}
