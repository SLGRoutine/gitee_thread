package yc.thread;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test7_isInterrupted {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName()+"线程是否中断："+thread.isInterrupted());//false

        //TODO 测试这句话设置线程中断标志
        thread.interrupt();

        System.out.println(thread.getName()+"线程是否中断："+thread.isInterrupted());///ture
        System.out.println(thread.getName()+"线程是否中断："+thread.isInterrupted());//true

        try {
//            线程休眠5秒
            Thread.sleep(2000);//本来主线程要被休眠2秒的，但是因为interrupt被调用，所以sleep被打断
            System.out.println("线程休眠为被中断。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();

            System.out.println("线程休眠未被中断");
//            判断线程是否中断，因为异常已经被处理，所以状态回复为false,扩展：在catch中写处理代码
            System.out.println(thread.getName()+"线程是否中断："+thread.isInterrupted());//false
        }
//        isInterrupted()不会恢复线程的中断状态
        System.out.println(thread.getName()+"线程是否中断："+thread.isInterrupted());//false
    }

}
