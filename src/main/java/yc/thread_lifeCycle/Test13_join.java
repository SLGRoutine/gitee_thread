package yc.thread_lifeCycle;

/**
 * join方法  需要用Thread对象调用  使一个线程在另一个线程执行完再执行
 * 在一个线程（main）中有另一个线程对象调用join（），则当前线程（main）阻塞，让另一个线程先执行后，当前才执行，与优先级无关
 * 在主线程中，另一个线程对象调用join方法，则另一个线程先执行，后执行main方法
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test13_join {
    public static void main(String[] args) throws InterruptedException {
        LifeCirele lc = new LifeCirele();
        System.out.println(lc.isAlive());//线程状态值

        lc.start();
        System.out.println(lc.isAlive());

//        lc.join();//TODO :让lc先执行，在执行main
        //可以理解为将main线程挂起，lc执行完后执行main

        System.out.println("主线程的其他操作。。。。");
        System.out.println(lc.isAlive());
    }
}

class LifeCirele extends Thread{
    @Override
    public void run() {
        int i = 0;
        while ((++i)<10){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
