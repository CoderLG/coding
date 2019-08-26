package rember.mythread;
/**
 * author: LG
 * date: 2019-06-19 11:12
 * desc:
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    business.sub(i);
                }

            }
        }).start();

        for (int i = 1; i <= 10; i++) {
            business.main(i);
        }
    }
}

class Business {
    private boolean isMainThread = true;


    public synchronized void sub(int i) {
        while (!isMainThread) {
            try {
                System.out.println("sub thread wait");
               this.wait();
                // "AA".wait();
            /*    synchronized (Locks.engineLock) {
                    Locks.engineLock.wait();
                }*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequence of " + j + ",loop of " + i);
        }
        isMainThread = false;
        System.out.println("sub thread notify");
        this.notify();
        //"AA".notify();
      /*  synchronized (Locks.engineLock) {
            Locks.engineLock.notify();
        }*/
    }

    public synchronized void main(int i) {
        while (isMainThread) {
            try {
                System.out.println("main thread wait");
                this.wait();
              //  "AA".wait();
               /* synchronized (Locks.engineLock) {
                    Locks.engineLock.wait();
                }*/

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("main thread sequence of " + j + ",loop of " + i);
        }
        isMainThread = true;
        System.out.println("main thread notify");
        this.notify();
       // "AA".notify();
        /*synchronized (Locks.engineLock) {
            Locks.engineLock.notify();            //不行没有成功
        }*/

    }
}
