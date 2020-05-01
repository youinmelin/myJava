package demo27Thread;

public class RunnableImplSellTickets implements Runnable{
    private int ticketsNum = 100;
    
    @Override
    public void run() {
        while (true) {
            if (ticketsNum > 0) {
                System.out.println(Thread.currentThread() + "tickets No.:" + ticketsNum);
                ticketsNum--;
            }else {
                return;
            }
        }
    }

}