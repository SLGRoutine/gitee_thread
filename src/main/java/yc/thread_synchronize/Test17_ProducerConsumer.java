package yc.thread_synchronize;

import java.util.Random;

/**
 * @author SLGRoutine
 * @date 2024/7/15
 */
public class Test17_ProducerConsumer {

    public static void main(String[] args) {
        AppleBox ab  = new AppleBox();

        //
        Producer p = new Producer(ab);
        Producer p1 = new Producer(ab);
        Comnsumer c1 = new Comnsumer(ab);
        new Thread(p).start();
        new Thread(p1).start();
        new Thread(c1).start();

    }
}
/**
 * 消息
 */
class  Apple{
    int id;
    public Apple(int id) {
        this.id = id;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}

/**
 * 消息队列
 */
class AppleBox{
    Apple[] apples = new Apple[5];
    int index = 0; //index表示当前有几条消息
    //生产后存消息
    public synchronized void deposite(Apple apple){
        if (index == apples.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return;
        }
        apples[index] = apple;
            this.notifyAll();//总之一个原则，只要wait了就要notifyAll();
        index++;
    }
    //消费消息
    public synchronized Apple withdraw(){
        if (index ==0){

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        index--;
        this.notifyAll();//总之一个原则，只要wait了就要notifyAll();
        return apples[index];
    }
}

/**
 * 生产消息的任务Task，一次生产五次消息
 */
class Producer implements Runnable{
    AppleBox ab = null;
    Producer(AppleBox ab){
        this.ab =ab;
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            Random r = new Random();
            Apple a = new Apple(i);
            ab.deposite(a);//存
            System.out.println(Thread.currentThread().getName()+"生产了"+a);
            try {
                Thread.sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 消费端
 */
class Comnsumer implements Runnable{
    AppleBox ab = null;
    Comnsumer(AppleBox ab){
        this.ab =ab;
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            Random r = new Random();
            Apple a =  ab.withdraw();
            System.out.println(Thread.currentThread().getName()+"消费了"+a);
            try {
                Thread.sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
