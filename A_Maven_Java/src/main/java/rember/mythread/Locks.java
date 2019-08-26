package rember.mythread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author: LG
 * date: 2019-06-19 13:52
 * desc:
 */
public class Locks {

    public static ReentrantLock userTaskQueuesLock = new ReentrantLock();
    public static ReentrantLock workerNumLock = new ReentrantLock();
    public static ReentrantLock requestQueueLock = new ReentrantLock();
    // public static ReentrantLock systeamResourceLock = new ReentrantLock();
    // public static ReentrantLock userResourceLock = new ReentrantLock();
    public static ReentrantLock resourceLock = new ReentrantLock();
    public static ReentrantLock engineLock = new ReentrantLock();
    public static ReentrantLock operatorQueueLock = new ReentrantLock();
    public static Object operatorListLock = new Object();
    //public static ReentrantLock operatorExecuteLock = new ReentrantLock();
}
