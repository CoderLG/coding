package rember.mythread;

/**
 * author: LG
 * date: 2019-06-17 09:34
 * desc: 只能在自己的synchronized下对自己进行wait 和 notify
 */
public class MyThread1 extends Thread{
    private String name;
    public MyThread1(String name) {
        super(name);
        this.name = name;
    }
    public static boolean f = true;

    @Override
    public void run() {

        if (Thread.currentThread().getName().equals("A")) {
            System.out.println(Thread.currentThread().getName() + "线程运行开始，我将AA锁住 ");
            synchronized (Locks.engineLock) {
                try {
                    Locks.engineLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程运行开始 , AA的锁被打开了！！！！！！ ");
            }
        }
        if (Thread.currentThread().getName().equals("B")) {
            try {
                System.out.println(Thread.currentThread().getName() + "线程睡5秒!");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Locks.engineLock){
                System.out.println(Thread.currentThread().getName() + "线程运行开始，我将AA的锁打开");
                Locks.engineLock.notify();
            }
        }

        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        MyThread1 mTh1 = new MyThread1("A");
        MyThread1 mTh2 = new MyThread1("B");
        mTh1.start();
        mTh2.start();

        /*
        try {
            System.out.println(Thread.currentThread().getName() + "主线程睡5秒!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Locks.engineLock) {
            System.out.println(Thread.currentThread().getName() + "主线程打开锁!");
            Locks.engineLock.notify();
        }*/
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }
}
