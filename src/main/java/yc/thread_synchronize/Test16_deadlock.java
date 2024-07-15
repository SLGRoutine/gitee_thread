package yc.thread_synchronize;

/**
 * 死锁
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class Test16_deadlock implements Runnable{
    /**
     * 死锁的解决：
     * 1.查找死锁的位置：Dump Threads
     * 2.破坏任意一个死锁条件
     */
    public int flag = 1;
    static Object o1 = new Object(),o2 = new Object();
//    这里的o1,o2就是一个锁对象
//    Object对象本身并不作为锁，但是能用来实现锁的机制

    public static void main(String[] args) {
        Test16_deadlock t1 = new Test16_deadlock();
        Test16_deadlock t2 = new Test16_deadlock();
        t1.flag = 1;
        t2.flag = 2;
        new Thread(t1).start();
        new Thread(t2).start();
    }

    @Override
    public void run() {
        System.out.println("Flag = "+flag);
        if (flag==1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }
        /**
         * 此时，线程一已经获取了o1锁，正在常识获取o2锁
         * 但是 线程二已经获取了o2锁，却在尝试获取o1锁
         * 两者之间存在互斥关系
         */
        if (flag==2){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o1){
                    System.out.println("2");
                }
            }
        }
    }
}
