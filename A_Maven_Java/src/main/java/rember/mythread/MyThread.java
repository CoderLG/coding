package rember.mythread;

/**
 * author: LG
 * date: 2019-06-17 09:34
 * desc: 如果B先进线程 sleep 并不会让出CPU  ，当A先进入的话 wait可以让出cpu
 */
public class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        super(name);
        this.name = name;
    }
    public static boolean f = true;

    @Override
    public void run() {

        synchronized ("AA"){
            System.out.println(Thread.currentThread().getName() + "线程运行开始 ");
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程" + name + "运行： " + i);
                if (i == 0 && Thread.currentThread().getName().equals("B")){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i == 1 && Thread.currentThread().getName().equals("A")){
                    try {
                        System.out.println(Thread.currentThread().getName() + "我让出cpu");
                        "AA".wait();
                        //"BB".wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(i == 1){
                    System.out.println(Thread.currentThread().getName() + "我唤醒一个锁,并睡一下");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    "AA".notify();
                }
            }

        }

        synchronized ("BB"){

        }


        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        MyThread mTh1 = new MyThread("A");
        MyThread mTh2 = new MyThread("B");
        mTh1.start();
        mTh2.start();
       /*
        try{
            mTh1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        try{
            mTh2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        */
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }
}
