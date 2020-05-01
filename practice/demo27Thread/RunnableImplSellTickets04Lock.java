package demo27Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImplSellTickets04Lock implements Runnable {
    private int ticketsNum = 100;
    Lock lock = new ReentrantLock();

    public void sellTickets() {
                if (ticketsNum > 0) {
                    try {
                        Thread.sleep(10);
                        //lock.wait(10);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState() + "tickets No.:" + ticketsNum);
                    ticketsNum--;
                }else {
                    return;
                }
            }
 
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                sellTickets();
            } catch (Exception e) {
                System.out.println(e);
            }finally { 
                lock.unlock();
            } 
       }
    }

}