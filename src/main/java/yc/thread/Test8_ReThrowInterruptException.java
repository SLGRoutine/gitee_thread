package yc.thread;

/**
 * @author SLGRoutine
 * @date 2024/7/14
 */
public class Test8_ReThrowInterruptException {
    public static void main(String[] args) {
        //当前线程
        Thread thread = Thread.currentThread();

        try {

            thread.interrupt();

            Thread.sleep(3000);//因为被中断，所以sleep抛出异常
        } catch (InterruptedException e) {
            System.out.println(thread.getName()+"抛出InterruptException中断异常");
            System.out.println(thread.getName()+"做出一些清理工作");

            System.out.println(thread.isInterrupted());

        }

        System.out.println("此时我的主程序还能正常运行吗");//能执行
    }
}
