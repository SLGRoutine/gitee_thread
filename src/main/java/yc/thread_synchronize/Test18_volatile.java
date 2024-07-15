package yc.thread_synchronize;

/**
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class Test18_volatile {
    public static void main(String[] args) {

        Task task1 = new Task();
        Thread thread1 = new Thread(task1,"线程1");
        thread1.start();

//        在启动一个线程去关闭上面的线程
       Thread thread2 =  new Thread(()->{
           try {
               Thread.sleep(1000);
               System.out.println("在线程2中改变 stop的值，以停止线程1");
               task1.stop=true;
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

//           task1.stop=true;
       });

       thread2.start();

    }
}

class Task implements Runnable {
     volatile boolean stop = false;
//     boolean stop = false;
    int i = 0;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (!stop){
            i++;
        }
        System.out.println("线程:"+Thread.currentThread().getName()+"的运行时间为："+(System.currentTimeMillis()-start));
    }
}