package demo27Thread;

public class RunnableImplSellTickets03SynFun implements Runnable {
    private int ticketsNum = 100;

    public synchronized void sellTickets() {
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
 
    @Override
    public void run() {
        while (true) {
            sellTickets();
       }
    }

}