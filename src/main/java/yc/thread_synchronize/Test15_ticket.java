package yc.thread_synchronize;

import java.util.Random;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test15_ticket {
    public static void main(String[] args) {
        SellTicketOp sto = new SellTicketOp(240);

        for (int i =0;i<50;i++){
            Thread counter1 = new Thread(sto,"售票员---"+i);
            counter1.start();
        }
    }

}

class SellTicketOp implements Runnable{

    int tickets;//票数

    public SellTicketOp(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public   synchronized void run() {
//        循环买票
        while (true){
//            24个线程，抢占SellTicketOp类的对象的锁
           synchronized (   this   ){       // --SellTicketOp类的对象
               if (this.tickets>0){
                   System.out.println(Thread.currentThread().getName()+"正在售出第"+(tickets--)+"张票");
                   try {
                       /**
                        * sleep和wait的区别  //sleep()当前线程不会释放锁
                        * Object 的wait(等待时会释放锁)
                        */
//                       Thread.sleep(new Random().nextInt(50));
                      wait(new Random().nextInt(50));
//                      以上程序为什么不会结束，因为wait状态的线程，处于等待队列，如果没有唤醒-》就不会进入就绪状态，程序就调不到这个任务
                      this.notifyAll();//wait要配合notifyAll()函数使用，不然程序不会停止
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               else {
                   return;
               }
           }
        }
    }
}
