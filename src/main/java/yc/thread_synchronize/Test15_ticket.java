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
    public synchronized void run() {
//        循环买票
        while (true){
//            24个线程，抢占SellTicketOp类的对象的锁
           synchronized (   this   ){       // --SellTicketOp类的对象
               if (this.tickets>0){
                   System.out.println(Thread.currentThread().getName()+"正在售出第"+(tickets--)+"张票");

                   try {
                       Thread.sleep(new Random().nextInt(50));
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
