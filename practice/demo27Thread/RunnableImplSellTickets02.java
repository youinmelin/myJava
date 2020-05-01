package demo27Thread;

public class RunnableImplSellTickets02 implements Runnable{
    private int ticketsNum = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticketsNum > 0) {
                    // try {
                    //     Thread.sleep(10);
                    // } catch (Exception e) {
                    //     System.out.println(e);
                    // }
                    System.out.println(Thread.currentThread() + "tickets No.:" + ticketsNum);
                    ticketsNum--;
                }else {
                    return;
                }
            }
        }
    }

}